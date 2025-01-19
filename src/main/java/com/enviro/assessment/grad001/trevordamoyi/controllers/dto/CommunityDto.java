package com.enviro.assessment.grad001.trevordamoyi.controllers.dto;

import com.enviro.assessment.grad001.trevordamoyi.controllers.migrations.Community;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

/**
 * DTO for {@link Community}
 */
@Getter
@EqualsAndHashCode
public class CommunityDto implements Serializable {
    private final Integer id;
    @NotNull
    @Size(max = 100)
    private final String area;
    @NotNull
    private final Integer communityscore;
    @NotNull
    private final Double averageinfractions;

    public CommunityDto(Integer id, String area, Integer communityscore, Double averageinfractions) {
        this.id = id;
        this.area = area;
        this.communityscore = communityscore;
        this.averageinfractions = averageinfractions;
    }
}