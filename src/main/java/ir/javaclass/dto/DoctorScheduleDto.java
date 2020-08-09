package ir.javaclass.dto;

import java.sql.Timestamp;

public class DoctorScheduleDto {

    private Timestamp date;

    private PatientDto patient;

    private String description;

    public DoctorScheduleDto(Timestamp date, PatientDto patientDto, String description) {
        this.date = date;
        this.patient = patientDto;
        this.description = description;
    }

    @Override
    public String toString() {
        return "DoctorSchedule{" +
                "date=" + date +
                ", patientDto=" + patient +
                ", description='" + description + '\'' +
                '}';
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public PatientDto getPatient() {
        return patient;
    }

    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
