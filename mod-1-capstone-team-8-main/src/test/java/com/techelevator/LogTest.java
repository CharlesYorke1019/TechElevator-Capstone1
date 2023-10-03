package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LogTest {

    static Log logger;

    @Before
    public void setup(){
        logger = new Log();
    }
    @Test
    public void test_write_inputEvent_writeToLog(){
        logger.write("testevent");
        String expected = "testevent";
        String failMessage = "Input: logger.write(test event) was supposed to write test event, but did not";

        File logFile = new File("Vending_Machine_Log.txt");
        String result = "";

        try (Scanner scanner = new Scanner(logFile)) {
            while(scanner.hasNext()) {
                String lineOutput = scanner.nextLine();

                if (lineOutput.equals(expected)) {
                    result = lineOutput;
                }

            }

            Assert.assertEquals(failMessage, expected, result);


        } catch (FileNotFoundException fnf) {
            System.out.println("File was not found.");
        }
    }

}
