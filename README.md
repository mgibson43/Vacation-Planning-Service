# WESTERN GOVERNOR UNIVERSITY 
## D288 – BACK-END PROGRAMMING
## Matthew Gibson
## 11/04/2023

### Task B
* Created starter files with the Spring Initializer
* Added files to project

### Task C
* Refactored com.example.demo to edu.wgu.backend
* edu.wgu.backend: created config, controllers, dao, entities, and services packages
<br><br>
* RestDataConfig.java: copied file into package
* RestDataConfig.java - Line 3: changed package name to match project
* RestDataConfig.java - Lines 37-41: temporarily commented out lines to avoid errors
<br><br>
* application.properties - lines 1-14: copied content from provided file

### Task D
* edu.wgu.backend.entities - lines 10-35: created Country.java class and added fields
* edu.wgu.backend.entities - lines 11-49: created Cart.java class and added fields
* edu.wgu.backend.entities - lines 10-40: created CartItem.java class and added fields
* edu.wgu.backend.entities - lines 11-42: created Vacation.java class and added fields
* edu.wgu.backend.entities - lines 11-46: created Excursion.java class and added fields
* edu.wgu.backend.entities - lines 10-51: created Customer.java class and added fields
* edu.wgu.backend.entities - lines 9-35: created Division.java class and added fields
* edu.wgu.backend.entities - line 4: created StatusType.java enum and added fields
<br><br>
* edu.wgu.backend.entities: removed placeholder.md
<br><br>
* Division.java - line 30: added arguments to @OneToMany annotation
* Customer.java - line 46: added arguments to @OneToMany annotation
* Cart.java - line 44: added arguments to @OneToMany annotation
* Cart.java - lines 22, 25: changed vacation mapping to @ManyToOne and changed excursion mapping to @OneToMany
* Vacation.java - line 37: added arguments to @OneToMany annotation
* CartItem.java - lines 25-30: changed @OneToMany annotation to @ManyToMany and added a join table to Excursion
* Excursion.java - lines 41-46: changed @OneToMany annotation to @ManyToMany and added a join table to CartItem

### Task E
* edu.wgu.backend.dao: deleted placeholder.md
* edu.wgu.backend.dao: created repository interface and added cross-origin support for country, customer, division, excursion, vacation, cart, and cartitem entities

### Task F
* edu.wgu.backend.services: created CheckoutService interface;
* edu.wgu.backend.services: created CheckoutServiceImpl, Purchase, and PurchaseResponse classes
<br><br>
* CheckoutService.java - line 5: added placeOrder method
* CheckoutServiceImpl.java - lines 26-42: added method to save cart to customer and return a purchase response
* CheckoutServiceImpl.java - lines 44-49: added method to create order tracking number
<br><br>
* PurchaseResponse.java - line 13: added field for orderTrackingNumber
<br><br>
* Purchase.java - lines 15-19: added fields for customer, cart, and cartItems
* CheckoutServiceImpl - line 37: set cart status to ordered

### Task G
* edu.wgu.backend.entities: added nullable = false to all fields of all entities except create and update times
* edu.wgu.backend.entities: added updatable = false to the create dates of all entities
* edu.wgu.backend.entities: changed all sets to hashsets
* Division.java - line 49: added connection from division entity to customer entity

### Task H
* edu.wgu.backend.controllers: created CheckoutController.java
* CheckoutController.java lines 10-12: set cross origin and request mapping to "/api/checkout"
* CheckoutController.java lines 18-20: created CheckoutController constructor that takes in a checkout service
* CheckoutController.java lines 22-28: Created PostMapping "/purchase" and created a placeOrder method taking a purchase from the request body and returning a purchase response

### Task I
* edu.wgu.backend: created BootStrapData.java file
* BootStrapData.java lines 12-18: initialized fields and created a constructor for the class
* BootStrapData.java lines 23-72: check if database is at default state, if so, adds 5 customers

