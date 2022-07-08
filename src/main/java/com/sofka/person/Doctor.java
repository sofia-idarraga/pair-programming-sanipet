package com.sofka.person;

import com.sofka.management.Schedule;

public class Doctor extends Employee{
    private int workday;

    public Doctor(String name, String surname, int workday) {
        super(name, surname);
        this.workday = workday;
        setSchedule();
    }

    public void setSchedule(){
        switch (workday){
            case 1: {

                Schedule schedule1 =  new Schedule(1,"8AM", "7PM");
                Schedule schedule2 =  new Schedule(2,"8AM", "7PM");
                Schedule schedule3 =  new Schedule(3,"8AM", "7PM");

                this.schedules.add(schedule1);
                this.schedules.add(schedule2);
                this.schedules.add(schedule3);
                break;

            }
            case 2:{
                Schedule schedule4 =  new Schedule(4,"8AM", "7PM");
                Schedule schedule5 =  new Schedule(5,"8AM", "7PM");
                Schedule schedule6 =  new Schedule(6,"9AM", "3PM");

                this.schedules.add(schedule4);
                this.schedules.add(schedule5);
                this.schedules.add(schedule6);
                break;
            }
        }
    }
}
