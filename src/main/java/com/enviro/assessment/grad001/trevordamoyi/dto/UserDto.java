package com.enviro.assessment.grad001.trevordamoyi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

/**
 * DTO for {@link com.enviro.assessment.grad001.trevordamoyi.migrations.User}
 */
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class UserDto implements Serializable {
    @JsonProperty(value = "id")
    private final Integer id;
    @NotNull
    @Size(max = 50)
    @JsonProperty(value = "email")
    private final String email;
    @NotNull
    @Size(max = 100)
    @JsonProperty(value = "name")
    private final String name;
    @NotNull
    @Size(max = 255)
    @JsonProperty(value = "surname")
    private final String surname;
    @NotNull
    @JsonProperty(value = "communityLeader")
    private final Integer communityleader;
    @JsonProperty(value = "score")
    @JsonSetter(nulls = Nulls.DEFAULT)
    private final Integer score;
    @NotNull
    @Size(max = 50)
    @JsonProperty(value = "role")
    private final String userrole;
}