package com.techelevator;

import com.techelevator.items.*;
import org.junit.*;

public class ItemsTest {

    // created 4 new test items to test out bin numbers and the sounds returned for each item type

    items testGum = new gum("testGumBinNumber", "testGum1", 0, "gum", "Chew Chew, Yum!");

    items testChips = new chips("testChipsBinNumber", "testChips1", 0, "chips", "Crunch Crunch, Yum!");

    items testDrink = new drink("testDrinkBinNumber", "testDrink1", 0, "drink", "Glug Glug, Yum!");

    items testCandy = new candy("testCandyBinNumber", "testCandy1", 0, "candy", "Munch Munch, Yum!");

    // the first four tests were created to ensure that the correct bin number was returned for an item

    @Test
    public void test_GumDispensesCorrectBinNumber_testGumBinNumber() {

        String expected = "testGumBinNumber";

        String failMessage = "Input: testGum.getBinNumber() should return testGumBinNumber, but did not";

        String result = testGum.getBinNumber();

        Assert.assertEquals(failMessage, expected, result);

    }

    @Test
    public void test_ChipDispensesCorrectBinNumber_testChipsBinNumber() {
        String expected = "testChipsBinNumber";

        String failMessage = "Input: testChips.getBinNumber() should return testChipsBinNumber, but did not";

        String result = testChips.getBinNumber();

        Assert.assertEquals(failMessage, expected, result);


    }

    @Test
    public void test_CandyDispensesCorrectBinNumber_testCandyBinNumber() {
        String expected = "testCandyBinNumber";

        String failMessage = "Input: testCandy.getBinNumber() should return testCandyBinNumber, but did not";

        String result = testCandy.getBinNumber();

        Assert.assertEquals(failMessage, expected, result);

    }

    @Test
    public void test_DrinkDispensesCorrectBinNumber_testDrinkBinNumber() {
        String expected = "testDrinkBinNumber";

        String failMessage = "Input: testDrink.getBinNumber() should return testDrinkBinNumber, but did not";

        String result = testDrink.getBinNumber();

        Assert.assertEquals(failMessage, expected, result);
    }

    // the next four tests were created to ensure that the correct sound was returned for an item

    @Test
    public void test_GumReturnsCorrectSound_ChewChewYum() {
        String expected = "Chew Chew, Yum!";

        String failMessage = "Input: testGum.getItemSound() was supposed to return Chew Chew, Yum!, but did not";

        String result = testGum.getItemSound();

        Assert.assertEquals(failMessage, expected, result);
    }

    @Test
    public void test_ChipsReturnsCorrectSound_CrunchCrunchYum() {
        String expected = "Crunch Crunch, Yum!";

        String failMessage = "Input: testChips.getItemSound() was supposed to return Crunch Crunch, Yum!, but did not";

        String result = testChips.getItemSound();

        Assert.assertEquals(failMessage, expected, result);
    }

    @Test
    public void test_CandyReturnsCorrectSound_MunchMunchYum() {
        String expected = "Munch Munch, Yum!";

        String failMessage = "Input: testGum.getItemSound() was supposed to return Munch Munch, Yum!, but did not";

        String result = testCandy.getItemSound();

        Assert.assertEquals(failMessage, expected, result);
    }

    @Test
    public void test_DrinkReturnsCorrectSound_GlugGlugYum() {
        String expected = "Glug Glug, Yum!";

        String failMessage = "Input: testDrink.getItemSound() was supposed to return Glug Glug, Yum!, but did not";

        String result = testDrink.getItemSound();

        Assert.assertEquals(failMessage, expected, result);
    }

}
