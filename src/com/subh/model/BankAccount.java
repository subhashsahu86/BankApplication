package com.subh.model;

//BankAccount.java
import static java.lang.System.out;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;


public class BankAccount {

	private static String bankName;
	private static String branchName;
	private static String ifsc;

	private long accNum;
	private String accHName;
	private double balance;

	static {
		out.println("\nBankAccount class is loaded");
		try{Thread.sleep(2000);}                       //pausing program Execution for 2 second
		catch(InterruptedException e){}
		
		out.println("\nSV memory allocated with default values");
		try{Thread.sleep(2000);}
		catch(InterruptedException e) {}

		out.println("Reading static variables value from file and initializing them");
		try{Thread.sleep(2000);}
		catch(InterruptedException e){}

		BufferedReader fileReader = null;               //Declaring BR variable
		try{

			/* Connecting to file */                //initialize by variable with object

			fileReader = new BufferedReader (new FileReader("src/files/bankdetails.txt"));

			/*Reading values from file and storing in static variable */

			bankName   = fileReader.readLine();
			branchName = fileReader.readLine();
			ifsc       = fileReader.readLine();

			out.println("SV are initialized with file values \n");
			try{Thread.sleep(2000);}
			catch(InterruptedException e) {}

		}catch(FileNotFoundException e) {
			out.println("Error:bankdetails.txt file is not found");

		}catch(IOException e) {
			e.printStackTrace();

		}finally {
			if(fileReader!= null) {        //condition for not getting NPE
				try{fileReader.close();}   // closing connection to the file 
				catch(IOException e) {}
			}
		}
		 try{Thread.sleep(1000);}
		 catch(InterruptedException e) {}
	} //static block end


	{                   //non-static block initializing accNum

		out.println("NSV memory allocated with default values");
		try{Thread.sleep(2000);}
		catch(InterruptedException e) {}

		out.println("Reading accNum value from file and initalizing it");
		try{Thread.sleep(2000);}
		catch(InterruptedException e) {}

		BufferedReader br = null;

		try{
			/* connecting to file */

			br = new BufferedReader (new FileReader("src/files/accNumSeq.txt"));

			/* reading accNum, converting and storing */

			this.accNum = Long.parseLong(br.readLine()) +1;

			out.println("accNum is initalized with the values\n");
			try{Thread.sleep(1000);}
		    catch(InterruptedException e) {}

		}catch(FileNotFoundException e) {
			out.println("accNumSeq.txt file is not found");

		}catch(IOException e) {
			e.printStackTrace();

		}finally {
			if(br!= null) {
				try{br.close();}
				catch(IOException e) { /* no-op */ }
			}
		}

		//saving new accNum in file
		
		FileWriter filewriter = null;
		try{
			filewriter = new FileWriter("src/files/accNumSeq.txt");

			filewriter.write("" + this.accNum);               //writing data to FW object
			filewriter.flush();                        //moving data from FW to file for saving permanently

		}catch(FileNotFoundException e) {
			out.println("accNumSeq.txt file is not found and unable to create");

		}catch(IOException e) {
			e.printStackTrace ();

		}finally {
			if(filewriter != null) {
				try{ filewriter.close();}
				catch(IOException e) { /* no-op */ }

			}

		}

	} //non-static block is closed


	public BankAccount(String accHName , double balance) {

		out. println("Other NSVs are being initalized with given values\n");
		try{Thread.sleep(2000);}
		catch(InterruptedException e) {}

		this.accHName = accHName;
		this.balance = balance;

		out.println("NSVs are initalized with given object values\n");
		try{Thread.sleep(2000);}
		catch(InterruptedException e) {}

	} //constructor closed


	public static String getBankName() {
		return bankName;
	}
	
	public static String getBranchName() {
		return branchName;
	}

	public static String getIfsc() {
		return ifsc;
	}

	public long getAccNum() {
		return accNum;
	}

	public void setAccHName(String accHName) {
		this.accHName = accHName;
	}

	public String getAccHName() {
		return accHName;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amt) {
		this.balance = this.balance + amt;
	}

	public void withdraw(double amt) {
		this.balance = this.balance - amt;
	}

	public void currentBalance() {
		out.println(balance);
	}


	    @Override
      public String toString() {

          return 
				("\nBank\t:"             + bankName) + "\n" +
			    ("Branch Name\t:"        + branchName) + "\n" +
			    ("Ifsc code\t:"          + ifsc) + "\n" +
			    ("accNum\t\t:"           + accNum) + "\n" +
			    ("accHName\t:"           + accHName) + "\n" +
			    ("balance\t\t:"          + balance) ;
	}	    

} //BankAccount class close
