package com.sofka.pet;

import com.sofka.management.Medicine;
import com.sofka.person.Owner;

import java.time.LocalDate;
import java.util.ArrayList;


public class Pet {

    protected String clinicHistoryNumber;
    protected String name;
    protected String breed;
    protected Owner owner;
    protected boolean isVaccinated;
    protected LocalDate desparasitationDate;
    protected ArrayList<Medicine> prescription;
    static int clinicHistoryRecord = 0;

    public Pet(String name, String breed, Owner owner) {
        /*this.clinicHistoryNumber = Pet.setClinicHistoryNumber();*/   //PENDING TO GENERATE ID
        this.name = name;
        this.breed = breed;
        this.owner = owner;
        this.prescription = new ArrayList<Medicine>();
    }

   /* public String setClicHistoryNumber(){
        int temporal = Pet.clinicHistoryRecord;
        Pet.clinicHistoryRecord++;
        return "00000"temporal
    }*/

    public void addMedicine(Medicine medicine){
        this.prescription.add(medicine);
        medicine.decreaseStock(1);
    }


}
