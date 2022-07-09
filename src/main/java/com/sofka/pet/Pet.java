package com.sofka.pet;

import com.sofka.management.Medicine;
import com.sofka.person.Owner;

import java.time.LocalDate;
import java.util.ArrayList;


public  class Pet {

    protected String species;
    protected String name;
    protected String breed;
    protected Owner owner;
    protected boolean isVaccinated;
    protected int desparasitationYear;
    protected ArrayList<Medicine> prescription;
    protected String clinicHistNum;
    protected static int generalHistNum = 0;

    public Pet(String species, String name, String breed, Owner owner, boolean isVaccinated, int desparasitationYear) {

        this.species = species;
        this.name = name;
        this.breed = breed;
        this.owner = owner;
        this.isVaccinated = isVaccinated;
        this.desparasitationYear = desparasitationYear;
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

    public Owner getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", owner=" + owner +
                ", isVaccinated=" + isVaccinated +
                ", desparasitationDate=" + desparasitationYear +
                ", prescription=" + prescription +
                ", clinicHistNum='" + clinicHistNum + '\'' +
                '}';
    }
}
