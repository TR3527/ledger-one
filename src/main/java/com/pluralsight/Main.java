package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.InputMismatchException;
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


            System.out.println(" ");
            int userSelection = 0;

            //handles invalid inputs (example: "ABC" instead of int
            try{

              System.out.print("Enter your choice: ");
              userSelection = read.nextInt();

          }catch (InputMismatchException e){
              read.nextLine();
              System.out.println("Invalid input! Enter 1,2,3 or 4.");

          }
            //read.nextLine(); if int before str

            //OPTION 1 : DEPOSIT

            //why does IF work better than switch statements?
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

                System.out.println(" ");

                //initialization of new object using Transaction class (blueprint), so it can be added to arraylist
                transactions.add(new Transaction(depositDate, depositTime,depositDescription
                ,depositVendor,depositAmount));

                System.out.println("Deposit completed!");

                System.out.println("Date: " + depositDate);
                System.out.println("Time: " + depositTime.format(timeFormat));
                System.out.println("Description: " + depositDescription);
                System.out.println("Vendor: " + depositVendor);
                System.out.println("Deposit amount: $" + depositAmount);

                //TEST output
               // System.out.println(transactions);

            } // closes for 1


            //OPTION 2: MAKE PAYMENT
            if (userSelection == 2){

                //retrieves current date and time
                LocalDate paymentDate = LocalDate.now();
                LocalTime paymentTime = LocalTime.now();

                read.nextLine(); //gets rid of leftover space

                System.out.print("Enter payment description: ");
                String paymentDescription = read.nextLine();

                System.out.print("Enter payment vendor: ");
                String paymentVendor = read.nextLine();

                System.out.print("Enter payment amount: ");
                double paymentAmount = read.nextDouble() * -1;

                transactions.add(new Transaction(paymentDate,paymentTime,
                        paymentDescription,paymentVendor,paymentAmount));

                System.out.println("Payment processed!");

                System.out.println(paymentDate);
                System.out.println(paymentTime.format(timeFormat));
                System.out.println("Description: " + paymentDescription);
                System.out.println("Vendor: " + paymentVendor);
                System.out.println("Payment amount: " + paymentAmount);

                //System.out.println(transactions);


            }//closes for 2


            //OPTION 3: VIEW LEDGER //SUBMENU :1(ALL), 2(DEPOSITS), 3(PAYMENTS),4(RETURN HOME)

            //make userChoiceSubmenu accessible all throughout program
            int userChoiceSubmenu = 1;

               if (userSelection == 3){

                  //<4 , so 4 exits while loop when chosen
                   while(userChoiceSubmenu != 4){


                   System.out.println("===LEDGER ONE===");
                   System.out.println(" ");
                   System.out.println("Options:");
                   System.out.println("1.All transactions");
                   System.out.println("2.Deposits");
                   System.out.println("3.Payments");
                   System.out.println("4. Return to main menu");
                   System.out.println(" ");

                   //handles invalid inputs : "abc"
                   try{

                       System.out.print("Enter your choice: ");
                       userChoiceSubmenu = read.nextInt();

                   }
                   catch (InputMismatchException e2){
                       read.nextLine();
                       System.out.println("Invalid input! Enter 1,2,3 or 4.");

                       //setting to 0
                       userChoiceSubmenu =0;

                       //skips remaining code,starts next iteration. //break : stops loop completely
                       continue;
                   }

                   //handles invalid numbers
                   if(userChoiceSubmenu <= 0 || userChoiceSubmenu >4 ){

                           System.out.println("Invalid input! Enter numbers 1,2,3 or 4.");

                   }//closes for invalid input

                   if (userChoiceSubmenu == 1){

                       System.out.println("All Transactions:");

                       //used for each to iterate over each element of an array list
                       //for each: best for reading data
                       //for loop: use when index is needed or for list structure changes
                       for(Transaction transaction: transactions){

                           System.out.println(transaction);


                       }
                   }

                   if (userChoiceSubmenu == 2) {

                       System.out.println("Deposits:");
                       for (Transaction deposits : transactions) {

                           if (deposits.getTransactionAmount() > 0) {
                               System.out.println(deposits);
                           }
                       }

                   }

                   if(userChoiceSubmenu == 3){

                       System.out.println("Payments:");
                       for(Transaction payments : transactions){

                           if(payments.getTransactionAmount()<0){
                               System.out.println(payments);
                           }
                       }

                   }
               }

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
