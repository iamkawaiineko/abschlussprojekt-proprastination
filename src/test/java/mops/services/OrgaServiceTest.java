package mops.services;

import mops.model.classes.Application;
import mops.model.classes.Role;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class OrgaServiceTest {
    @Autowired
    OrgaService service;
    Application application;

    @BeforeAll
    void setUp() {
        application = Application.builder()
                .applicantusername("boi444")
                .priority(3)
                .module("Baumeister GmbH")
                .hours(17)
                .comment("Bob der Baumeisterlehrling")
                .grade(1.3)
                .lecturer("Rollo und der Tubby")
                .role(Role.KORREKTOR)
                .semester("SS2020")
                .build();
    }

    @Test
    void testSave21() {
    }
}
