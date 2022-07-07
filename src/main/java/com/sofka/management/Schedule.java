package com.sofka.management;

import java.time.DayOfWeek;

public class Schedule {

    private DayOfWeek day;
    private String entranceHour;
    private String outHour;

    // Constructor
    public Schedule(int day,  String entranceHour, String outHour){
        this.day = DayOfWeek.of(day);
        this.entranceHour = entranceHour;
        this.outHour = outHour;
    }


    public DayOfWeek getDay() {
        return day;
    }

    public String getEntranceHour() {
        return entranceHour;
    }

    public String getOutHour() {
        return outHour;
    }

}
