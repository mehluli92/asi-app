package com.asi.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address1;
    private String address2;
    private String city;
    private String country;
    private String phoneNumber;
    private String mobileNumber;
    @OneToOne(mappedBy = "contact")
    private User user;
}
