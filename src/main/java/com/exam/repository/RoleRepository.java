package com.exam.repository;

import com.exam.model.role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<role,Long> {
}
