package com.sofka.management;

import com.sofka.pet.Pet;
import java.time.LocalDate;
import com.sofka.ui.Reader;

public class Appointment {

    private AppointmentType appointmentType;
    private Pet pet;
    private StatusType status;
    private Schedule schedule;
    private LocalDate appointmentDate;
    //TODO INGRESAR PRECIO DEL APPOINTMENT

    Reader reader = new Reader();

    public Appointment(AppointmentType appointmentType, Pet pet, Schedule schedule, LocalDate appointmentDate) {
        this.appointmentType = appointmentType;
        this.pet = pet;
        this.status = StatusType.NOTSTARTED;
        this.schedule = schedule;
        this.appointmentDate = appointmentDate;
    }

    public Pet getPet() {
        return pet;
    }

    public void setStatus(StatusType status) {
        this.status = status;
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
