package ir.javaclass.service;

import ir.javaclass.entity.WorkSchedule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WorkScheduleServiceTest {

    @Autowired
    private WorkScheduleService service;

    @Test
    void createSchedule() {


    }

    @Test
    void getAll() {
        try {
            List<WorkSchedule> all = service.getAll(1);
            for (WorkSchedule workSchedule : all)
                System.out.println(workSchedule.toString());
        }catch (Exception ex){
            ex.printStackTrace();
            fail();
        }
    }

    @Test
    void bookingSchedule() {
        try {
            WorkSchedule workSchedule = service.bookingSchedule(15, 1, "some desc for this booking...");
            System.out.println(workSchedule.toString());
        }catch (Exception ex){
            ex.printStackTrace();
            fail();
        }

    }
}