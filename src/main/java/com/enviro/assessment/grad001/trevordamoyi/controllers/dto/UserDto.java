package com.enviro.assessment.grad001.trevordamoyi.controllers.dto;

import com.enviro.assessment.grad001.trevordamoyi.controllers.migrations.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Getter
@Setter
@EqualsAndHashCode
@Accessors(chain = true)
public class UserDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 50)
    private String email;
    @NotNull
    @Size(max = 255)
    private String password;
    @NotNull
    @Size(max = 100)
    private String name;
    @NotNull
    @Size(max = 255)
    private String surname;
    @NotNull
    private Integer communityleader;
    private Integer score;
    @NotNull
    @Size(max = 50)
    private String userrole;
    @NotNull
    private CommunityDto communityID;

    public UserDto(Integer id, String email,String password, String name, String surname, Integer communityleader, Integer score, String userrole, CommunityDto communityID) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.communityleader = communityleader;
        this.score = score;
        this.userrole = userrole;
        this.communityID = communityID;
    }
}