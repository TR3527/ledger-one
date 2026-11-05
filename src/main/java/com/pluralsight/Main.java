package com.pluralsight;

import java.time.*;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.util.function.Predicate.isEqual;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        //Array declaration (do not forget import)
        ArrayList<Transaction> transactions = new ArrayList<>();
        //.add to make additions to array (.remove)


        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime timeToday = LocalTime.now();
        LocalDate dateToday = LocalDate.of(2026,1,2);
        Month currentMonth = dateToday.getMonth();
        int currentYear = dateToday.getYear();

        //object creation (used for testing purposes)
//        Transaction transaction = new Transaction(dateToday, timeToday,"transactionDescription",
//                 "transactionVendor", 100.00);

        Transaction transaction = new Transaction(LocalDate.of(2025,12,1),
                timeToday,"Invoice", "Juan", 100.00);
        transactions.add(transaction);

        Transaction transaction2 = new Transaction(LocalDate.of(2026,1,1),
                timeToday,"Invoice", "John", 200.00);
        transactions.add(transaction2);


        // transaction.getTransactionDate().getMonth(); //extracts month

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
        while (continueRunning) {

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
            try {

                System.out.print("Enter your choice: ");
                userSelection = read.nextInt();

            } catch (InputMismatchException e) {
                read.nextLine();
                System.out.println("Invalid input! Enter 1,2,3 or 4.");

            }
            //read.nextLine(); if int before str

            //OPTION 1 : DEPOSIT

            //why does IF work better than switch statements?
            if (userSelection == 1) {

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
                transactions.add(new Transaction(depositDate, depositTime, depositDescription
                        , depositVendor, depositAmount));

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
            if (userSelection == 2) {

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

                transactions.add(new Transaction(paymentDate, paymentTime,
                        paymentDescription, paymentVendor, paymentAmount));

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

            if (userSelection == 3) {

                //<4 , so 4 exits while loop when chosen
                while (userChoiceSubmenu != 5) {


                    System.out.println("===LEDGER VIEW===");
                    System.out.println(" ");
                    System.out.println("Options:");
                    System.out.println("1.All transactions");
                    System.out.println("2.Deposits");
                    System.out.println("3.Payments");
                    System.out.println("4.Reports");
                    System.out.println("5. Return to main menu");
                    System.out.println(" ");

                    //handles invalid inputs : "abc"
                    try {

                        System.out.print("Enter your choice: ");
                        userChoiceSubmenu = read.nextInt();

                    } catch (InputMismatchException e2) {
                        read.nextLine();
                        System.out.println("Invalid input! Enter 1,2,3,4 or 5.");

                        //setting to 0
                        userChoiceSubmenu = 0;

                        //skips remaining code,starts next iteration. //break : stops loop completely
                        continue;
                    }

                    //handles invalid numbers (0 and 5+)
                    if (userChoiceSubmenu <= 0 || userChoiceSubmenu > 5) {

                        System.out.println("Invalid input! Enter numbers 1,2,3,4 or 5.");

                    }//closes for invalid input


                    if (userChoiceSubmenu == 1) {

                        System.out.println("All Transactions:");

                        //used for each to iterate over each element of an array list
                        //for each: best for reading data
                        //for loop: use when index is needed or for list structure changes
//                       for(Transaction transaction: transactions){
//
//                           System.out.println(transaction);
//
//
//                       }

                        //prints in reverse order, size()-1 refers to last index, get(i) prints current index
                        for (int i = transactions.size() - 1; i >= 0; i--) {
                            System.out.println(transactions.get(i));
                        }
                    }

                    if (userChoiceSubmenu == 2) {

                        System.out.println("Deposits:");
                        //pre new order: for (Transaction deposits : transactions)

                        for (int i = transactions.size() - 1; i >= 0; i--) {

                            if (transactions.get(i).getTransactionAmount() > 0) {

                                System.out.println(transactions.get(i));
                            }


                        }

                    }

                    if (userChoiceSubmenu == 3) {

                        System.out.println("Payments:");
                        // for(Transaction payments : transactions)
                        for (int i = transactions.size() - 1; i >= 0; i--) {

                            if (transactions.get(i).getTransactionAmount() < 0) {

                                System.out.println(transactions.get(i));
                            }
                        }

                    }
                    int reportSubmenuChoice = 1;

                    if (userChoiceSubmenu == 4) {

                        while (reportSubmenuChoice != 6) {

                            System.out.println("Pick report type: ");
                            System.out.println("1.Month-to-Date");
                            System.out.println("2.Previous Month");
                            System.out.println("3.Year-to-Date:");
                            System.out.println("4.Previous Year");
                            System.out.println("5.Search by Vendor");
                            System.out.println("6.Return to View Ledger Menu");

                            try {

                                System.out.print("Enter your choice: ");
                                reportSubmenuChoice = read.nextInt();

                            } catch (InputMismatchException e2) {
                                read.nextLine();
                                System.out.println("Invalid input! Enter 1,2,3,4, 5 or 6.");

                                reportSubmenuChoice = 0;

                                //skips remaining code,starts next iteration. //break : stops loop completely
                                continue;
                            }

                            if (reportSubmenuChoice <= 0 || reportSubmenuChoice > 6) {

                                System.out.println("Invalid input! Enter numbers 1,2,3,4, 5 or 6.");

                            }//closes for invalid input


                            if (reportSubmenuChoice == 1) {

                                for (Transaction monthToDate : transactions) {

                                    //year comparison //can also combine both comparisons using &&
                                    if (monthToDate.getTransactionDate().getYear() == currentYear) {


                                        //month comparison
                                        if (monthToDate.getTransactionDate().getMonth().equals(currentMonth)) {


                                            //checks if transaction was before today or equal to today
                                            if (monthToDate.getTransactionDate().isBefore(dateToday) ||
                                                    monthToDate.getTransactionDate().isEqual(dateToday)) {

                                                System.out.println(monthToDate);
                                            }
                                        }
                                    }
                                }//closes for loop
                            }


                            if (reportSubmenuChoice == 2) {

                                Year currentYear2 = Year.now();
                                Year previousYear = Year.of(currentYear2.getValue());
                                Month previousMonth = currentMonth.minus(1);

                                if (currentMonth == Month.JANUARY) {

                                    previousYear = currentYear2.minusYears(1);

                                }
                                for (Transaction previousMonthTransactions : transactions) {

                                    //checks if transaction belongs to previous month
                                    if (previousMonthTransactions.getTransactionDate().getMonth().equals(previousMonth)) {

                                        //transaction year == previous year?
                                        if (previousMonthTransactions.getTransactionDate().getYear() == previousYear.getValue()) {

                                            System.out.println("Previous Month Transactions: " + previousMonthTransactions);

                                        }
                                    }

                                }//view reports option

                            }//closing for option 2


                        } //closes for option 4

                    }

                }

                //OPTION 5: EXIT
                if (userSelection == 4) {
                    continueRunning = false;
                    System.out.println("Thank You For Visiting!");
                }//closes for 4


                //account for negative numbers, 0 and 5+
                if (userSelection <= 0 || userSelection > 4) {

                    System.out.println("Invalid input!");

                }//closes for invalid input

            }//while loop for report submenu


        }//closes for 3(View Ledger option)


    }
}
    //While loop ending


//        read.close();






