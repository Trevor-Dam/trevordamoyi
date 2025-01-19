package com.enviro.assessment.grad001.trevordamoyi.controllers.dto;

import com.enviro.assessment.grad001.trevordamoyi.controllers.migrations.Score;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Score}
 */
@Getter
@EqualsAndHashCode
public class ScoreDto implements Serializable {
    private final Integer id;
    @NotNull
    private final UserDto userid;
    @NotNull
    private final LocalDate scoredate;
    @NotNull
    private final Integer score;
    @NotNull
    private final Integer noofinfractions;

    public ScoreDto(Integer id, UserDto userid, LocalDate scoredate, Integer score, Integer noofinfractions) {
        this.userid = userid;
        this.scoredate = scoredate;
        this.noofinfractions = noofinfractions;
        this.id = id;
        this.score = score;
    }
}