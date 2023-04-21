package com.asi.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String surname;
    private String idNumber;
    private String email;
    private String password;
    private Boolean subscribed;
    private Boolean disabled;
    private Boolean freelancer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;
    private Long role_id;

}
