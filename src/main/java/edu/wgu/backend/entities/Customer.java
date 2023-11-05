package edu.wgu.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="customers")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Long id;

    @Column(name="customer_first_name")
    private String firstName;

    @Column(name="customer_last_name")
    private String lastName;

    @Column(name="address")
    private String address;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name="phone")
    private String phone;

    @Column(name="create_date")
    private Date createDate;

    @Column(name="last_update")
    private Date lastUpdate;

    @Column(name="division_id")
    @ManyToOne
    private Division division;

    @OneToMany
    private Set<Cart> carts;

    public Customer() {

    }
}
