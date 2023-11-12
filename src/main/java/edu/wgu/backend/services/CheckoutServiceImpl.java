package edu.wgu.backend.services;

import edu.wgu.backend.dao.CartRepository;
import edu.wgu.backend.dao.CustomerRepository;
import edu.wgu.backend.entities.Cart;
import edu.wgu.backend.entities.CartItem;
import edu.wgu.backend.entities.Customer;
import edu.wgu.backend.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();
        Set<CartItem> cartItems = purchase.getCartItems();
        String orderTrackingNumber = generateOrderTrackingNumber();

        cartItems.forEach(item -> {
            item.setCart(cart);
            cart.add(item);
        });

        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(StatusType.ordered);
        customer.add(cart);

        cartRepository.save(cart);
        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString();
    }
}
