package com.jekss.repository;

import com.jekss.entityes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by jekss on 11.10.15.
 */
public interface UserRepository extends JpaRepository<User, Integer>{

    @Query("select u from User u where u.name = :name")
    User findByName(@Param("name")String name);

    @Query("select u from User u where u.login = :login")
    User findByLogin(@Param("login") String login);

    @Query("select u from User u where u.email = :email")
    User findByEmail(@Param("email") String email);
}
