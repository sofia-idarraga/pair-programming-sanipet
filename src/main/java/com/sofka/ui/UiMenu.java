package com.sofka.ui;

import com.sofka.management.Appointment;
import com.sofka.management.AppointmentType;
import com.sofka.management.Schedule;
import com.sofka.person.Employee;
import com.sofka.person.Owner;
import com.sofka.pet.Pet;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UiMenu {
    //TODO Hacer metodo que borre appointment a terminado

    SetByDefault setByDefault = new SetByDefault();
    Reader reader = new Reader();

    public ArrayList<Pet> pets = setByDefault.setPets();
    public ArrayList<Employee> employees = setByDefault.setEmployees();



    // Appointment options must manage CRUD
    // No need to make filterings at medicine
    // Medicine stock displays all the medicine with their data
    // Billing displays quantity, description of appointment, and shouldn't allow for bills of items out of stock
    // Billing should also take taxes into calculus of price (subtotal / total)

    public void displayMenu(){


        int option = 0;

        do{

            System.out.println(
                    """
                    
                    SANIPET - VETERINARY CARE CENTER
                    
                    1. Register Patient
                    2. Appointments
                        1. Create appointment
                        2. Update appointment   
                        3. Cancel appointment
                        4. Filter by date 
                    3. Billing
                    4. Medicine Stock
                        4.1 Pills
                        4.2 Syrup
                        4.3 Pet Care
                    5. Exit
                    
                    """);
            option = reader.scannerInt();

            switch(option){
                case 1:{
                    createPatient();
                    break;
                }
                case 2:{
                    appointmentMenu();
                    break;

                }

            }
        } while(option != 5);
    }

    public void appointmentMenu(){
        int appointmentOption=0;
        System.out.println(
                """
                
                APPOINTMENT OPTIONS
                
                1. Create appointment
                2. Update appointment   
                3. Cancel appointment
                4. Filter by date                
                """);
        appointmentOption = reader.scannerInt();

        switch (appointmentOption){
            case 1:{
                createAppointment();
            }
        }
    }

    public void createPatient(){

        System.out.println("Enter owner´s DNI");
        String ownerDNI = reader.scannerText();
        System.out.println("Enter owner´s name");
        String ownerName = reader.scannerText();
        System.out.println("Enter owner´s surname");
        String ownerSurname = reader.scannerText();
        System.out.println("Enter owner´s cellphone");
        String ownerCellphone = reader.scannerText();
        System.out.println("Enter owner´s age");
        int ownerAge = reader.scannerInt();
        if(ownerAge < 18){
            System.out.println("Pet admission is only accepted by an adult ");
            return;
        }

        Owner owner = new Owner(ownerDNI, ownerName, ownerSurname, ownerCellphone, ownerAge);

        System.out.println("Enter the Pet´s species");
        String petSpecies = reader.scannerText();
        System.out.println("Enter the Pet´s name");
        String petName = reader.scannerText();
        System.out.println("Enter the Pet´s breed");
        String petbreed = reader.scannerText();
        System.out.println("Enter 1 if Vaccinated 2 otherwise");
        boolean isPetVaccinated = reader.scannerInt() == 1 ? true : false;
        System.out.println("Enter deparasitation Year. Enter 0 if not deparasitated");
        int deparasitationYear = reader.scannerInt();

        Pet pet = new Pet(petSpecies, petName, petbreed, owner, isPetVaccinated, deparasitationYear);

        pets.add(pet);
        System.out.println("Succesful registration");
        System.out.println(pets.get(0));
    }

    public void createAppointment(){
        System.out.println("Select your appointment type: ");
        System.out.println("1. MEDICAL");
        System.out.println("2. SURGERY");
        System.out.println("3. AESTHETIC");
        int appointmentType = reader.scannerInt();

        System.out.println("Enter owner's DNI: ");
        String ownerDni = reader.scannerText();
        Pet pet = searchPetByOwnerDni(ownerDni);
        if(pet == null){
            System.out.println("Your pet is not registered, please register your pet");
            return;
        }
        System.out.println("Input your appointment date: yyyy-mm-dd");
        String stringDate = reader.scannerText();
        LocalDate appointmentDate = LocalDate.parse(stringDate);

        System.out.println("At what hour do you want your appointment?");
        int initialHour = reader.scannerInt();

        Schedule schedule = new Schedule(appointmentDate.getDayOfWeek().getValue(), String.valueOf(initialHour), String.valueOf(initialHour+1));
        System.out.println(schedule);
        Appointment appointment = new Appointment(AppointmentType.AESTHETIC,pet,schedule,appointmentDate);
        System.out.println(appointment);
    }

    public Pet searchPetByOwnerDni(String ownerDni){
        Pet foundedPet = null;
        for (Pet pet: pets ) {
            Owner owner = pet.getOwner();
            if(ownerDni.equals(owner.getDni())){
                foundedPet = pet;
            }
        }
        return foundedPet;
    }



}
