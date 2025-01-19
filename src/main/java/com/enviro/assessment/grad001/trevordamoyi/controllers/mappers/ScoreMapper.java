package com.enviro.assessment.grad001.trevordamoyi.controllers.mappers;

import com.enviro.assessment.grad001.trevordamoyi.controllers.dto.ScoreDto;
import com.enviro.assessment.grad001.trevordamoyi.controllers.migrations.Score;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ScoreMapper {
    @Mapping(source = "id", target = "id")
    Score toEntity(ScoreDto scoreDto);

    @Mapping(source = "id", target = "id")
    ScoreDto toDto(Score score);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Score partialUpdate(ScoreDto scoreDto, @MappingTarget Score score);
}