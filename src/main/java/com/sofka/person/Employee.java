package com.sofka.person;

import com.sofka.management.Schedule;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee {
    protected String name;
    protected String surname;
    protected int workday;
    protected List<Schedule> schedules = new ArrayList<>();

    public Employee(String name, String surname, int workday){
        this.name = name;
        this.surname = surname;
        this.workday = workday;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public void getSchedules(){
        for ( Schedule schedule: schedules) {
            System.out.println(schedule.getDay() + " "+ schedule.getEntranceHour() +" "+ schedule.getOutHour() );
        }
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

            case 3:{
                {
                    for(int i= 1 ; i<=5; i++){
                        Schedule schedule =  new Schedule(i,"8AM", "4PM");
                        this.schedules.add(schedule);
                    }
                    this.schedules.add(new Schedule(6,"9AM","3PM"));
                }
            }
        }
    }

}
