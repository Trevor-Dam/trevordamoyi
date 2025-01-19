package com.enviro.assessment.grad001.trevordamoyi.controllers.services;

import com.enviro.assessment.grad001.trevordamoyi.controllers.migrations.Community;
import com.enviro.assessment.grad001.trevordamoyi.controllers.repositories.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityService {
    @Autowired
    private CommunityRepository communityRepository;

    public Community findByArea(String area) {
        return communityRepository.findByArea(area);
    }
}
