package edu.wgu.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="cart_items")
@Getter
@Setter
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_item_id")
    private Long id;

    @Column(name="vacation_id")
    @OneToMany
    private Vacation vacation;

    @ManyToOne
    private Set<Excursion> excursions;

    @Column(name="cart_id")
    @ManyToOne
    private Cart cart;

    @Column(name="create_date")
    private Date createDate;

    @Column(name="last_update")
    private Date lastUpdate;

    public CartItem() {

    }
}
