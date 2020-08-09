package ir.javaclass.controller;

import ir.javaclass.dto.ScheduleDto;
import ir.javaclass.entity.WorkSchedule;
import ir.javaclass.service.WorkScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class WorkScheduleController {

    final WorkScheduleService service;

    @Autowired
    public WorkScheduleController(WorkScheduleService service) {
        this.service = service;
    }

    @PutMapping("/schedule/create")
    public List<WorkSchedule> createWorkSchedule(@Valid @RequestBody ScheduleDto scheduleDto){
        return service.createSchedule(scheduleDto);
    }

    @GetMapping("/schedule/list/{doctorId}")
    public List<WorkSchedule> list(@PathVariable Integer doctorId){
        return service.getAll(doctorId);
    }

    @PostMapping(value = "/schedule/booking/{scheduleId}")
    //public WorkSchedule bookSchedule( @PathVariable Integer scheduleId, @RequestHeader(name = "patientId") Integer patientId){
    public WorkSchedule bookSchedule( @PathVariable Integer scheduleId, @RequestParam Integer patientId, @RequestParam String description){
        return service.bookingSchedule(scheduleId, patientId,description);
    }

}
