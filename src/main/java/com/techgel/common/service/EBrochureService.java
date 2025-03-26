package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.EBrochure;
import com.techgel.common.repository.EBrochureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EBrochureService {
    final EBrochureRepository eBrochureRepository;

    public List<EBrochure> getAll(){
        return eBrochureRepository.findAll();
    }
}
