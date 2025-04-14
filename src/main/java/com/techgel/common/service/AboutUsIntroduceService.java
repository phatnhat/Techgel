package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsIntroduce;
import com.techgel.common.repository.AboutUsIntroduceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutUsIntroduceService {
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
