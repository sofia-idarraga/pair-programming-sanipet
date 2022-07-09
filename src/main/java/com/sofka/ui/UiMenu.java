package com.sofka.ui;

import com.sofka.management.Appointment;
import com.sofka.management.AppointmentType;
import com.sofka.management.Schedule;
import com.sofka.management.StatusType;
import com.sofka.management.Medicine;
import com.sofka.person.Employee;
import com.sofka.person.Owner;
import com.sofka.pet.Pet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class UiMenu {
    //TODO Hacer metodo que borre appointment a terminado

    SetByDefault setByDefault = new SetByDefault();
    Reader reader = new Reader();


    public ArrayList<Pet> pets = setByDefault.setPets();
    public ArrayList<Employee> employees = setByDefault.setEmployees();
    public ArrayList<Appointment> appointments = setByDefault.setAppointment();
    public ArrayList<Medicine> medicineStock = setByDefault.setMedicines();


    // Appointment options must manage CRUD
    // No need to make filterings at medicine
    // Medicine stock displays all the medicine with their data
    // Billing displays quantity, description of appointment, and shouldn't allow for bills of items out of stock
    // Billing should also take taxes into calculus of price (subtotal / total)

    public void displayMenu(){


        int option = 0;

        do{

            System.out.println(
                    """
                    
                    SANIPET - VETERINARY CARE CENTER
                    
                    1. Register Patient
                    2. Appointments
                        1. Create appointment
                        2. Update / Cancel appointment   
                        3. Search appointments by date
                    3. Billing
                    4. Medicine Stock
                    5. Exit
                    
                    """);
            option = reader.scannerInt();

            switch(option){
                case 1:{
                    createPatient();
                    break;
                }
                case 2:{
                    appointmentMenu();
                    break;
                }
                case 3:{
                    //TODO create bill class and implement the prescription builder
                    //Bill bill = new Bill() ??
                }
                case 4:{
                    displayMedicineStock();
                }

            }
        } while(option != 5);
    }

    public void appointmentMenu(){
        int appointmentOption=0;
        //TODO perhaps we could add an option to delete cancelled appointments? it's not hard!
        System.out.println(
                """
                Appointment Options
                
                1. Create appointment
                2. Update / Cancel appointment
                3. Search appointments by date               
                """);
        appointmentOption = reader.scannerInt();

        switch (appointmentOption){
            case 1:{
                createAppointment();
                break;
            }
            case 2:{
                System.out.println("Enter the owner's DNI to update the appointment");
                String dni = reader.scannerText();

                System.out.println(
                        """
                        New status for Appointment:
                        
                        1. FINISHED
                        2. ABSENT
                        3. CANCELLED      
                        """
                );
                int status = reader.scannerInt();
                updateAppointmentStatus(dni,status);
                break;
            }
            case 3:{
                System.out.println("Enter a Date to see the appointments assigned");
                String inputDate = reader.scannerText();
                LocalDate requiredDate = LocalDate.parse(inputDate);
                displayAppointments(requiredDate);
            }
        }
    }

    public void createPatient(){

        System.out.println("Enter owner´s DNI");
        String ownerDNI = reader.scannerText();
        System.out.println("Enter owner´s name");
        String ownerName = reader.scannerText();
        System.out.println("Enter owner´s surname");
        String ownerSurname = reader.scannerText();
        System.out.println("Enter owner´s cellphone");
        String ownerCellphone = reader.scannerText();
        System.out.println("Enter owner´s age");
        int ownerAge = reader.scannerInt();
        if(ownerAge < 18){
            System.out.println("Pet admission is only accepted by an adult ");
            return;
        }

        Owner owner = new Owner(ownerDNI, ownerName, ownerSurname, ownerCellphone, ownerAge);

        System.out.println("Enter the Pet´s species");
        String petSpecies = reader.scannerText();
        System.out.println("Enter the Pet´s name");
        String petName = reader.scannerText();
        System.out.println("Enter the Pet´s breed");
        String petbreed = reader.scannerText();
        System.out.println("Enter 1 if Vaccinated 2 otherwise");
        boolean isPetVaccinated = reader.scannerInt() == 1 ? true : false;
        System.out.println("Enter deparasitation Year. Enter 0 if not deparasitated");
        int deparasitationYear = reader.scannerInt();

        Pet pet = new Pet(petSpecies, petName, petbreed, owner, isPetVaccinated, deparasitationYear);

        pets.add(pet);
        System.out.println("Succesful registration");
        System.out.println(pets.get(0));

        //TODO check dnis
    }

    public void createAppointment(){
        System.out.println("Select your appointment type: ");
        System.out.println("1. MEDICAL");
        System.out.println("2. SURGERY");
        System.out.println("3. AESTHETIC");
        AppointmentType appointmentType = AppointmentType.values()[reader.scannerInt() - 1];

        System.out.println("Enter owner's DNI: ");
        String ownerDni = reader.scannerText();
        Pet pet = searchPetByOwnerDni(ownerDni);
        if(pet == null){
            System.out.println("Your pet is not registered, please register your pet");
            return;
        }
        System.out.println("Input your appointment date: yyyy-mm-dd");
        String stringDate = reader.scannerText();
        LocalDate appointmentDate = LocalDate.parse(stringDate);

        System.out.println("At what hour do you want your appointment?");
        int initialHour = reader.scannerInt();

        Schedule schedule = new Schedule(appointmentDate.getDayOfWeek().getValue(), String.valueOf(initialHour), String.valueOf(initialHour+1));
        System.out.println(schedule);
        Appointment appointment = new Appointment(appointmentType,pet,schedule,appointmentDate);
        appointments.add(appointment);
        System.out.println(appointment.displayInfo());
    }


    public void updateAppointmentStatus(String ownerDni,int status){
        Appointment foundAppointment = null;
        for (Appointment appointment: appointments ) {
            if (ownerDni.equals(appointment.getPet().getOwner().getDni())) {
                foundAppointment = appointment;
                foundAppointment.displayInfo();
                if (status != 3) {
                    foundAppointment.setStatus(StatusType.values()[status]);
                    System.out.println(foundAppointment.displayInfo());
                }
                else if (ChronoUnit.DAYS.between(LocalDate.now(),foundAppointment.getAppointmentDate()) > 2) {
                    foundAppointment.setStatus(StatusType.values()[status]);
                    System.out.println("Appointment has been Cancelled");
                }
                else{
                    System.out.println("Appointments must not be cancelled with less than one day of anticipation");
                }
            }
            else {
                System.out.println("Owner has no appointment");
            }
        }
    }

    public void displayAppointments(LocalDate date){

        boolean noAppointments = true;
        System.out.println("APPOINTMENTS FOR "  + date.toString() + "\n");

        for (Appointment appointment: appointments ) {
            if (date.isEqual(appointment.getAppointmentDate())){;
                System.out.println(appointment.displayInfo() + "\n");
                noAppointments = false;
            }
        }
        if (noAppointments) {
            System.out.println("No appointments programmed for this day!");
        }
    }

    public void displayMedicineStock(){
        System.out.println("MEDICINE CURRENT STOCK: \n");
        for (Medicine medicine : medicineStock){
            System.out.println(medicine.displayInfo(true) + "\n");
        }
    }


    public Pet searchPetByOwnerDni(String ownerDni) {
        Pet foundPet = null;
        for (Pet pet: pets ) {
            Owner owner = pet.getOwner();
            if (ownerDni.equals(owner.getDni())) {
                foundPet = pet;
            }
        }
        return foundPet;
    }

    //TODO call the prescription adder from some place... perhaps the bill class?
    public HashMap<Medicine,Integer> addPrescription(){

        String answer; //For some reason I have to declare the Variable answer here idk why!
        HashMap<Medicine,Integer> prescription = new HashMap<Medicine,Integer>();

        do {

            System.out.println("Medicine name:");
            String requiredMed = reader.scannerText();
            for (Medicine medicine : medicineStock){

                if (requiredMed.equals(medicine.getName())){

                    System.out.println("Quantity to add");
                    int requiredStock = reader.scannerInt();

                    if (requiredStock <= medicine.getStock()){
                        prescription.put(medicine,requiredStock);
                        medicine.decreaseStock(requiredStock);
                        System.out.println("CURRENT PRESCRIPTION:\n" + prescription);
                    }
                    else {
                        System.out.println("Currently there's only " + medicine.getStock() + " units of " + medicine.getName() + " in stock");
                    }
                }
                else {
                    System.out.println("No medicine found with that name");
                }
            }
            System.out.println("Add another medicine? (Y/N)");
            answer = reader.scannerText();

        } while(answer.equals("Y"));
        return prescription;
    }

}
