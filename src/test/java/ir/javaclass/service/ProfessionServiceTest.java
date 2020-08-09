package ir.javaclass.service;

import ir.javaclass.entity.Profession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProfessionServiceTest {

    @Autowired
    private ProfessionService professionService;

    @Test
    void register() {
        Profession profession = new Profession("profe2");
        professionService.register(profession);
    }

    @Test
    void getAll() {
    }

    @Test
    void get() {
    }
}