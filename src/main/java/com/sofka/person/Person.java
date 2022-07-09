package com.sofka.person;

public abstract class Person {

    protected String dni;
    protected String name;
    protected String surname;
    protected String cellPhone;
    protected int age;

    public Person(String dni, String name, String surname, String cellPhone, int age) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.cellPhone = cellPhone;
        this.age = age;
    }

    public String getDni() {
        return dni;
    }
    @Override
    public String toString() {
        return "Person{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", age=" + age +
                '}';
    }
}
