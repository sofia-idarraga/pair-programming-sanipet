package com.sofka.management;

public enum AppointmentType {
    MEDICAL(120), SURGERY(200), AESTHETIC(70);

 int cost;

 AppointmentType(int cost){
     this.cost=cost;
 }
}
