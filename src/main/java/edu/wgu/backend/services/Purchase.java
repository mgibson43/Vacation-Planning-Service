package edu.wgu.backend.services;

import edu.wgu.backend.entities.Cart;
import edu.wgu.backend.entities.CartItem;
import edu.wgu.backend.entities.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {

    private Customer customer;

    private Cart cart;

    private Set<CartItem> cartItems;
}
