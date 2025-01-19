package com.enviro.assessment.grad001.trevordamoyi.controllers.migrations;

import com.enviro.assessment.grad001.trevordamoyi.controllers.dto.ScoreDto;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

/**
 * Projection for {@link Score}
 */
@Projection(types = {ScoreDto.class, Score.class})
public interface ScoreInfo {
    Integer getId();

    LocalDate getScoredate();

    Integer getScore();

    Integer getNoofinfractions();

    UserInfo getUserid();
}