package ir.javaclass.service;

import ir.javaclass.dto.PatientDto;
import ir.javaclass.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Test
    void register() {
        PatientDto patientDto = new PatientDto("علیرضا حسینی",23, Patient.SEX.MALE);
        patientService.register(patientDto);

        patientDto = new PatientDto("زهرا ناصری",45, Patient.SEX.FEMAILE);
        patientService.register(patientDto);

        patientDto = new PatientDto("علی احمدی",16, Patient.SEX.MALE);
        patientService.register(patientDto);

        patientDto = new PatientDto("محمد محمدی",60, Patient.SEX.MALE);
        patientService.register(patientDto);

        patientDto = new PatientDto("فاطمه محمدی",30, Patient.SEX.FEMAILE);
        patientService.register(patientDto);
    }

    @Test
    void get() {
        patientService.get(1);
        System.out.println(patientService.get(1).toString());
    }

    @Test
    public void getAll() {
        List<PatientDto> list = patientService.getAll();
        for(PatientDto patientDto : list)
            System.out.println(patientDto.toString());

    }
}