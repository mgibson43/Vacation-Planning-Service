package edu.wgu.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="cart_items")
@Getter
@Setter
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_item_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="vacation_id", nullable = false)
    private Vacation vacation;

    @ManyToMany
    @JoinTable(
            name="excursion_cartitem",
            joinColumns=@JoinColumn(name="cart_item_id", nullable = false),
            inverseJoinColumns=@JoinColumn(name="excursion_id", nullable = false)
    )
    private Set<Excursion> excursions;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable = false)
    private Cart cart;

    @Column(name="create_date")
    @CreationTimestamp
    private Date createDate;

    @Column(name="last_update")
    @UpdateTimestamp
    private Date lastUpdate;
}
