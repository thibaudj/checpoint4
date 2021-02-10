package com.checkpoint4.api.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    @NotBlank
    @Size(min = 3, max = 30)
    private String firstname;

    @NotBlank
    @Size(max = 30)
    private String lastname;

    private Date birthDate;

    private char gender;

    private String photoUrl;

    private String address;

    private int zipCode;

    private String city;

    private int mobileNumber;

    private int phoneNumber;

    @OneToMany(targetEntity = Subscription.class, mappedBy = "person")
    private List<Subscription> subscriptions = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
