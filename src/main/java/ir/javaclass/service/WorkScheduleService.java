package ir.javaclass.service;

import ir.javaclass.dao.DoctorRepository;
import ir.javaclass.dao.PatientRepository;
import ir.javaclass.dao.WorkScheduleRepository;
import ir.javaclass.dto.DoctorScheduleDto;
import ir.javaclass.dto.PatientDto;
import ir.javaclass.dto.ScheduleDto;
import ir.javaclass.entity.Doctor;
import ir.javaclass.entity.Patient;
import ir.javaclass.entity.WorkSchedule;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkScheduleService {

    private WorkScheduleRepository workScheduleRepository;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    @Autowired
    public WorkScheduleService(WorkScheduleRepository workScheduleRepository,DoctorRepository doctorRepository,PatientRepository patientRepository) {
        this.workScheduleRepository = workScheduleRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public List<WorkSchedule> createSchedule(ScheduleDto scheduleDto) {
        List<WorkSchedule> list = new ArrayList<>();
        Optional<Doctor> optionalDoctor = doctorRepository.findById(scheduleDto.getDoctor_id());
        if (optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            WorkSchedule workSchedule;
            int m = (scheduleDto.getTo().getHours() - scheduleDto.getFrom().getHours()) * (60/scheduleDto.getDuration());
            for( int i=0;i<m;i++){
                workSchedule = new WorkSchedule(doctor, new Timestamp(scheduleDto.getFrom().getTime() + (i*scheduleDto.getDuration()*1000*60)));
                list.add(workScheduleRepository.save(workSchedule));
            }
        }
        return list;
    }

    public List<DoctorScheduleDto> getAll(int doctorId) {
        List<DoctorScheduleDto> result = null;
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);
        if(optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            List<WorkSchedule> list = workScheduleRepository.getAllByDoctor(doctor);
            if(list!=null && list.size()>0) {
                result = new ArrayList<>();
                for (WorkSchedule workSchedule : list) {
                    result.add(new DoctorScheduleDto(workSchedule.getDate(), workSchedule.getPatient()!=null?new PatientDto(workSchedule.getPatient().getName(), workSchedule.getPatient().getAge(), workSchedule.getPatient().getSex()):null, workSchedule.getDescription()));
                }
            }
        }
        return result;
    }

    public synchronized WorkSchedule bookingSchedule(int scheduleId, int patientId, String description) {
        Optional<WorkSchedule> scheduleOptional = workScheduleRepository.findById(scheduleId);
        if(scheduleOptional.isPresent()) {
            WorkSchedule workSchedule = scheduleOptional.get();
            if (workSchedule.getPatient() == null) {
                Optional<Patient> byId = patientRepository.findById(patientId);
                if (byId.isPresent()) {
                    Patient patient = byId.get();
                    workSchedule.setPatient(patient);
                    workSchedule.setDescription(description);
                    return workScheduleRepository.save(workSchedule);
                }
            }
        }
        return null;
    }

}
