package com.sofka.ui;

import com.sofka.person.Owner;
import com.sofka.pet.Pet;

import java.util.ArrayList;
import java.util.Scanner;

public class UiMenu {

    private ArrayList<Pet> pets = new ArrayList<Pet>();


    Reader reader = new Reader();

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
            option = reader.scannerInt();

            switch(option){
                case 1:{
                    createPatient();
                    break;
                }
                case 2:{

                }

            }
        } while(option != 5);
    }

    public void createPatient(){

        System.out.println("Enter onwer´s DNI");
        String ownerDNI = reader.scannerText();
        System.out.println("Enter onwer´s name");
        String ownerName = reader.scannerText();
        System.out.println("Enter onwer´s surname");
        String ownerSurname = reader.scannerText();
        System.out.println("Enter onwer´s cellphone");
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



}
