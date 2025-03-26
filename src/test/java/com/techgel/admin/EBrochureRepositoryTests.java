package com.techgel.admin;

import com.techgel.common.entity.adminSettings.EBrochure;
import com.techgel.common.repository.EBrochureRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class EBrochureRepositoryTests {
    @Autowired
    EBrochureRepository eBrochureRepository;

    @Test
    public void testCreateEBrochure(){
        EBrochure eBrochure = new EBrochure("E-Brochure", true, "/e-brochure.pdf");
        EBrochure eBrochureSaved = eBrochureRepository.save(eBrochure);
        assertThat(eBrochureSaved.getId()).isGreaterThan(0);
    }
}
