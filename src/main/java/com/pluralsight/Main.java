package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
   Scanner read = new Scanner(System.in);

        //Array declaration (do not forget import)
        ArrayList<Transaction> transactions = new ArrayList<>();

        //.add to make additions to array (.remove)
        //(LocalDate transactionDate, LocalTime transactionTime, String transactionDescription,
               // String transactionVendor, Double transactionAmount) {

        LocalDate today = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

       // LocalDate.parse(); - convert date to string to object

        transactions.add(new Transaction(today,currentTime,"Groceries","Walmart",100.50));
        transactions.add(new Transaction(today,currentTime,"Gas","Flyers",50.00));
        transactions.add(new Transaction(today,currentTime,"Date","Mini-golf",60.00));


        //.get retrieves from array using index
        //.get(index) + for loop + if statement to search for transactions
        //transactions.get();


        for (int i = 0; i < transactions.size();i++){
            System.out.println(transactions.get(i));
        }

//        for (Transaction transaction : transactions) {
//            System.out.println(transaction);
//        }

        //for ( : )











//        read.close();
    }
}
