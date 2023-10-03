package com.techelevator;

import com.techelevator.coinBank;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class coinBankTest {

    static coinBank coinBank;

    @Before
    public void setup(){
        coinBank = new coinBank(0);
    }

    @Test
    public void test_userInputsMoney_1_expected_balanceEqualsOne(){
        int input = 1;
        int expected = 1;
        String failMessage = String.format("Input %s, expected %s", input, expected);
        coinBank.userInputsMoney(input);
        int result = coinBank.getCurrentBalance();
        Assert.assertEquals(failMessage, expected, result);
    }
    @Test
    public void test_userInputsMoney_5_expected_balanceEqualsFive(){
        int input = 5;
        int expected = 5;
        String failMessage = String.format("Input %s, expected %s", input, expected);
        coinBank.userInputsMoney(input);
        int result = coinBank.getCurrentBalance();
        Assert.assertEquals(failMessage, expected, result);
    }
    @Test
    public void test_userInputsMoney_10_expected_balanceEqualsTen(){
        int input = 5;
        int expected = 5;
        String failMessage = String.format("Input %s, expected %s", input, expected);
        coinBank.userInputsMoney(input);
        int result = coinBank.getCurrentBalance();
        Assert.assertEquals(failMessage, expected, result);
    }
    @Test
    public void test_userInputsMoney_20_expected_balanceEquals20(){
        int input = 5;
        int expected = 5;
        String failMessage = String.format("Input %s, expected %s", input, expected);
        coinBank.userInputsMoney(input);
        int result = coinBank.getCurrentBalance();
        Assert.assertEquals(failMessage, expected, result);
    }
    @Test
    public void test_subtractProductPrice_input1_inputName_inputBin(){
        String name = "";
        String bin = "";
        int inputPrice = 1;
        coinBank.setCurrentBalance(inputPrice);
        int expected = 0;
        String failMessage = String.format("Input %s, expected %s", inputPrice, expected);
        coinBank.subtractProductPrice(inputPrice, name, bin);
        int result = coinBank.getCurrentBalance();
        Assert.assertEquals(failMessage, expected, result);

    }
    @Test
    public void test_subtractProductPrice_input5_inputName_inputBin(){
        String name = "";
        String bin = "";
        int inputPrice = 5;
        coinBank.setCurrentBalance(inputPrice);
        int expected = 0;
        String failMessage = String.format("Input %s, expected %s", inputPrice, expected);
        coinBank.subtractProductPrice(inputPrice, name, bin);
        int result = coinBank.getCurrentBalance();
        Assert.assertEquals(failMessage, expected, result);

    }
    @Test
    public void test_subtractProductPrice_input10_inputName_inputBin(){
        String name = "";
        String bin = "";
        int inputPrice = 10;
        coinBank.setCurrentBalance(inputPrice);
        int expected = 0;
        String failMessage = String.format("Input %s, expected %s", inputPrice, expected);
        coinBank.subtractProductPrice(inputPrice, name, bin);
        int result = coinBank.getCurrentBalance();
        Assert.assertEquals(failMessage, expected, result);

    }
    @Test
    public void test_subtractProductPrice_input20_inputName_inputBin(){
        String name = "";
        String bin = "";
        int inputPrice = 20;
        coinBank.setCurrentBalance(inputPrice);
        int expected = 0;
        String failMessage = String.format("Input %s, expected %s", inputPrice, expected);
        coinBank.subtractProductPrice(inputPrice, name, bin);
        int result = coinBank.getCurrentBalance();
        Assert.assertEquals(failMessage, expected, result);

    }

}
