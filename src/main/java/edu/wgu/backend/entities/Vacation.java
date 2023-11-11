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
@Table(name="vacations")
@Getter
@Setter
@NoArgsConstructor
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vacation_id", nullable = false)
    private Long id;

    @Column(name="vacation_title", nullable = false)
    private String vacation_title;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="travel_fare_price", nullable = false)
    private BigDecimal travel_price;

    @Column(name="image_url", nullable = false)
    private String image_URL;

    @Column(name="create_date", updatable = false)
    @CreationTimestamp
    private Date create_date;

    @Column(name="last_update")
    @UpdateTimestamp
    private Date last_update;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacation_title")
    private Set<Excursion> excursions = new HashSet<>();
}
