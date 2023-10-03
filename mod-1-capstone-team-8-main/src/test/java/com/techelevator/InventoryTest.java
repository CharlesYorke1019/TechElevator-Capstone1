package com.techelevator;

import com.techelevator.items.items;
import org.junit.*;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class InventoryTest {

    static Inventory test;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCapture = new ByteArrayOutputStream();

    @Before
    public void setup() {
        test = new Inventory();
        test.load();
        System.setOut(new PrintStream(outputStreamCapture));
    }

    @Test
    public void test_IsIdInSystem_Inputs_A1_Returns_True() {
        String input = "A1";

        Boolean result = test.isIdInSystem(input);

        String failMessage = "Input: isIdInSystem(\"A1\") should return true, but did not";

        Assert.assertTrue(failMessage, result);
    }

    @Test
    public void test_IsIdInSystem_Inputs_B2_Returns_True() {
        String input = "B2";

        Boolean result = test.isIdInSystem(input);

        String failMessage = "Input: isIdInSystem(\"B2\") should return true, but did not";

        Assert.assertTrue(failMessage, result);
    }

    @Test
    public void test_IsIdInSystem_Inputs_C3_Returns_True() {
        String input = "C3";

        Boolean result = test.isIdInSystem(input);

        String failMessage = "Input: isIdInSystem(\"C3\") should return true, but did not";

        Assert.assertTrue(failMessage, result);
    }

    @Test
    public void test_IsIdInSystem_Inputs_D4_Returns_True() {
        String input = "D4";

        Boolean result = test.isIdInSystem(input);

        String failMessage = "Input: isIdInSystem(\"D4\") should return true, but did not";

        Assert.assertTrue(failMessage, result);
    }

    @Test
    public void test_IsIdInSystem_Inputs_Z1_Returns_False() {
        String input = "Z1";

        Boolean result = test.isIdInSystem(input);

        String failMessage = "Input: isIdInSystem(\"Z1\") should return false, but did not";

        Assert.assertFalse(failMessage, result);
    }

    @Test
    public void test_IsIdInSystem_Inputs_H5_Returns_False() {
        String input = "H5";

        Boolean result = test.isIdInSystem(input);

        String failMessage = "Input: isIdInSystem(\"H5\") should return false, but did not";

        Assert.assertFalse(failMessage, result);
    }

    @Test
    public void test_IsIdInSystem_Inputs_A7_Returns_False() {
        String input = "A7";

        Boolean result = test.isIdInSystem(input);

        String failMessage = "Input: isIdInSystem(\"A7\") should return false, but did not";

        Assert.assertFalse(failMessage, result);
    }

    @Test
    public void test_removeItemFromInventory_A3_ReturnsTrue() {
        String input = "A3";

        Boolean result = test.removeItemFromSystem(input);

        String failMessage = "Input: removeItemFromSystem(\"A3\") should return true, but did not";

        Assert.assertTrue(failMessage, result);
    }

    @Test
    public void test_removeItemFromInventory_B1_ReturnsTrue() {
        String input = "B1";

        Boolean result = test.removeItemFromSystem(input);

        String failMessage = "Input: removeItemFromSystem(\"B1\") should return true, but did not";

        Assert.assertTrue(failMessage, result);
    }

    @Test
    public void test_removeItemFromInventory_Y9_ReturnsFalse() {
        String input = "Y9";

        Boolean result = test.removeItemFromSystem(input);

        String failMessage = "Input: removeItemFromSystem(\"Y9\") should return false, but did not";

        Assert.assertFalse(failMessage, result);
    }
}
