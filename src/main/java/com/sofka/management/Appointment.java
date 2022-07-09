package com.sofka.management;

import com.sofka.person.Employee;
import com.sofka.pet.Pet;
import java.time.LocalDate;

public class Appointment {

    private AppointmentType appointmentType;
    private Pet pet;
    private StatusType status;
    private Schedule schedule;
    private LocalDate appointmentDate;
    //TODO INGRESAR PRECIO DEL APPOINTMENT

    public Appointment(AppointmentType appointmentType, Pet pet, Schedule schedule, LocalDate appointmentDate) {
        this.appointmentType = appointmentType;
        this.pet = pet;
        this.status = StatusType.NOTSTARTED;
        this.schedule = schedule;
        this.appointmentDate = appointmentDate;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public void setAppointmentType(AppointmentType appointmentType) {
        this.appointmentType = appointmentType;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentType=" + appointmentType +
                ", pet=" + pet +
                ", status=" + status +
                ", schedule=" + schedule +
                ", AppointmentDate=" + appointmentDate +
                '}';
    }
}
