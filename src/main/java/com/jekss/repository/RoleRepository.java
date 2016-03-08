package com.jekss.repository;

import com.jekss.entityes.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by jekss on 11.10.15.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("select r from Role r where r.role = :role")
    Role findByName(@Param("role")String role);
}
