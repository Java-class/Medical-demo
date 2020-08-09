package ir.javaclass.service;

import ir.javaclass.dto.DoctorScheduleDto;
import ir.javaclass.dto.ScheduleDto;
import ir.javaclass.entity.WorkSchedule;
import ir.javaclass.util.Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WorkScheduleServiceTest {

    @Autowired
    private WorkScheduleService service;

    @Test
    void createSchedule() {

        ScheduleDto scheduleDto = new ScheduleDto(3, 30, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis() + Util.TIME_HOUR*3));
        service.createSchedule(scheduleDto);

        scheduleDto = new ScheduleDto(4, 20, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis() + Util.TIME_HOUR*2));
        service.createSchedule(scheduleDto);
    }

    @Test
    void getAll() {
        try {
            List<DoctorScheduleDto> all = service.getAll(3);
            for (DoctorScheduleDto workSchedule : all)
                System.out.println(workSchedule.toString());

            all = service.getAll(4);
            for (DoctorScheduleDto workSchedule : all)
                System.out.println(workSchedule.toString());
        }catch (Exception ex){
            ex.printStackTrace();
            fail();
        }
    }

    @Test
    void bookingSchedule() {
        try {
            WorkSchedule workSchedule = service.bookingSchedule(30, 3, "دارای تب خفیف و سردرد و...");
            System.out.println(workSchedule.toString());
        }catch (Exception ex){
            ex.printStackTrace();
            fail();
        }
    }

}