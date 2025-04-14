package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.AboutUsTestimonialItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutUsTestimonialItemsRepository extends JpaRepository<AboutUsTestimonialItems, Long> {
}
