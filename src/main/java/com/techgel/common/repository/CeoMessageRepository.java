package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.AboutUsClientPartnerItems;
import com.techgel.common.entity.adminSettings.CeoMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CeoMessageRepository extends JpaRepository<CeoMessage, Long> {
}
