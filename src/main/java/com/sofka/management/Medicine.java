package com.sofka.management;

public class Medicine {

    private String name;
    private Presentation presentation;
    private String usage;
    private int dosis;
    private int stock;
    private int unitPrice;

    public Medicine(String name, Presentation presentation, String usage, int dosis, int stock, int unitPrice) {
        this.name = name;
        this.presentation = presentation;
        this.usage = usage;
        this.dosis = dosis;
        this.stock = stock;
        this.unitPrice = unitPrice;
    }


    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void decreaseStock(int decreaseBy){
        this.stock -= decreaseBy;
    }

    public void increaseStock(int increaseBy){
        this.stock += increaseBy;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "name='" + name + '\'' +
                ", presentation=" + presentation +
                ", usage='" + usage + '\'' +
                ", dosis=" + dosis +
                ", stock=" + stock +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public String displayInfo(boolean showDetails){
        String info = ("MEDICINE: " + this.name + " STOCK: " + this.stock + " PRICE: " + this.unitPrice);
        if (showDetails) {
            info = info.concat("\n" + this.presentation + " of " + this.dosis + " dosis for " + this.usage + " use");
        }
        return info;
    }
}
