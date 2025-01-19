package com.enviro.assessment.grad001.trevordamoyi.controllers.repositories;

import com.enviro.assessment.grad001.trevordamoyi.controllers.migrations.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //void findByEmailAndPassword(String , String );


    @Query("select (count(u) > 0) from User u where u.email = :email and u.password = :password")
    boolean existsByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query("select u from User u where u.email = :email and u.password = :password")
    User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query("select count(u) from User u")
    long countUsers();

    @Query("select (count(u) > 0) from User u where u.email = :email")
    boolean existsByEmail(@Param("email") String email);

    @Query("select u from User u where u.id = :id order by u.id")
    Optional<User> findByIdOrderByIdAsc(@Param("id") @NonNull Integer id);


}