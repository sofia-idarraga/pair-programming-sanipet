package com.sofka.ui;

import com.sofka.management.*;
import com.sofka.person.Doctor;
import com.sofka.person.Employee;
import com.sofka.person.Owner;
import com.sofka.person.Stylist;
import com.sofka.pet.Pet;

import java.time.LocalDate;
import java.util.ArrayList;

public class SetByDefault {

    public ArrayList<Pet> setPets(){
        ArrayList<Pet> pets = new ArrayList<Pet>();
        Owner owner1 = new  Owner("12345", "Sofia", "Idarraga", "333456", 23);
        Pet pet1 = new Pet("cat", "michi","meh", owner1,true,2021);
        pets.add(pet1);

        Owner owner2 = new  Owner("11111", "Santiago", "Tabares", "36543", 21);
        Pet pet2 = new Pet("cat", "miau","meh", owner2,true,2021);
        pets.add(pet2);

        Owner owner3 = new  Owner("22222", "Thiago", "Jaramillo", "345678", 20);
        Pet pet3 = new Pet("dog", "Thor","Rotwiller", owner3,false,2019);
        pets.add(pet3);

        return pets;
    }

    public ArrayList<Employee> setEmployees(){
        ArrayList<Employee> employees = new ArrayList<Employee>();
        Doctor doctor1 = new Doctor("Fernando", "Gil", 1);
        Doctor doctor2 = new Doctor("Susana", "Castro", 1);
        Doctor doctor3 = new Doctor("Maria", "Rave", 2);
        Stylist stylist1 = new Stylist("Diego", "Molano");
        Stylist stylist2 = new Stylist("Sasha", "Toro");
        Stylist stylist3 = new Stylist("Mauro", "Castaño");

        employees.add(doctor1);
        employees.add(doctor2);
        employees.add(doctor3);
        employees.add(stylist1);
        employees.add(stylist2);
        employees.add(stylist3);

        return employees;
    }

    public ArrayList<Appointment> setAppointment(){

        ArrayList<Appointment> appointment = new ArrayList<Appointment>();
        Owner owner4 = new  Owner("12345", "Sofia", "Idarraga", "333456", 23);
        Pet pet4 = new Pet("cat", "michi","meh", owner4,true,2021);
        Appointment appointment1 = new Appointment(AppointmentType.MEDICAL,pet4,new Schedule(1,"5PM","6PM"), LocalDate.of(2022,8,5));

        appointment.add(appointment1);

        return appointment;
    }

    public ArrayList<Medicine> setMedicines(){
        ArrayList<Medicine> medicines = new ArrayList<Medicine>();
        Medicine med1 = new Medicine("Catamol", Presentation.PET_CARE,"Veterinary",200,25,10);
        Medicine med2 = new Medicine("Doggax", Presentation.SYRUP,"Human",100,10,15);
        Medicine med3 = new Medicine("Gatecaminofen", Presentation.PILLS,"Veterinary",75,5,24);
        medicines.add(med1);
        medicines.add(med2);
        medicines.add(med3);
        return medicines;
    }

}
