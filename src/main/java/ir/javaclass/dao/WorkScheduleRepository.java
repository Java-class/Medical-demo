package ir.javaclass.dao;

import ir.javaclass.entity.Doctor;
import ir.javaclass.entity.WorkSchedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkScheduleRepository extends CrudRepository<WorkSchedule,Integer> {
    List<WorkSchedule> getAllByDoctor(Doctor doctor);
}
