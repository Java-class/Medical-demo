package ir.javaclass.service;

import ir.javaclass.dao.PatientRepository;
import ir.javaclass.dto.PatientDto;
import ir.javaclass.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public Patient register(PatientDto patientDto) {
        Patient newPatient = new Patient(patientDto.getName(), patientDto.getAge(), patientDto.getSex());
        return patientRepository.save(newPatient);
    }

    public Patient get(int id){
        Optional<Patient> byId = patientRepository.findById(id);
        return byId.orElse(null);
    }

    public List<PatientDto> getAll(){
        List<PatientDto> patientDtos = new ArrayList<>();
        Iterable<Patient> iterable = patientRepository.findAll();
        for(Patient patient : iterable){
            patientDtos.add(new PatientDto(patient.getName(), patient.getAge(),patient.getSex()));
        }
        return patientDtos;
    }

}
