package com.sofka.ui;

import com.sofka.person.Owner;
import com.sofka.pet.Pet;

import java.util.ArrayList;
import java.util.Scanner;

public class UiMenu {

    private ArrayList<Pet> pets = new ArrayList<Pet>();


    Scanner sc = new Scanner(System.in);

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


            switch(option){
                case 1:{
                    createPatient();
                    break;
                }
                case 2:
            }

            option = sc.nextInt();

        } while(option != 5);
    }

    public void createPatient(){

        System.out.println("Enter onwer´s DNI");
        String ownerDNI = sc.nextLine();
        System.out.println("Enter onwer´s name");
        String ownerName = sc.nextLine();
        System.out.println("Enter onwer´s surname");
        String ownerSurname = sc.nextLine();
        System.out.println("Enter onwer´s cellphone");
        String ownerCellphone = sc.nextLine();
        System.out.println("Enter owner´s age");
        int ownerAge = sc.nextInt();
        if(ownerAge < 18){
            System.out.println("Pet admission is only accepted by an adult ");
            return;
        }

        Owner owner = new Owner(ownerDNI, ownerName, ownerSurname, ownerCellphone, ownerAge);

        System.out.println("Enter the Pet´s species");
        String petSpecies = sc.nextLine();
        System.out.println("Enter the Pet´s name");
        String petName = sc.nextLine();
        System.out.println("Enter the Pet´s breed");
        String petbreed = sc.nextLine();
        System.out.println("Enter 1 if Vaccinated 2 otherwise");
        boolean isPetVaccinated = sc.nextInt() == 1 ? true : false;
        System.out.println("Enter deparasitation Year. Enter 0 if not deparasitated");
        int deparasitationYear = sc.nextInt();

        Pet pet = new Pet(petSpecies, petName, petbreed, owner, isPetVaccinated, deparasitationYear);

        pets.add(pet);





    }



}
