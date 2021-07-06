package com.company;
//user input
import java.util.Scanner;





public class Account {
    //Class Variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //Class Constructor
    public Account(String name, String id){
        this.customerName = name;
        this.customerID = id;
    }

    //Class Functions
    public void deposit(int amount){
        //amount has to be a positive value
        if (amount != 0){
            this.balance += amount;
            this.previousTransaction = amount;
        }
    }

    public void withdraw(int amount){
        //amount has to be positive value
        if (amount != 0 ){
            this.balance -= amount;
            this.previousTransaction = -amount;
        }
    }

    public void getPreviousTransaction(){
        //if transaction is a positive number
        if (this.previousTransaction > 0){
            System.out.println ("Deposited $"+ this.previousTransaction);
        }
        //if transaction was a negative number
        else if (this.previousTransaction < 0) {
            System.out.println ("Withdrew $"+ Math.abs(this.previousTransaction));
        }
        else{
            System.out.println ("No money withdrawn or deposited. \n Current balance is" + this.balance);
        }
    }


    public void calculateInterest(int years){
        double interest_rate = 0.0185;
        double interest_balance = this.balance + (this.balance*interest_rate*years);
        System.out.println("Current interest rate is "+Double.toString(100*interest_rate).substring(0,3)+"%");
        System.out.println("After "+years+" years your balance will be "+ Double.toString(interest_balance).substring(0,2));

    }

    //Main Display
    public void showMenu(){
        //Place holder
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerID+"\n ");
        System.out.println("What would you like to do?");
        System.out.println("A: Check Balance");
        System.out.println("B: Make deposit");
        System.out.println("C: Make withdrawal");
        System.out.println("D: View previous transaction");
        System.out.println("E: Calculate interest");
        System.out.println("F: Exit");

        //Menu logic
        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option){
                case 'A':
                    System.out.println("Your current balacne is "+this.balance);
                    break;
                case'B':
                    System.out.println("How much would you like to deposit: ");
                    //User input
                    int dep_amount = scanner.nextInt();
                    //function call
                    deposit(dep_amount);
                    System.out.println("You have deposited $"+ dep_amount);
                    System.out.println("Your current balance is $"+this.balance);
                    break;

                case'C':
                    System.out.println("How much would you like to withdrawal: ");
                    //User input
                    int with_amount = scanner.nextInt();
                    //function call
                    withdraw(with_amount);
                    System.out.println("You have withdrawn $"+ Math.abs(with_amount));
                    System.out.println("Your current balance is $"+ this.balance);
                    break;

                case'D':
                    //function call
                    System.out.println("The previous transaction was: \n");
                    getPreviousTransaction();
                    break;

                case'E':
                    System.out.println("Enter amount of years");
                    //user input
                    int num_years = scanner.nextInt();
                    //function call
                    calculateInterest(num_years);
                    break;

                case'F':
                    System.out.println("Thank you");
                    break;
                default:
                    System.out.println("Error invalid option. Please enter A,B,C,D,E or F");
                    break;
            }
        }
        while(option != 'F');
        System.out.println("Thank you for banking with us");

    }
}
