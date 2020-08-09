package ir.javaclass.dao;

import ir.javaclass.entity.Profession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionRepository extends CrudRepository<Profession,Integer> {
}
