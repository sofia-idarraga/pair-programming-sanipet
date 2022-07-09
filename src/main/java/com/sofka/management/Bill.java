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
    }


    public void setBillingAmount(){

        int prescriptionAccumulator = 0;

        Iterator<Map.Entry<Medicine,Integer>> iterator = this.prescription.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Medicine,Integer> entry = iterator.next();
            System.out.println("");
            prescriptionAccumulator += entry.getValue() * entry.getKey().getUnitPrice();
        }

        this.subtotal = this.appointment.getAppointmentType().cost + prescriptionAccumulator;

        this.total = subtotal * taxRate;


    }




   /* this.subtotal += appointment.getAppointmentType().cost;
        if (prescription.size() > 0) {
        for (int i = 0; i < prescription.size(); i++) {
            this.subtotal += prescription.get();
        }
    }*/


    public String printBill(){

        //TODO perhaps we could add more info about the patient with more getters on the pet class?
        return new StringBuilder()
                .append("PATIENT OWNER: " + this.appointment.getPet().getOwner().getName() + " " +
                        this.appointment.getPet().getOwner().getSurname()+ "\n")
                .append("PROCEDURE: " + this.appointment.getAppointmentType() + "\n")
                .append("STATUS: " + this.status + "\n")

                .append("TIME OF PROCEDURE: " + this.schedule.getEntranceHour() + " to " + this.schedule.getOutHour())
                .toString();
    }



    public String printBill(){

        //billFormat =

        if (this.prescription != null){

        }
        return  billFormat;


    }

}
