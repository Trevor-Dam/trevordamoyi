package com.enviro.assessment.grad001.trevordamoyi.controllers.migrations;

import com.enviro.assessment.grad001.trevordamoyi.controllers.dto.UserDto;
import org.springframework.data.rest.core.config.Projection;

/**
 * Projection for {@link User}
 */
@Projection(types = {UserDto.class, User.class})
public interface UserInfo {
    Integer getId();

    String getEmail();

    String getPassword();

    String getName();

    String getSurname();

    Integer getCommunityleader();

    Integer getScore();

    String getUserrole();

    CommunityInfo getCommunityID();
}