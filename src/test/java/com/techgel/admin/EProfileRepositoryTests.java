package com.techgel.admin;

import com.techgel.common.entity.adminSettings.EProfile;
import com.techgel.common.repository.EProfileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class EProfileRepositoryTests {
    @Autowired
    EProfileRepository eProfileRepository;

    @Test
    public void testCreateEBrochure(){
        EProfile eProfile = new EProfile("Hồ sơ năng lực", "E-Profile", "", true, "");
        EProfile eProfileSaved = eProfileRepository.save(eProfile);
        assertThat(eProfileSaved.getId()).isGreaterThan(0);
    }
}
