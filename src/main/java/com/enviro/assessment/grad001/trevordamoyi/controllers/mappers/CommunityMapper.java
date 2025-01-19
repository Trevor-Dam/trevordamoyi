package com.enviro.assessment.grad001.trevordamoyi.controllers.mappers;

import com.enviro.assessment.grad001.trevordamoyi.controllers.dto.CommunityDto;
import com.enviro.assessment.grad001.trevordamoyi.controllers.migrations.Community;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommunityMapper {
    @Mapping(source = "id", target = "id")
    Community toEntity(CommunityDto communityDto);

    @Mapping(source = "id", target = "id")
    CommunityDto toDto(Community community);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Community partialUpdate(CommunityDto communityDto, @MappingTarget Community community);
}