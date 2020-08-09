package ir.javaclass.service;

import ir.javaclass.dto.DoctorDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DoctorServiceTest {

    @Autowired
    private DoctorService doctorService;

    @Test
    void register() {
        DoctorDto doctorDto = new DoctorDto("اکرم اسماعیلی",3);
        doctorService.register(doctorDto);

        doctorDto = new DoctorDto("بهمن پور اقدم",4);
        doctorService.register(doctorDto);

        doctorDto = new DoctorDto("ریحانه شعبانی",5);
        doctorService.register(doctorDto);

        doctorDto = new DoctorDto("علی جلالی نژاد",6);
        doctorService.register(doctorDto);

        doctorDto = new DoctorDto("کیان دارابی",7);
        doctorService.register(doctorDto);

    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
        List<DoctorDto> doctorDtos = doctorService.getAll();
        for(DoctorDto dto : doctorDtos){
            System.out.println(dto.toString());
        }
    }

    @Test
    void testGetAll() {
    }
}