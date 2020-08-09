package ir.javaclass.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class ScheduleDto {

    @NotNull
    private int doctor_id;

    @NotNull
    private int duration;

    @NotNull(message = "start time of schedule must be set!")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    private Timestamp from;

    @NotNull(message = "end of schedule must be set!")
    private Timestamp to;

    public ScheduleDto(int doctor_id, int duration, Timestamp from, Timestamp to) {
        this.doctor_id = doctor_id;
        this.duration = duration;
        this.from = from;
        this.to = to;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Timestamp getFrom() {
        return from;
    }

    public void setFrom(Timestamp from) {
        this.from = from;
    }

    public Timestamp getTo() {
        return to;
    }

    public void setTo(Timestamp to) {
        this.to = to;
    }
}
