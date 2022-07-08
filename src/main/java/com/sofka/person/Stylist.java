package com.sofka.person;

import com.sofka.management.Schedule;

public class Stylist extends Employee{
    public Stylist(String name, String surname) {
        super(name, surname);
    }
    public void setSchedule(){
        for(int i= 1 ; i<=5; i++){
            Schedule schedule =  new Schedule(i,"8AM", "4PM");
            this.schedules.add(schedule);
        }
        this.schedules.add(new Schedule(6,"9AM","3PM"));
    }
}
