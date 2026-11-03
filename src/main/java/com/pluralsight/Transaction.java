package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Transaction {

    //ENCAPSULATION, do not give easy access
    private LocalDate transactionDate;
    private LocalTime transactionTime;
    private String transactionDescription;
    private String transactionVendor;
    private Double transactionAmount;



    public Transaction(LocalDate transactionDate, LocalTime transactionTime, String transactionDescription,
                       String transactionVendor, Double transactionAmount) {

        //constructor for initialization
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.transactionDescription = transactionDescription;
        this.transactionVendor = transactionVendor;
        this.transactionAmount = transactionAmount;

    }

    //G & S allow access, right click to auto generate
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public LocalTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public String getTransactionVendor() {
        return transactionVendor;
    }

    public void setTransactionVendor(String transactionVendor) {
        this.transactionVendor = transactionVendor;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }


    //gets rid of nanoseconds
    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");


    //override + toString method ensures output comes out correctly.
    @Override

    //example format: "%-8s %-32s $%8.2f   %s"

    public String toString() {
        //ensures proper time format (no nanoseconds)

        // Locale.US: always a dot as decimal separator
        return String.format(Locale.US,"%s %s %s %s %.2f", transactionDate, transactionTime.format(timeFormat),
                transactionDescription, transactionVendor,transactionAmount);
    }


}