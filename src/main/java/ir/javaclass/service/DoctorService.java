package ir.javaclass.service;

import ir.javaclass.dao.DoctorRepository;
import ir.javaclass.dao.ProfessionRepository;
import ir.javaclass.dto.DoctorDto;
import ir.javaclass.entity.Doctor;
import ir.javaclass.entity.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DoctorService {

    private DoctorRepository doctorRepository;
    private  ProfessionRepository professionRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, ProfessionRepository professionRepository){
        this.doctorRepository = doctorRepository;
        this.professionRepository = professionRepository;
    }

    public Doctor register(DoctorDto doctorDto){
        Doctor newDoctor;
        Profession profession;
        Optional<Profession> prop = professionRepository.findById(doctorDto.getProf_id());
        if(!prop.isPresent())
            return null;
        profession = prop.get();
        newDoctor = new Doctor(doctorDto.getName(),profession);
        return doctorRepository.save(newDoctor);
    }

    public Doctor get(int id){
        Optional<Doctor> byId = doctorRepository.findById(id);
        return byId.orElse(null);
    }

    public List<DoctorDto> getAll(){
        List<DoctorDto> doctors = new ArrayList<>();
        Iterable<Doctor> iterable = doctorRepository.findAll();
        for (Doctor doctor : iterable)
            doctors.add(new DoctorDto(doctor.getName(),doctor.getProfession().getId(), doctor.getAddDate()));

        return doctors;
    }

    public List<DoctorDto> getAllByProfession(int professionId){
        List<DoctorDto> doctors = new ArrayList<>();
        Optional<Profession> professionOptional = professionRepository.findById(professionId);
        if(professionOptional.isPresent()) {
            Profession profession = professionOptional.get();
            List<Doctor> list = doctorRepository.getAllByProfession(profession);
            for (Doctor doctor : list)
                doctors.add(new DoctorDto(doctor.getName(),doctor.getProfession().getId(), doctor.getAddDate()));
            return doctors;
        }
        return null;
    }

}
