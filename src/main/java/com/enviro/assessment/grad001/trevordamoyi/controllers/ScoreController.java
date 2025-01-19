package com.enviro.assessment.grad001.trevordamoyi.controllers;

import com.enviro.assessment.grad001.trevordamoyi.controllers.dto.ScoreDto;
import com.enviro.assessment.grad001.trevordamoyi.controllers.mappers.ScoreMapper;
import com.enviro.assessment.grad001.trevordamoyi.controllers.migrations.ScoreInfo;
import com.enviro.assessment.grad001.trevordamoyi.controllers.services.ScoreService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {

    private final ScoreMapper scoreMapper;
    private final ScoreService scoreService;

    public ScoreController(ScoreMapper scoreMapper, ScoreService scoreService) {
        this.scoreMapper = scoreMapper;
        this.scoreService = scoreService;
    }

    @PutMapping("/api/score/deduct")
    public HttpEntity<ScoreDto> deductScore(@RequestBody ScoreDto scoreDto, @RequestParam("id") Long id) {
        ScoreInfo scoreInfo = (ScoreInfo) scoreDto;
        if (scoreInfo.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (scoreInfo.getId().equals(id)) {
            scoreService.updateScore(scoreDto);
            return new ResponseEntity<>(scoreDto, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/api/score/add")
    public HttpEntity<ScoreDto> addScore(@RequestBody ScoreDto scoreDto, @RequestParam("id") Long id) {
        ScoreInfo scoreInfo = (ScoreInfo) scoreDto;
        if (scoreInfo.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (scoreInfo.getId().equals(id)) {
            scoreService.updateScore(scoreDto);
            return new ResponseEntity<>(scoreDto, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
