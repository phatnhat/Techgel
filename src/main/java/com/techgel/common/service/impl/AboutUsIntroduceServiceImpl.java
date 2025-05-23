package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.AboutUsIntroduce;
import com.techgel.common.repository.AboutUsIntroduceRepository;
import com.techgel.common.service.AboutUsIntroduceService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class AboutUsIntroduceServiceImpl implements AboutUsIntroduceService {
    private final AboutUsIntroduceRepository aboutUsIntroduceRepository;

    public List<AboutUsIntroduce> getAll(){
        return aboutUsIntroduceRepository.findAll();
    }

    public AboutUsIntroduce getById(Long id){
        return aboutUsIntroduceRepository.findById(id).orElse(null);
    }

    public AboutUsIntroduce update(AboutUsIntroduce aboutUsIntroduce){
        return aboutUsIntroduceRepository.save(aboutUsIntroduce);
    }
}
