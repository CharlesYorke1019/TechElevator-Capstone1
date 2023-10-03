package com.techelevator;

import com.techelevator.items.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory {

    private static final String INVENTORY_SOURCE_FILE = "vendingmachine.csv";

    private static final int DEFAULT_STOCK_LEVEL = 5;

    public List<items> itemList = new ArrayList<>();
    public Map<String, List<items>> currentStock = new TreeMap<>();

    /*
    Try to load inventory file
    While inventory has a new line we split the line using the | symbol
    We send that array of strings into the itemSeparateProperties method
    Once received back from method we add the "newItem" to the itemlist
    We create a stockList to set the stock of each item to qty 5
    Create a map called currentStock that has the bin number as the key and stockList as the value.
     */
    public void load(){

        File inventoryFile = new File(INVENTORY_SOURCE_FILE);

        try(Scanner loader = new Scanner(inventoryFile)){
            while (loader.hasNext()){
                String[] itemProperties = loader.nextLine().split("\\|");

                items newItem = itemSeparateProperties(itemProperties);

                itemList.add(newItem);

                List<items> stockList = new ArrayList<>();
                for (int i = 0; i < DEFAULT_STOCK_LEVEL; i++){
                    stockList.add(newItem);
                }

                currentStock.put(newItem.getBinNumber(), stockList);
            }
        }catch (FileNotFoundException fne) {
            System.out.println("File not found, check file location.");
        }


    }

    public items itemSeparateProperties(String[] itemProperties){

        items result = null;

        String bin = itemProperties[0];
        String name = itemProperties[1];
        int pennyPrice = (int)(Double.parseDouble( itemProperties[2]) * 100) ;
        String type = itemProperties[3];

        switch(type.toLowerCase()){

            case "gum":
                result = new gum(bin,name,pennyPrice,type,"Chew Chew, Yum!");
                break;
            case "candy":
                result = new candy(bin, name, pennyPrice, type, "Munch Munch, Yum!");
                break;
            case "chip":
                result = new chips(bin, name, pennyPrice, type, "Crunch Crunch, Yum!");
                break;
            case "drink":
                result = new drink(bin, name, pennyPrice, type, "Glug Glug, Yum");
                break;
            default:
                break;
        }

        return result;
    }

    /*
    We cycle through the item list if the bin number
    If the bin starts with A we add it to alist
    Same for B, C, D
    we send those lists to the console printer
    This separates our inventory into rows
     */
    public void displayInventory() {

        List<items> aList = new ArrayList<>();
        List<items> bList = new ArrayList<>();
        List<items> cList = new ArrayList<>();
        List<items> dList = new ArrayList<>();

        for (items inv : itemList) {
            if (inv.getBinNumber().startsWith("A")){
                aList.add(inv);
            }
            if (inv.getBinNumber().startsWith("B")){
                bList.add(inv);
            }
            if (inv.getBinNumber().startsWith("C")){
                cList.add(inv);
            }
            if (inv.getBinNumber().startsWith("D")){
                dList.add(inv);
            }
        }
        consolePrinter(aList);
        consolePrinter(bList);
        consolePrinter(cList);
        consolePrinter(dList);
    }

    /*
    We have 2 for loops for each line
    We change the color of text at the beginning of the method
    Print a startline
    Print a row of the bin numbers - this comes from the aList above
    Print a new line
    Print a row of the items and the price associated
    In the itemFormat we change that color to green
    If the item is out of stock we change the color to red
    Print separator line
     */
    public void consolePrinter(List<items> printItems){
        String empty = "";
        String headerFormat = "|%1$-11s[%2$2s]%3$-11s|";
        String itemFormat = "| \u001B[32m%1$-19s$%2$3.2f\u001B[34m |";
        String itemFormatOutOfStock = "| \u001B[31m%1$-19s$%2$3.2f\u001B[34m |";
        String startLine = "|---------------------------------------------------  Row %s  --------------------------------------------------|\n";
        String endLine = "|--------------------------------------------------------------------------------------------------------------|\n";
        String spacer = "|                          ||                          ||                          ||                          |\n";

        String ANSI_COLOR = "\u001B[34m";
        String ANSI_RESET = "\u001B[0m";
        System.out.printf(ANSI_COLOR);
        System.out.printf(startLine, printItems.get(0).getBinNumber().charAt(0));
        for (items item : printItems) {
            System.out.printf(headerFormat, empty, item.getBinNumber(), empty);

        }

        System.out.print("\n");
        for (items item : printItems) {
            if(isIdInSystem(item.getBinNumber())){
                System.out.printf(itemFormat, item.getItemName(), item.getPrice() / 100d);
            }else {
                System.out.printf(itemFormatOutOfStock, item.getItemName(), item.getPrice() / 100d);
            }
        }
        System.out.print("\n");
        System.out.printf(endLine);
        System.out.printf(ANSI_RESET);
    }

    public Map<String, List<items>> getCurrentStock() {
        return this.currentStock;
    }

    public boolean isIdInSystem(String itemID) {

        for (Map.Entry<String, List<items>> stock : currentStock.entrySet()) {
            if (stock.getKey().equals(itemID)) {
                if (stock.getValue().size() > 0) {
                    return true;
                }
            }
        }

        return false;
    }
    public boolean removeItemFromSystem(String itemID) {

        for (Map.Entry<String, List<items>> stock : currentStock.entrySet()) {
            if (stock.getKey().equals(itemID)) {
                if (stock.getValue().size() > 0) {
                    stock.getValue().remove(0);
                    return true;
                }
            }
        }return false;

    }


}
