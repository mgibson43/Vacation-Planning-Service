package edu.wgu.backend.services;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
