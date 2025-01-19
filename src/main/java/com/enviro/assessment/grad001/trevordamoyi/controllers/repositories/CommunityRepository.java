package com.enviro.assessment.grad001.trevordamoyi.controllers.repositories;

import com.enviro.assessment.grad001.trevordamoyi.controllers.migrations.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Integer> {
  @Query("select c from Community c where c.area = :area")
  Community findByArea(@Param("area") String area);
}