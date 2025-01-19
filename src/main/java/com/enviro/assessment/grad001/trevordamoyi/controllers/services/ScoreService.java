package com.enviro.assessment.grad001.trevordamoyi.controllers.services;

import com.enviro.assessment.grad001.trevordamoyi.controllers.dto.ScoreDto;
import com.enviro.assessment.grad001.trevordamoyi.controllers.dto.UserDto;
import com.enviro.assessment.grad001.trevordamoyi.controllers.mappers.ScoreMapper;
import com.enviro.assessment.grad001.trevordamoyi.controllers.mappers.UserMapper;
import com.enviro.assessment.grad001.trevordamoyi.controllers.migrations.Score;
import com.enviro.assessment.grad001.trevordamoyi.controllers.migrations.ScoreInfo;
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


    private ScoreInfo scoreInfo;

    public void updateScore(ScoreDto scoreDto) {
        scoreInfo = (ScoreInfo) scoreDto;
        scoreRepository.updateScoredateAndScoreAndNoofinfractionsByUserid(LocalDate.now(),
                scoreInfo.getScore() - 3,
                scoreInfo.getNoofinfractions() + 1,
                userMapper.toEntity((UserDto) scoreInfo.getUserid()));
    }

    public void addScore(ScoreDto scoreDto) {
        scoreInfo = (ScoreInfo) scoreDto;
        scoreRepository.updateScoredateAndScoreAndNoofinfractionsByUserid(LocalDate.now(),
                scoreInfo.getScore() + 10,
                scoreInfo.getNoofinfractions() - 1,
                userMapper.toEntity((UserDto) scoreInfo.getUserid()));
    }

    public Score saveScore(ScoreDto scoreDto) {
        return scoreRepository.saveAndFlush(scoreMapper.toEntity(scoreDto));
    }
}
