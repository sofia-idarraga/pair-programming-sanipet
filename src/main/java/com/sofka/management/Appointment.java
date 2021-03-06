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

    public AppointmentType getAppointmentType() {
        return appointmentType;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
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

    public String displayInfo(){

        return new StringBuilder()
                .append("PATIENT: " + this.pet.getName() + "\n")
                .append("OWNER'S NAME: " + this.pet.getOwner().getSurname() + " " + this.pet.getOwner().getName() + "\n")
                .append("PROCEDURE: " + this.appointmentType + "\n")
                .append("STATUS: " + this.status + "\n")
                .append("TIME OF PROCEDURE: " + this.schedule.getEntranceHour() + " to " + this.schedule.getOutHour())
                .toString();
    }
}
