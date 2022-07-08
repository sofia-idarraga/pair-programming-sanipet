package com.sofka.pet;

import com.sofka.management.Medicine;
import com.sofka.person.Owner;

import java.time.LocalDate;
import java.util.ArrayList;


public abstract class Pet {

    protected String name;
    protected String breed;
    protected Owner owner;
    protected boolean isVaccinated;
    protected LocalDate desparasitationDate;
    protected ArrayList<Medicine> prescription;
    protected String clinicHistNum;
    protected static int generalHistNum = 0;

    public Pet(String name, String breed, Owner owner) {
        /*this.clinicHistoryNumber = Pet.setClinicHistoryNumber();*/   //PENDING TO GENERATE ID
        this.name = name;
        this.breed = breed;
        this.owner = owner;
        this.prescription = new ArrayList<Medicine>();
        this.clinicHistNum = generateClinicHistNum(generalHistNum);

    }

    public String generateClinicHistNum(int histNum){

        generalHistNum += 1;
        int Num = generalHistNum;
        return (String.format("%06d", Num));

    }

    public void addMedicine(Medicine medicine){
        this.prescription.add(medicine);
        medicine.decreaseStock(1);
    }


}
