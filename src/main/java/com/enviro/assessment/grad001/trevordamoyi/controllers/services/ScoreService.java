package com.enviro.assessment.grad001.trevordamoyi.controllers.services;

import com.enviro.assessment.grad001.trevordamoyi.controllers.dto.ScoreDto;
import com.enviro.assessment.grad001.trevordamoyi.controllers.mappers.ScoreMapper;
import com.enviro.assessment.grad001.trevordamoyi.controllers.mappers.UserMapper;
import com.enviro.assessment.grad001.trevordamoyi.controllers.repositories.ScoreRepository;
import org.hibernate.type.descriptor.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    public void updateScore(ScoreDto scoreDto) {
        scoreRepository.updateScoredateAndScoreAndNoofinfractionsByUserid(LocalDate.now(), scoreDto.getScore() + 1, scoreDto.getNoofinfractions() + 1, userMapper.toEntity(scoreDto.getUserid()));
    }
}
