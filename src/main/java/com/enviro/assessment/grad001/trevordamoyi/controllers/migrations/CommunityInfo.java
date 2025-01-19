package com.enviro.assessment.grad001.trevordamoyi.controllers.migrations;

import com.enviro.assessment.grad001.trevordamoyi.controllers.dto.CommunityDto;
import org.springframework.data.rest.core.config.Projection;

/**
 * Projection for {@link Community}
 */
@Projection(types = {CommunityDto.class, Community.class})
public interface CommunityInfo {
    Integer getId();

    String getArea();

    Integer getCommunityscore();

    Double getAverageinfractions();
}