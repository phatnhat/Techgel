package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.AboutUsTestimonial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutUsTestimonialRepository extends JpaRepository<AboutUsTestimonial, Long> {
}
