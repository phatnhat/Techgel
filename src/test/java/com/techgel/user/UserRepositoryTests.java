package com.techgel.user;

import com.techgel.common.entity.Role;
import com.techgel.common.entity.User;
import com.techgel.common.repository.UserRepository;
import com.techgel.common.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @TestConfiguration
    static class TestConfig {
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }


    @Test
    public void testCreateUser(){
        UserService userService = new UserService(userRepository, passwordEncoder);

        Role roleAdmin = testEntityManager.find(Role.class, 1);
        User admin = userService.createUser("admin", "techgel.com");
        admin.addRole(roleAdmin);

        User savedUser = userRepository.findUserByUsername("admin");
        assertThat(passwordEncoder.matches("techgel.com", savedUser.getPassword())).isTrue();
    }
}
