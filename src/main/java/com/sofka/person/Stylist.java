package com.sofka.person;

import com.sofka.management.Schedule;

public class Stylist extends Employee{
    public Stylist(String name, String surname) {
        super(name, surname, 3);
        setSchedule();
    }

}
