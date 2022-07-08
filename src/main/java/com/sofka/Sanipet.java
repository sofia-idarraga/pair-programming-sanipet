package com.sofka;


import com.sofka.management.*;
import com.sofka.person.Doctor;
import com.sofka.person.Owner;
import com.sofka.pet.Cat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Sanipet {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

    /*
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();

        Owner owner1 = new Owner("135638937","Michael","Jordan","3102568236",41);
        Cat cat1 = new Cat("Mirringo","Persian", owner1);
        Medicine gatecetaminofen = new Medicine("Gatecetaminofen", Presentation.PILLS,"Human", 200,1000);
        cat1.addMedicine(gatecetaminofen);
        Doctor ramiro = new Doctor("Ramiro","Healthy",1);
        Appointment appointment1 = new Appointment(AppointmentType.MEDICAL, cat1, ramiro,new Schedule(1,"3PM", "4PM"),LocalDate.of(2000,8,5));

        appointments.add(appointment1);

        System.out.println(appointments.get(0)); */


        do{

            System.out.println(
                    // Appointment options must manage CRUD
                    // No need to make filterings at medicine
                    // Medicine stock displays all the medicine with their data
                    // Billing displays quantity, description of appointment, and shouldn't allow for bills of items out of stock
                    // Billing should also take taxes into calculus of price (subtotal / total)
                    """
                    
                    SANIPET - VETERINARY CARE CENTER
                    
                    1. Register Patient
                    2. Appointments
                        2.1 Create appointment.
                        2.2 Update appointment
                        2.3 Search appointment by date.
                        2.4 Delete appointment (min 1 day before)
                    3. Billing
                    4. Medicine Stock
                        4.1 Pills
                        4.2 Syrup
                        4.3 Pet Care
                    5. Exit
                    
                    """);

            int option = sc.nextInt();

            switch(option){
                case 1:{

                }
            }

        }while();
    }

}
