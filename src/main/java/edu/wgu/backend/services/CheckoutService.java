package edu.wgu.backend.services;

import edu.wgu.backend.services.dto.Purchase;
import edu.wgu.backend.services.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
