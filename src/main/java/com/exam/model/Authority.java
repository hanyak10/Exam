package com.exam.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
@Data
@AllArgsConstructor
public class Authority implements GrantedAuthority {
    private  String authority;

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
