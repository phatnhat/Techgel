package com.techgel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EntityScan({"com.techgel.common.entity"})
@EnableJpaAuditing
public class TechgelApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechgelApplication.class, args);
    }

}
