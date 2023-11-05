package edu.wgu.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="vacations")
@Getter
@Setter
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vacation_id")
    private Long id;

    @Column(name="vacation")
    private String vacationTitle;

    @Column(name="description")
    private String description;

    @Column(name="travel_price")
    private BigDecimal travelPrice;

    @Column(name="create_date")
    private Date createDate;

    @Column(name="last_update")
    private Date lastUpdate;

    @OneToMany
    private Set<Excursion> excursions;

    public Vacation() {

    }
}
