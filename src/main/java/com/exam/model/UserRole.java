package com.exam.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserRole {
    @Id
    @GeneratedValue
    private  Long userRoleId;


    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne
    private Role role;


}
