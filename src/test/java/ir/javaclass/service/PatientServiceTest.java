package ir.javaclass.service;

import ir.javaclass.dto.PatientDto;
import ir.javaclass.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Test
    void register() {
        PatientDto patientDto = new PatientDto("Alireza",23, Patient.SEX.MALE);
        patientService.register(patientDto);
    }

    @Test
    void get() {
        patientService.get(1);
        System.out.println(patientService.get(1).toString());
    }
}