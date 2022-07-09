package com.sofka.management;

public enum AppointmentType {
    MEDICAL(1), SURGERY(2), AESTHETIC(3);

 int number;
 AppointmentType(int number){
     this.number=number;
 }
}
