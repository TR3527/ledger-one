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



        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");


//        // (Transaction class)LocalDate.parse(); - convert date to string to object
//        transactions.add(new Transaction(today,currentTime,"Groceries","Walmart",100.50));
//        transactions.add(new Transaction(today,currentTime,"Gas","Flyers",50.00));
//        transactions.add(new Transaction(today,currentTime,"Date","Mini-golf",60.00));
//

        //.get retrieves from array using index
        //.get(index) + for loop + if statement to search for transactions


//        for (int i = 0; i < transactions.size();i++){
//            System.out.println(transactions.get(i));
//        }

        // OR: for (Transaction transaction : transactions) {
        // System.out.println(transaction);
        //  }
        //CRL + SPACE: shortcut



        boolean continueRunning = true;

        //loop runs until condition is false
        while(continueRunning == true){

            System.out.println("Welcome to Ledger One!");
            System.out.println(" ");
            System.out.println("Pick one of the following options:");
            System.out.println("1 - Add a deposit");
            System.out.println("2 - Make a payment");
            System.out.println("3 - View the ledger");
            System.out.println("4 - Exit");


            System.out.print("Enter your choice: ");
            int userSelection = read.nextInt();

            //read.nextLine(); if int before str


            //OPTION 1 : DEPOSIT
            if (userSelection == 1){

                //retrieves current date and time
                LocalDate depositDate = LocalDate.now();
                LocalTime depositTime = LocalTime.now();

                read.nextLine(); //gets rid of leftover space

                System.out.print("Enter the deposit description: ");
                String depositDescription = read.nextLine();

                System.out.print("Enter vendor name: ");
                String depositVendor = read.nextLine();

                System.out.print("Enter deposit amount: ");
                double depositAmount = read.nextDouble();

                System.out.println("Deposit completed!");

                System.out.println(" ");

                System.out.println("Date: " + depositDate);
                System.out.println("Time: " + depositTime.format(timeFormat));
                System.out.println("Description: " + depositDescription);
                System.out.println("Vendor: " + depositVendor);
                System.out.println("Amount: $" + depositAmount);

                transactions.add();



            } // closes for 1


            //OPTION 2: MAKE PAYMENT
            if (userSelection == 2){

                //retrieves current date and time
                LocalDate paymentDate = LocalDate.now();
                LocalTime paymentTime = LocalTime.now();




            }//closes for 2


            //OPTION 3: VIEW LEDGER
            if (userSelection == 3){


            }//closes for 3


            //OPTION 4: EXIT
            if ( userSelection == 4){
                continueRunning = false;
                System.out.println("Thank You For Visiting!");
            }//closes for 4


            //account for negative numbers, 0 and 5+
            if(userSelection <= 0 || userSelection >=5){

                System.out.println("Invalid input!");

            }//closes for invalid input


            }//While loop ending








//        read.close();


    }
}
