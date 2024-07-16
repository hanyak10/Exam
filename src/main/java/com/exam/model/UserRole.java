package com.exam.model;

import jakarta.persistence.*;

@Entity
public class UserRole {
    @Id
    @GeneratedValue
    private  Long userRoleId;


    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne
    private role role;


}
