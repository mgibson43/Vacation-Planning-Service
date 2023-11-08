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

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();

        String orderTrackingNumber = getOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.getCartItem().add(item));
        cart.setStatus(StatusType.ORDERED);

        Customer customer = purchase.getCustomer();
        customer.getCarts().add(cart);

        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String getOrderTrackingNumber() {

        String orderTrackingNumber = UUID.randomUUID().toString();

        return orderTrackingNumber;
    }
}
