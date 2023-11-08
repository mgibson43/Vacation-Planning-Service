package edu.wgu.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="excursions")
@Getter
@Setter
@NoArgsConstructor
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="excursion_id", nullable = false)
    private Long id;

    @Column(name="excursion_title", nullable = false)
    private String excursion_title;

    @Column(name="excursion_price", nullable = false)
    private BigDecimal excursion_price;

    @Column(name="image_url", nullable = false)
    private String image_URL;

    @Column(name="create_date")
    @CreationTimestamp
    private Date createDate;

    @Column(name="last_update")
    @UpdateTimestamp
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name="vacation_id", nullable = false)
    private Vacation vacation;

    @ManyToMany
    @JoinTable(
            name="excursion_cartitem",
            joinColumns=@JoinColumn(name="excursion_id", nullable = false),
            inverseJoinColumns=@JoinColumn(name="cart_item_id", nullable = false)
    )
    private Set<CartItem> cartItems;
}
