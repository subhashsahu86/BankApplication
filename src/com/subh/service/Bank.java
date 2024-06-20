package com.subh.service;

//Bank.java
import java.util.Scanner;

import com.subh.model.BankAccount;
public class Bank {
	
		private BankAccount[] accounts;
		private int           size;
		private Scanner       scanner;

		public Bank() {

		accounts = new BankAccount[10];
		size     = 0;
		scanner  = new Scanner(System.in);

		} //Bank() close


		private void pause() {
			try{Thread.sleep(2000);}
			catch(InterruptedException e) {}
		}

		public void openAccount() {

			System.out.println("Enter Account Holder Name:");
			String accHName = scanner.nextLine();

			System.out.println("Enter balance:");
			double balance = scanner.nextDouble(); scanner.nextLine();

			System.out.println("BankAccount object creation started...");
			pause();      //user defined method


			BankAccount account = new BankAccount(accHName,balance);

			System.out.println("BankAccount object is created");
			pause();

			accounts[size++] = account;
			System.out.println("BankAccount object is stored in Bank");
			pause();

		} //openAccount() method is closed

		private BankAccount getAccount(long accNum) throws IllegalArgumentException {
			if(accNum <= 0)
				throw new IllegalArgumentException(
				                 "Account Number can not be -ve and Zero");

			System.out.println("searching for given account Number object");

			pause();

			// Linear searching algorithm [searching object from "0" to (size-1)index]
			
			for (int i=0;i<size ;i++ ) {   //loop for finding BankAccount object for the given accNumber

				BankAccount account = accounts[i];

				if (account.getAccNum() == accNum)
					return account;

			}   // for loop end 

			return null;

		}  // getAccount() close

		public void deposit( long accNum, double amt) throws IllegalArgumentException {

			System.out.println( "deposit operation start");

			pause();

			// retrivening the Bank Account object of the given account number

			BankAccount account = getAccount(accNum);

			// cheking account and amt valid or not

			if (account == null)
				throw new IllegalArgumentException( 
				             "Account is not found with the given accNum");
				                 
			if(amt<=0)
				throw new IllegalArgumentException
				        ("Amount can not be -ve number and ZERO");

			// deposit given amount in the given account

			account.deposit(amt);
			System.out.println("Cash Rs" + amt +"is Credited to your account");

			pause();

		} // deposit() close

		public void withdraw( long accNum, double amt) throws IllegalArgumentException {

			System.out.println( "Withdraw operation start");

			pause();

			// retrivening the Bank Account object of the given account number

			BankAccount account = getAccount(accNum);

			// cheking account and amt valid or not

			if (account == null)
				throw new IllegalArgumentException( 
				             "Account is not found with the given accNum");
				                 
			if(amt<=0)
				throw new IllegalArgumentException(
				                 "Amount can not be -ve number and ZERO");

			if(amt>account.getBalance())
				throw new IllegalArgumentException("Insufficent funds");

			// withdraw given amount in the given account

			account.withdraw(amt);
			System.out.println("Cash Rs" + amt +"is Debited from your account");

			pause();

		} // withdraw() close

		public void balanceEnquiry(long accNum) throws IllegalArgumentException {
			
			System.out.println("balance enquiry operation start");

			pause();

			// retriving the BankAccount object of the given account Number

			BankAccount account = getAccount(accNum);

			// checking account and balance valid or not 

			if(account == null)
				throw new IllegalArgumentException (
			                 " Account is not found with the given details");

			System.out.println("current balance:");
			account.currentBalance();

			pause();

		} // balance Enquiry close

		public void transferAmount(long sourceAccNum, long destinationAccNum, double amt)
			               throws IllegalArgumentException {

			System.out.println("transfer money operation start");

			pause();

			this.withdraw(sourceAccNum, amt);
			this.deposit(destinationAccNum, amt);

			System.out.println(" transfer money operation end");

				pause();

		} //transferMoney() close

		public void closeAccount(long accNum) throws IllegalArgumentException {

			System.out.println("close Account start");
			pause();

			if(accNum<=0)
				throw new IllegalArgumentException(
				                      "Account number can not be -ve or ZERO");

			System.out.println("searching for give accountNumber object");
			pause();

			// Linear Searching algorithm

			for(int i=0;i<size; i++) {

				BankAccount account =accounts[i];

					if(account.getAccNum() == accNum) {
                                                     //BankAccount object is matched with given accNum
	                     for (int j=i;j<size-1 ;j++ ){         //hence removing current location object
																//by moving next object one location left
							 accounts[j] = accounts[j+1];
	                     }

						accounts[size-1] = null;        // removing reference from object last location
						size--;                         // decreasing size by 1
						

						System.out.println("account is deleted");
						pause();

						return;                // terminating method execution, the given accNum
						                       // object is deleted no need to execute this method logic further

				}

			}//for-loop close

			throw new IllegalArgumentException(
				               "Account is not found with the given details");

		}// closeAccount() end


		public void displayAccount(long accNum) throws IllegalArgumentException {

			System.out.println("\ndisplayAccount operation start");
			pause();


			//retriving the BankAccount object of the given account Number

			BankAccount account = getAccount(accNum);

			// checking account and balance valid or not

			if(account==null)
				throw new IllegalArgumentException (
				                "Account is not found with the given details");

			System.out.println("Account details");
			System.out.println(account);                // >account.toString() is called intrnally in
			                                           // println(), it is executed from BankAccount class,
													   // this account object
		} // close displayAccount() close

			@Override
				public String toString() {

				 if(size==0)
					 return "No accounts found";
				 StringBuilder accountsBuilder = new StringBuilder();
				    
					 for(int i=0;i<size;i++) {
						 accountsBuilder.append("\naccount"+(i+1)+"details:\n");
						 accountsBuilder.append(accounts[i]);
					                                             // internally calls toString() as
					  }                                            // accounts[i].toString()
              
				return accountsBuilder.toString();           // converting StringBuilder object to String object
			                     
			}


		}



			
			





		


