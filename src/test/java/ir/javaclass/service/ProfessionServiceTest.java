package ir.javaclass.service;

import ir.javaclass.entity.Profession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProfessionServiceTest {

    @Autowired
    private ProfessionService professionService;

    @Test
    void register() {
        Profession profession = new Profession("پزشک عمومی");
        professionService.register(profession);

        profession = new Profession("دندانپزشکی");
        professionService.register(profession);

        profession = new Profession("قلب و عروق");
        professionService.register(profession);

        profession = new Profession("گوش، حلق و بینی");
        professionService.register(profession);

        profession = new Profession("کودکان");
        professionService.register(profession);

    }

    @Test
    void getAll() {
        List<Profession> list =  professionService.getAll();
        for(Profession profession : list)
            System.out.println(profession.toString());
    }

}