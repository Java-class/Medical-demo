package ir.javaclass.controller;

import ir.javaclass.dto.DoctorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ir.javaclass.service.DoctorService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DoctorController {

    DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PutMapping("/doctor/add")
    public ResponseEntity<String> addDoctor(@Valid @RequestBody DoctorDto doctorDto){
        if(doctorService.register(doctorDto)!=null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/doctor/list")
    @ResponseBody
    public List<DoctorDto> getAll(){
        return doctorService.getAll();
    }


}

