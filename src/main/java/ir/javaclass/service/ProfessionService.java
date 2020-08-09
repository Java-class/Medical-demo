package ir.javaclass.service;

import ir.javaclass.dao.ProfessionRepository;
import ir.javaclass.entity.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessionService {

    private  ProfessionRepository professionRepository;

    @Autowired
    public ProfessionService(ProfessionRepository professionRepository) {
        this.professionRepository = professionRepository;
    }

    public Profession register(Profession newProfession){
        return professionRepository.save(newProfession);
    }

    public List<Profession> getAll(){
        return  (List<Profession>) professionRepository.findAll();
    }
    public Profession get(int id){
        Optional<Profession> byId = professionRepository.findById(id);
        return byId.orElse(null);
    }
}
