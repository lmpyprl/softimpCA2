/**
 * Class: Software Implementation
 * Instructor: Stephen McGinley
 * Description: Class PaymentCard - Developed for the Flight System

 */
package ie.atu.flight;

import java.util.Scanner;

public class PaymentCard {
	private long number;
	private Date expiryDate;
	private int securityCode;

	// NO DEFAULT CONSTRUCTOR - prevents user creating a null PaymentCard

	// Initialization constructor
	// Called when a PaymentCard object is created like this ==>
	//    PaymentCard bensCard=new PaymentCard(1111222233334444L,new Date(31,12,2025),999);
	public PaymentCard(long number, Date expiry, int secCode) {   
       this.number=number;
       this.expiryDate=expiry;
       this.securityCode=secCode;
	}
	
	// toString() method
	// ==> Called when a String of the class is used, e.g. - 
	//       System.out.print(joesCard);
	//		 or System.out.print(bensCard.toString());
	@Override
	public String toString(){
	   return "Card Number:" + number;
   
      /*****
         OR try return "ends with " + last4digits;
      *****/     	   
	}	

	// equals() method
	// ==> Called when comparing an object with another object, e.g. -
	//       if(bensCard.equals(new PaymentCard(1111222233334444L,new Date(31,12,2025),999))
	@Override
	public boolean equals(Object obj){
		PaymentCard pcObject;
	   if (obj instanceof PaymentCard)
		   pcObject = (PaymentCard)obj;
	   else
	      return false;
	 
	   return this.number==pcObject.number;
	}

	// NO set() METHODS - prevents user re-setting instance variables
	// You shouldn't be able to reset a PaymentCard number for example
	
	public long getNumber() {
		return number;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public int getSecurityCode() {
		return securityCode;
	}
}
