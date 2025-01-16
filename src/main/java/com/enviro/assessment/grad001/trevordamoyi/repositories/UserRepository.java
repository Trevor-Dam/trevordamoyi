package com.enviro.assessment.grad001.trevordamoyi.repositories;

import com.enviro.assessment.grad001.trevordamoyi.migrations.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    //void findByEmailAndPassword(String , String );
    @Query("select u from User u where u.email = ?1 and u.password = ?2")
    User findByEmailAndPassword(String email, String password);

    @Query("select (count(u) > 0) from User u where u.email = :email and u.password = :password")
    boolean existsByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}