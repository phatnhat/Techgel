package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.ClientsPartners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsPartnersRepository extends JpaRepository<ClientsPartners, Long> {
}
