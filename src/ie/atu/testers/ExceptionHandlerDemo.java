package ie.atu.testers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import ie.atu.flight.Date;
import ie.atu.flight.Employee;
import ie.atu.flight.Name;
import ie.atu.flight.Passenger;
import ie.atu.flight.PaymentCard;
import ie.atu.flight.Person;


public class ExceptionHandlerDemo {
   public static void main(String[] args) {
      /////////////
      // Polymorphic ArrayList
      /////////////
      // It is of the super class type, and so it 
      // can hold Passenger or Employee objects! 
      ArrayList<Person> vipList = new ArrayList<Person>();
		
      // Add 2 Passengers and 2 Employees
      vipList.add(new Passenger(new Name("Mr","John","Jones"),
                                 "087 7654321", 
                                 "johnjones@gmail.com",
                                  1, true,
                                 new PaymentCard(1234123412341234L,
                                                 new Date(30,10,2028),999)
                               ));
      vipList.add(new Passenger(new Name("Mrs","Sara","Jones"),
                                 "087 7654321", 
                                 "sara.jones@atu.ie",
                                 1, true,
                                 new PaymentCard(1111123412341234L,
                                                 new Date(30,11,2027),321)
                               ));		

      vipList.add(new Employee(new Name("Mr","Henry","Smyth"),
                              "086 1234567",
                              new Date(20,10,1980), 
                              new Date(10,10,2012),
                              42000.00));
		
      vipList.add(new Employee(new Name("Ms","Lizzie","Swan"),
                              "087 1234567",
                              new Date(18,11,1999),
                              new Date(1,1,2020),
                              2500000.00));

      // Polymorphism means 'many forms'
      // tmpPerson is taking on Employee objects and Passenger objects
      // The toString() from either Employee or Passenger will get called
      // Which toString() gets called will be decided at runtime
      //  depending in the object tmpPerson references
      //  This is called runtime binding!
      
      System.out.println("CURRENTLY IN VIP LOUNGE ARE:");
      for(Person tmpPerson : vipList)
         System.out.println(tmpPerson);

      boolean goodInput=false;
      do {
         // try - signifies my intention to handle any exceptions
         try {
            String numberAsString=JOptionPane.showInputDialog(null,
                  "Enter VIP Person to View ("+1+" to "+ vipList.size()+")");
            int numberToView=Integer.parseInt(numberAsString);
            JOptionPane.showMessageDialog(null,vipList.get(numberToView-1));

            goodInput=true;
         }
         catch(NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null,"Invalid number, re-enter.");
         }
         catch(IndexOutOfBoundsException iobe) {
            JOptionPane.showMessageDialog(null,
                  "Enter number between 1 and "+vipList.size());	    	
         }
         catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Invalid number, re-enter.");
         }
      }while(!goodInput);		
   }
}



