package com.techelevator;

public class coinBank {
    private Log currentLog = new Log();
    private int currentBalance;

    public coinBank(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    /*
    Take in money added by user
    Add to current balance
    Print to log amount put in and current balance
     */
    public void userInputsMoney(int totalPutIn) {
        this.currentBalance += totalPutIn;
        currentLog.write("FEED MONEY:" + String.format("  $%.2f", totalPutIn / 100d) + String.format("  $%.2f", this.currentBalance / 100d));


    }

    /*
    Takes in the price of the product
    If the current balance is greater than or equal to the price, subtract from current balance
    Write to log the price of product and ending balance of current balance
    If current balance is less than price, print to console informing customer to deposit more money.
     */
    public void subtractProductPrice(int price, String itemName, String itemBin) {
        if(getCurrentBalance() >= price){
            this.currentBalance -= price;
            currentLog.write(itemName + " " + itemBin + String.format("  $%.2f", price /100d) + String.format("  $%.2f", this.currentBalance / 100d));

        }else {
            System.out.println("\nPlease deposit more money to purchase this item.");
        }

    }

    /*
    Return users money
    Divide the total amount by 25 to get number of quarters
    Divide the remainder of 25 by 10 to get number of dimes
    Divide the remainder of 25 and the remainder of 10 by 5 to get number of nickels
    Print to console the change given
    Set the current balance to 0
     */
    public void returnUsersMoney() {

        int quarterAmount = this.currentBalance/25;
        int dimeAmount = (this.currentBalance % 25) / 10;
        int nickelAmount = ((this.currentBalance % 25) % 10) / 5;
        System.out.println("\nChange dispensed:");
        System.out.println("($0.25) --> " + quarterAmount);
        System.out.println("($0.10) --> " + dimeAmount);
        System.out.println("($0.05) --> " + nickelAmount);
        currentLog.write("GIVEN CHANGE: " + String.format("  $%.2f", this.currentBalance / 100d) + "  $0.00");

        this.currentBalance = 0;
    }
}
