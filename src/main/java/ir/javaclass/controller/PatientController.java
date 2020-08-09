package ir.javaclass.controller;

import ir.javaclass.dto.PatientDto;
import ir.javaclass.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class PatientController {

    PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PutMapping("/patient/add")
    public ResponseEntity<String> addDoctor(@Valid @RequestBody PatientDto patientDto){
        if(patientService.register(patientDto)!=null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/patient/list")
    @ResponseBody
    public List<PatientDto> getAll(){
        return patientService.getAll();
    }

}
