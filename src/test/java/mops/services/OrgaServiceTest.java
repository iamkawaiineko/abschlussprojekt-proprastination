package mops.services;

import mops.model.classes.Application;
import mops.model.classes.Role;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class OrgaServiceTest {
    @Autowired
    OrgaService service;
    Application application;

    @BeforeAll
    void setUp() {
        application = Application.builder()
                .applicantusername("applicantusername")
                .priority(99)
                .module("module")
                .hours(99)
                .comment("comment")
                .grade(99.99)
                .lecturer("lecturer")
                .role(Role.KORREKTOR)
                .semester("semester")
                .build();
    }

    @Test
    void testSave() {
        service.save(application, 1);
    }

    @Test
    void testGetModuleApplications() {
    }

}
