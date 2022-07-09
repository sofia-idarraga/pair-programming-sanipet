package com.sofka.management;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.sofka.management.Medicine;

public class Bill {
    private Appointment appointment;
    private HashMap prescription;
    private int subtotal;
    private double total;
    private final static double taxRate = 1.19;

    public Bill(Appointment appointment, HashMap prescription) {

        this.appointment = appointment;
        this.prescription = prescription;
        this.subtotal = appointment.getAppointmentType().cost;
    }


    public void calculatePrescription(){

        Iterator<Map.Entry<Medicine,Integer>> iterator = this.prescription.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Medicine,Integer> entry = iterator.next();
            Medicine currentMedicine = entry.getKey();
            int currentQuantity = entry.getValue();
            this.subtotal += currentQuantity * currentMedicine.getUnitPrice();
            System.out.println("\t*MEDICINE: " + currentMedicine.getName() + " - QUANTITY: " + currentQuantity + " - COST: " + currentQuantity * currentMedicine.getUnitPrice() + "$");
        }
    }

    public void invoice(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("INVOICE FOR " + this.appointment.getPet().getOwner().getSurname() + " " + this.appointment.getPet().getOwner().getName() + "\n");
        System.out.println(this.appointment.getAppointmentType() + " procedure for a cost of " + this.appointment.getAppointmentType().cost + "$");
        System.out.println("MEDICINE PRESCRIPTION:");
        if (this.prescription.size() > 0){
            calculatePrescription();
        }
        else{
            System.out.println("No prescription Invoiced.");
        }
        System.out.println("\nSUBTOTAL = " + this.subtotal + "$");
        System.out.println("TOTAL (Taxes accounted) = " + this.subtotal * taxRate + "$");
        System.out.println("---------------------------------------------------------------------");
    }

}
