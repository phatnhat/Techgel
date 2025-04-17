package com.techgel.common.service.offline;

import com.techgel.client.StaticData;
import com.techgel.common.entity.adminSettings.Carousel;
import com.techgel.common.repository.CarouselRepository;
import com.techgel.common.service.CarouselService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
@RequiredArgsConstructor
public class CarouselOfflineService implements CarouselService {
    public List<Carousel> getAll(){
        return StaticData.carouselsData();
    }

    public Carousel getById(Long id){
        return this.getAll().stream().filter(carousel -> carousel.getId().equals(id)).findFirst().orElse(null);
    }

    public void update(Carousel carousel){}

    public void deleteById(Long id){}
}
