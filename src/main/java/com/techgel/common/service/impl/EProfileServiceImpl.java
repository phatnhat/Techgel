package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.EProfile;
import com.techgel.common.repository.EProfileRepository;
import com.techgel.common.service.EProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class EProfileServiceImpl implements EProfileService {
    final EProfileRepository eProfileRepository;

    public EProfile getById(Long id){
        return eProfileRepository.findById(id).orElse(null);
    }

    public List<EProfile> getAll(){
        return eProfileRepository.findAll();
    }

    public void update(EProfile eProfile){
        eProfileRepository.save(eProfile);
    }
}
