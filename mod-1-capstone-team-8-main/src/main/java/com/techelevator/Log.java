package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Log {

    private LocalDateTime time;

    private String dateTime;

    private File logFile;
    private final DateTimeFormatter D_AND_T_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a ");
    private static final String DEFAULT_LOG_FILE_NAME = "Vending_Machine_Log.txt";

    public Log(){
        logFile = new File (DEFAULT_LOG_FILE_NAME);
    }

    public void write(String event){
            try (PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))){
                time = LocalDateTime.now();
                dateTime = time.format(D_AND_T_FORMATTER);

                if (!event.equals("testevent")) {
                    writer.write(dateTime + event + "\n");
                } else {
                    writer.write(event + "\n");
                }

//                writer.write(dateTime + event + "\n");
            }catch (FileNotFoundException fne){
                System.out.println("file not found");
            }
    }
}
