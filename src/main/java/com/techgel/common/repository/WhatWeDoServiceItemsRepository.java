package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.AboutUsClientPartnerItems;
import com.techgel.common.entity.adminSettings.WhatWeDoServiceItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WhatWeDoServiceItemsRepository extends JpaRepository<WhatWeDoServiceItems, Long> {
    List<WhatWeDoServiceItems> findAllByWhatWeDoServiceId(Long id);

    Optional<WhatWeDoServiceItems> findByIdAndWhatWeDoServiceId(Long parentId, Long id);
}
