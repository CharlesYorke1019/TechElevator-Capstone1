package com.techelevator.items;

import java.util.List;

public abstract class items {

    private final String binNumber;
    private final String itemName;
    private final int price;
    private final String itemType;
    private final String itemSound;


    public items(String binNumber, String itemName, int price, String itemType, String itemSound) {
        this.binNumber = binNumber;
        this.itemName = itemName;
        this.price = price;
        this.itemType = itemType;
        this.itemSound = itemSound;
    }

    public String getBinNumber() {
        return binNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    public String getItemType() {
        return itemType;
    }

    public String getItemSound(){
        return itemSound;
    }

    public String getElement() {
        return this.binNumber + " | " + this.itemName + " ---> $" + this.price / 100d;
    }


}
