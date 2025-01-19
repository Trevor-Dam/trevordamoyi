package com.enviro.assessment.grad001.trevordamoyi.controllers.repositories;

import com.enviro.assessment.grad001.trevordamoyi.controllers.migrations.Score;
import com.enviro.assessment.grad001.trevordamoyi.controllers.migrations.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {
  @Transactional
  @Modifying
  @Query("""
          update Score s set s.scoredate = :scoredate, s.score = :score, s.noofinfractions = :noofinfractions
          where s.userid = :userid""")
  void updateScoredateAndScoreAndNoofinfractionsByUserid(@Param("scoredate") LocalDate scoredate, @Param("score") Integer score, @Param("noofinfractions") Integer noofinfractions, @Param("userid") User userid);

}