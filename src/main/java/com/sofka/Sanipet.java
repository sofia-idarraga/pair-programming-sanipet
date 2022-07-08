package com.sofka;


import com.sofka.management.*;
import com.sofka.person.Doctor;
import com.sofka.person.Owner;
import com.sofka.pet.Cat;

import java.util.ArrayList;

public class Sanipet {
    public static void main(String[] args) {

        ArrayList<Appointment> appointments = new ArrayList<Appointment>();

        Owner owner1 = new Owner("135638937","Michael","Jordan","3102568236",41);
        Cat cat1 = new Cat("Mirringo","Persian", owner1);
        Medicine gatecetaminofen = new Medicine("Gatecetaminofen", Presentation.PILLS,"Human", 200,1000);
        cat1.addMedicine(gatecetaminofen);
        Doctor ramiro = new Doctor("Ramiro","Healthy",1);
        Appointment appointment1 = new Appointment(AppointmentType.MEDICAL, cat1, ramiro,new Schedule(1,"3PM", "4PM"));

        appointments.add(appointment1);
        System.out.println(appointments.get(0));

    }
}
