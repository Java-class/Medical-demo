package ir.javaclass.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@DynamicInsert
@DynamicUpdate
@Cacheable
@org.hibernate.annotations.Cache( usage= CacheConcurrencyStrategy.TRANSACTIONAL)
public class WorkSchedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "dc_id")
    private Doctor doctor;

    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "pt_id")
    private Patient patient;

    private String description;

    public WorkSchedule(Doctor doctor, Timestamp date) {
        this.doctor = doctor;
        this.date = date;
    }

    public WorkSchedule() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "WorkSchedule{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", date=" + date +
                ", patient=" + patient +
                ", description='" + description + '\'' +
                '}';
    }
}
