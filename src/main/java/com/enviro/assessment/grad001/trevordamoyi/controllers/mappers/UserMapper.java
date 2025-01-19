package com.enviro.assessment.grad001.trevordamoyi.controllers.mappers;

import com.enviro.assessment.grad001.trevordamoyi.controllers.dto.UserDto;
import com.enviro.assessment.grad001.trevordamoyi.controllers.migrations.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(source = "id", target = "id")
    User toEntity(UserDto userDto);

    @Mapping(source = "id", target = "id")
    UserDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDto userDto, @MappingTarget User user);
}