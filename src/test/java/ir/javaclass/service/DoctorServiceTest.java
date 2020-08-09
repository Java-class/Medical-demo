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
        DoctorDto doctorDto = new DoctorDto("doc1",1);
        doctorService.register(doctorDto);
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
        List<DoctorDto> doctorDtos = doctorService.getAll();
        System.out.println("size of list: " + doctorDtos.size());
    }

    @Test
    void testGetAll() {
    }
}