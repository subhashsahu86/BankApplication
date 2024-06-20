package com.subh.client;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.subh.service.Bank;

class BankFrontOffice {
	public static void main(String[] args) {

	     Bank hdfcBank = new Bank();

		Scanner scn = new Scanner(System.in);

		

		loop: while(true) {

		try{

				System.out.println("\nChoose one option");
				System.out.println("1.Open Account");
				System.out.println("2.Account Details");
				System.out.println("3.Deposit");
				System.out.println("4.Withdraw");
				System.out.println("5.Balance Enquiry");
				System.out.println("6.Transfer Money");
				System.out.println("7.Display All Account");
				System.out.println("8.Update Account Details");
				System.out.println("9.Exit");

				System.out.print("Enter Option:");
				int option = scn.nextInt();  scn.nextLine();

		

				switch(option) {

					case 1: { //open Account
						hdfcBank.openAccount();
						break;
					}

					case 2 : { //Account Details
						System.out.println("Enter account number:");
						long accNum = scn.nextLong(); scn.nextLine();

						hdfcBank.displayAccount(accNum);
						break;
					}

					case 3 : { //Deposit
						System.out.println("Enter Account NUmber:");
						long accNum = scn.nextLong(); scn.nextLine();

						System.out.println("Enter deposit amount:");
						double amt = scn.nextDouble(); scn.nextLine();

						hdfcBank.deposit(accNum, amt);
						break;
					}

					case 4 : { //withdraw
						System.out.println("Enter Account Number:");
						long accNum = scn.nextLong(); scn.nextLine();

						System.out.println("Enter withdraw amount:");
						double amt = scn.nextDouble(); scn.nextLine();

						hdfcBank.withdraw(accNum, amt);
						break;

					}

					case 5: { // Balance Enquiry
						System.out.println("Enter account Number");
						long accNum = scn.nextLong(); scn.nextLine();

						hdfcBank.balanceEnquiry(accNum);
						break;
					}

					case 6 : { // Transfer Money
						System.out.println("Enter source account Number");
						long srcAccNum = scn.nextLong(); scn.nextLine();

						System.out.println("Enter destination account Number");
						long destAccNum = scn.nextLong(); scn.nextLine();

						System.out.println("Enter the Amount:");
						double amt = scn.nextDouble(); scn.nextLine();

						hdfcBank.transferAmount(srcAccNum,destAccNum,amt);
						break;
					}

					case 7 : { // Display all accounts
						System.out.println(hdfcBank);
						
						break;
					}

					/*
					 * case 8 : { // Update Account Details
					 * System.out.println("Enter the account Number:"); long accNum =
					 * scn.nextLong(); scn.nextLine();
					 * 
					 * // hdfcBank.updateAccount(accNum);
					 * 
					 * break; }
					 */

					case 9 : { // Exit
						System.out.println("_/\\_/\\_/\\_Thank You,Please visit Again_/\\_/\\_/\\_");
						break loop;

					}

						default: 
							System.out.println("Error:Invalid option");
					}// switch end

				
     

	            }catch (IllegalArgumentException e) {
					System.out.println("Error:"+e.getMessage());

				}catch (InputMismatchException e) {
					System.out.println("Enter only Number");
					scn.nextLine();
				}

				try{Thread.sleep(2000);}
				catch(InterruptedException e)  { /*no-op*/}
				
		} // while(true) end

	} //main close

} //class close
