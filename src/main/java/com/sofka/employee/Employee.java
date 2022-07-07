package com.sofka.employee;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee {
    protected String name;
    protected String surname;
    protected List<Schedule> schedules = new ArrayList<>();

    public Employee(String name, String surname){
        this.name = name;
        this.surname = surname;
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

}
