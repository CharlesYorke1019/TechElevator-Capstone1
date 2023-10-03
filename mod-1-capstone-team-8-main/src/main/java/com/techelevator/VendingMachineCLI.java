package com.techelevator;

import com.techelevator.view.Menu;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static final String PURCHASE_MENU_OPTION_DEPOSIT_MONEY = "Add Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_ITEM = "Select Item";
	private static final String PURCHASE_MENU_OPTION_RETURN_TO_MAIN = "Finish Sale";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_DEPOSIT_MONEY, PURCHASE_MENU_OPTION_SELECT_ITEM, PURCHASE_MENU_OPTION_RETURN_TO_MAIN};
	private static final String ADD_MONEY_MENU_OPTION_1 = "$1.00";
	private static final String ADD_MONEY_MENU_OPTION_5 = "$5.00";
	private static final String ADD_MONEY_MENU_OPTION_10 = "$10.00";
	private static final String ADD_MONEY_MENU_OPTION_20 = "$20.00";
	private static final String[] ADD_MONEY_MENU_OPTIONS = {ADD_MONEY_MENU_OPTION_1, ADD_MONEY_MENU_OPTION_5, ADD_MONEY_MENU_OPTION_10, ADD_MONEY_MENU_OPTION_20};



	private static final String[] CHOOSE_ITEM_TO_PURCHASE = {};

	private Scanner testScanner = new Scanner(System.in);

	private Menu menu;
	private Inventory currentInventory;

	private coinBank bank;
	private Log currentLog;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		this.currentInventory = new Inventory();
		this.currentInventory.load();
		this.bank = new coinBank(0);
		this.currentLog = new Log();
	}
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	public void run() {
		String[] menuOptionsArr = MAIN_MENU_OPTIONS;
		boolean isMainMenu = true;
		currentLog.write("---Starting New User Session---");
		while (true) {

			if(!isMainMenu) {
				System.out.printf("\nCurrent Money Provided: $%.2f\n", bank.getCurrentBalance() / 100d);
			}

			switch ((String) menu.getChoiceFromOptions(menuOptionsArr)) {
				case MAIN_MENU_OPTION_DISPLAY_ITEMS:

					this.currentInventory.displayInventory();

					break;

				case MAIN_MENU_OPTION_PURCHASE:



					menuOptionsArr = PURCHASE_MENU_OPTIONS;
					isMainMenu = false;
					break;


				case MAIN_MENU_OPTION_EXIT:
					currentLog.write("---Ending Current User Session---");
					return;

				case PURCHASE_MENU_OPTION_DEPOSIT_MONEY:



					menuOptionsArr = ADD_MONEY_MENU_OPTIONS;

					break;

				case PURCHASE_MENU_OPTION_SELECT_ITEM:



					currentInventory.displayInventory();
					System.out.print("\nPlease Enter an ID >>> ");
					String userInput = menu.runPrinter().nextLine();

					if (!currentInventory.removeItemFromSystem(userInput)) {
						System.out.print("\nWe do not have that item in stock\n");
					} else {
//						bank.subtractProductPrice(currentInventory.itemList.get(0).getPrice());

						for (int i = 0; i < currentInventory.itemList.size(); i++) {

							if (currentInventory.itemList.get(i).getBinNumber().equals(userInput)) {
								bank.subtractProductPrice(currentInventory.itemList.get(i).getPrice(),currentInventory.itemList.get(i).getItemName(),currentInventory.itemList.get(i).getBinNumber());
								System.out.println("\n" + currentInventory.itemList.get(i).getItemSound());
								System.out.println("\n" + currentInventory.itemList.get(i).getItemName() + ": $" + currentInventory.itemList.get(i).getPrice() / 100d);
							}

						}
					}

					menuOptionsArr = PURCHASE_MENU_OPTIONS;

					break;

				case PURCHASE_MENU_OPTION_RETURN_TO_MAIN:

					bank.returnUsersMoney();

					menuOptionsArr = MAIN_MENU_OPTIONS;

					break;

				case ADD_MONEY_MENU_OPTION_1:

					bank.userInputsMoney(100);

					menuOptionsArr = PURCHASE_MENU_OPTIONS;

					break;

				case ADD_MONEY_MENU_OPTION_5:

					bank.userInputsMoney(500);

					menuOptionsArr = PURCHASE_MENU_OPTIONS;

					break;

				case ADD_MONEY_MENU_OPTION_10:

					bank.userInputsMoney(1000);

					menuOptionsArr = PURCHASE_MENU_OPTIONS;

					break;

				case ADD_MONEY_MENU_OPTION_20:

					bank.userInputsMoney(2000);

					menuOptionsArr = PURCHASE_MENU_OPTIONS;

					break;
			}

		}

	}

}

