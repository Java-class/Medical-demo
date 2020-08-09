package ir.javaclass.dao;

import ir.javaclass.entity.Doctor;
import ir.javaclass.entity.Profession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Integer> {

    List<Doctor> getAllByProfession(Profession profession);
}
