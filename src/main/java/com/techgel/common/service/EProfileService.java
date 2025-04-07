package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.EProfile;
import com.techgel.common.entity.adminSettings.HomeNavigation;
import com.techgel.common.repository.EProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EProfileService {
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
