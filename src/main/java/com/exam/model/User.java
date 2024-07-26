package com.exam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User  implements UserDetails {
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

     @Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
          Set<Authority> set = new HashSet<>();

          this.userRoles.forEach(userRole ->{
               set.add(new Authority(userRole.getRole().getRoleName()));
          } );
     return  null;
     }

     @Override
     public boolean isAccountNonExpired() {
          return true;
     }

     @Override
     public boolean isAccountNonLocked() {
          return true;
     }

     @Override
     public boolean isCredentialsNonExpired() {
          return true;
     }
}
