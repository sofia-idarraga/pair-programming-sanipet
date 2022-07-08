package com.sofka.person;

import com.sofka.management.Schedule;

public class Doctor extends Employee{
    private int workday;

    public Doctor(String name, String surname, int workday) {
        super(name, surname, workday);
        setSchedule();
    }
}
