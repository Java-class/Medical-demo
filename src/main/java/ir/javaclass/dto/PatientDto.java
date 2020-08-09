package ir.javaclass.dto;

import ir.javaclass.entity.Patient;


public class PatientDto {
    private String name;

    private int age;

    private Patient.SEX sex;

    public PatientDto(String name, int age, Patient.SEX sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Patient.SEX getSex() {
        return sex;
    }

    public void setSex(Patient.SEX sex) {
        this.sex = sex;
    }
}
