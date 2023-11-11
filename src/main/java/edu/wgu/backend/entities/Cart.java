package edu.wgu.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="carts")
@Getter
@Setter
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id", nullable = false)
    private Long id;

    @Column(name="order_tracking_number", nullable = false)
    private String orderTrackingNumber;

    @Column(name="package_price", nullable = false)
    private BigDecimal package_price;

    @Column(name="party_size", nullable = false)
    private int party_size;

    @Column(name="status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @Column(name="create_date", updatable = false)
    @CreationTimestamp
    private Date create_date;

    @Column(name="last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable = false)
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItems = new HashSet<>();

    public void add(CartItem item) {
        this.cartItems.add(item);
    }
}
