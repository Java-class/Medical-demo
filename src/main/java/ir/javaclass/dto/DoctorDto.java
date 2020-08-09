package ir.javaclass.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;


public class DoctorDto {

    @NotNull @Size(min=10, max = 255,message = "Doctor name is not valid!")
    private String name;

    @NotNull(message = "profession id must set..!")
    private int prof_id;

    private Timestamp reg_date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProf_id() {
        return prof_id;
    }

    public void setProf_id(int prof_id) {
        this.prof_id = prof_id;
    }

    public Timestamp getReg_date() {
        return reg_date;
    }

    public void setReg_date(Timestamp reg_date) {
        this.reg_date = reg_date;
    }

    public DoctorDto(@NotNull @Size(min = 10, max = 255, message = "Doctor name is not valid!") String name, @NotNull(message = "profession id must set..!") int prof_id) {
        this.name = name;
        this.prof_id = prof_id;
    }

    public DoctorDto(String name, int prof_id, Timestamp reg_date) {
        this.name = name;
        this.prof_id = prof_id;
        this.reg_date = reg_date;
    }
}
