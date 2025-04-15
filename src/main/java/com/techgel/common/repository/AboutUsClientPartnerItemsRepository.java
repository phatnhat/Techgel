package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.AboutUsClientPartnerItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AboutUsClientPartnerItemsRepository extends JpaRepository<AboutUsClientPartnerItems, Long> {
    List<AboutUsClientPartnerItems> findAllByAboutUsClientPartnerId(Long id);

    Optional<AboutUsClientPartnerItems> findByIdAndAboutUsClientPartnerId(Long parentId, Long id);
}
