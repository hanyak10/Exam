package com.exam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private  long id;
     private String username;
     private String password;
     private String firstname;
     private String lastname;
     private String email;
     private String phone;
     private boolean enabled = true;
     private String profile;


     // user can have many roles so we will use set/list for the same
     @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
     @JsonIgnore
     private Set<UserRole> userRoles= new HashSet<>();
}
