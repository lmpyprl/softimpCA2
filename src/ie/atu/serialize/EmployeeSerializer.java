package ie.atu.serialize;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ie.atu.flight.Employee;
import ie.atu.flight.Name;

public class EmployeeSerializer {
   private ArrayList<Employee> employees;
	
   private final String FILENAME = "employees.bin";	
   private File employeesFile;	
	
   // Default Constructor
   public EmployeeSerializer(){
      // Construct EmployeeList ArrayList
      employees = new ArrayList<Employee>();
      employeesFile = new File(FILENAME);
      try {
	    	  if(employeesFile.createNewFile()) { System.out.println("File created");}
	    	  else { System.out.println("File exists. ");}
      }
	  catch(Exception e) {
		  System.out.println("Error creating file" + e.toString());
	  }
   }	

   /////////////////////////////////////////////////////////////
   // Method Name : add()                                     //
   // Return Type : void                                      //
   // Parameters : None                                       //
   // Purpose : Reads one Employee record from the user       //
   //           and adds it to the ArrayList called employees //
   /////////////////////////////////////////////////////////////
   public void add(){ 
      // Create an Employee object
      Employee employee = new Employee();
 
      // TODO - Update add() so it checks if Cancel was clicked when reading Employee
       
      // Read its details
      if(employee.readEmployee()) {
    	  employees.add(employee);	
      }
      else {
    	  System.out.println("Employee Add was cancelled. ");
      }
      // And add it to the employees ArrayList
      
   }

   ///////////////////////////////////////////////////////
   // Method Name : list()                              //
   // Return Type : void                                //
   // Parameters : None                                 //
   // Purpose : Lists all Employee records in employees //
   ///////////////////////////////////////////////////////		
   public void list(){
      String employeesToList="";

      if(!employees.isEmpty()) {
         // for every Employee object in employees
         for(Employee tmpEmployee : employees) {
            // add it to employeesToList and
            employeesToList+=tmpEmployee;
            // add a newline
            employeesToList+="\n";
         }
			
         // Display employeesToList in a messageDialog
         JOptionPane.showMessageDialog(null, employeesToList, "EMPLOYEE LIST", JOptionPane.INFORMATION_MESSAGE);	
      }
      else
         // Display "No Employees stored..." in messageDialog
         JOptionPane.showMessageDialog(null, "No Employees to list.", "EMPLOYEE LIST", JOptionPane.INFORMATION_MESSAGE);	
   }	

   ////////////////////////////////////////////////////////////////
   // Method Name : view()                                       //
   // Return Type : Employee                                     //
   // Parameters : None                                          //
   // Purpose : Displays the required Employee record on screen  //
   //         : And returns it, or null if not found             //   
   ////////////////////////////////////////////////////////////////	
   public Employee view(){
      // TODO - Write the code for view()
	   Employee foundEmployee = null;
	   boolean validInput = false;
	   
	   while (!validInput) {
		   try {
			   String input = JOptionPane.showInputDialog(null, "Enter Employee Number:",  "View Employee", JOptionPane.QUESTION_MESSAGE);
			   
			   int empNumber = Integer.parseInt(input);
			   
			   for (Employee emp : employees) {
				   if (emp.getNumber() == empNumber) {
					   foundEmployee = emp;
					   break;
				   }
			   }
			   if (foundEmployee != null) {
				   JOptionPane.showMessageDialog(null, foundEmployee.toString(), "Employee Found", JOptionPane.INFORMATION_MESSAGE);
				   return foundEmployee;
			   }
			   else {
				   JOptionPane.showMessageDialog(null, "Employee not found.", "Error", JOptionPane.ERROR_MESSAGE);
			   }
			   validInput = true;
			   
		   }
		   catch(NumberFormatException e) {
			   JOptionPane.showMessageDialog(null, "Invalid number. Please enter a valid Employee Number.", "InPut Error", JOptionPane.ERROR_MESSAGE);
		   }
		   catch(Exception e) {
			   
		   }
	   }
      			

      return null;		
   }
	
   ///////////////////////////////////////////////////////////////////
   // Method Name : delete()                                        //
   // Return Type : void                                            //
   // Parameters : None                                             //
   // Purpose : Deletes the required Employee record from employees //
   ///////////////////////////////////////////////////////////////////	
   public void delete(){
      // TODO - Write the code for delete()
	   Employee foundEmployee = null;
	   boolean validInput = false;
	   int index =0;
	   
	   while (!validInput) {
		   try {
			   String input = JOptionPane.showInputDialog(null, "Enter Employee Number:",  "View Employee", JOptionPane.QUESTION_MESSAGE);
			   
			   int empNumber = Integer.parseInt(input);
			   
			   for (Employee emp : employees) {
				   if (emp.getNumber() == empNumber) {
					   foundEmployee = emp;
					   break;
				   }
				   index++;
			   }
			   if (foundEmployee != null) {
				   JOptionPane.showMessageDialog(null, foundEmployee.toString(), "Employee to be Deleted", JOptionPane.INFORMATION_MESSAGE);
				   employees.remove(index);
			   }
			   else {
				   JOptionPane.showMessageDialog(null, "Employee not found.", "Error", JOptionPane.ERROR_MESSAGE);
			   }
			   validInput = true;
			   
		   }
		   catch(NumberFormatException e) {
			   JOptionPane.showMessageDialog(null, "Invalid number. Please enter a valid Employee Number.", "InPut Error", JOptionPane.ERROR_MESSAGE);
		   }
		   catch(Exception e) {
			   
		   }
	   }
      JOptionPane.showMessageDialog(null, "delete() method must be coded!", "NOT IMPLEMENTED", JOptionPane.INFORMATION_MESSAGE);			
   }

   ///////////////////////////////////////////////////////////////
   // Method Name : edit()                                      //
   // Return Type : void                                        //
   // Parameters : None                                         //
   // Purpose : Edits the required Employee record in employees //
   ///////////////////////////////////////////////////////////////	
   public void edit(){
      // TODO - Write the code for edit()
	   Employee foundEmployee = null;
	   boolean validInput = false;
	   
	   while (!validInput) {
		   try {
			   String input = JOptionPane.showInputDialog(null, "Enter Employee Number to be edited:",  "Deleted Employee", JOptionPane.QUESTION_MESSAGE);
			   int index =0;
			   int empNumber = Integer.parseInt(input);
			   
			   for (Employee emp : employees) {
				   if (emp.getNumber() == empNumber) {
					   foundEmployee = emp;					   
					   break;					   
				   }
				   index++;
			   }
			   if (foundEmployee != null) {
				   JOptionPane.showMessageDialog(null, foundEmployee.toString(), "Employee Found", JOptionPane.INFORMATION_MESSAGE);
				   
				   JTextField txtTitle = new JTextField(employees.get(index).getName().getTitle());
				   JTextField txtFirstName = new JTextField(employees.get(index).getName().getFirstName());
				   JTextField txtSurname = new JTextField(employees.get(index).getName().getSurname());
				   JTextField txtPhoneNumber = new JTextField(employees.get(index).getPhoneNumber());
				   
				   Object[] message = {
						   "Title:", txtTitle,
				            "First Name:", txtFirstName,
				            "Surname:", txtSurname,
				            "Phone Number:", txtPhoneNumber,
				        };
				   int option = JOptionPane.showConfirmDialog(null, message, 
                           "Edit Employee Details", JOptionPane.OK_CANCEL_OPTION);
				   
				   if ( option == JOptionPane.OK_OPTION) {
					   Name newName = new Name(txtTitle.getText(), txtFirstName.getText(), txtSurname.getText());
					   
					   employees.get(index).setName(newName);
					   employees.get(index).setPhoneNumber(input);
				   }
			   }
			   else {
				   JOptionPane.showMessageDialog(null, "Employee not found.", "Error", JOptionPane.ERROR_MESSAGE);
			   }
			   validInput = true;
			   
		   }
		   catch(NumberFormatException e) {
			   JOptionPane.showMessageDialog(null, "Invalid number. Please enter a valid Employee Number.", "InPut Error", JOptionPane.ERROR_MESSAGE);
		   }
		   catch(Exception e) {
			   
		   }
	   }
      			
   }
	
   // This method will serialize the employees ArrayList when called, 
   // i.e. it will write employees to a file called employees.bin
   public void serializeEmployees(){
      // TODO - Write the code for serializeEmployees()
      ObjectOutputStream os = null;
      
      try {
    	  FileOutputStream fs = new FileOutputStream(employeesFile);
    	  os = new ObjectOutputStream(fs);
    	  
    	  os.writeObject(employees);
    	  System.out.println("Employees have been written to " + employeesFile.getName());
    	  os.close();
      }
      catch(FileNotFoundException e){
          System.out.println("Cannot open file " + employeesFile.getName() + ".");
       }
       catch(IOException e){
          System.out.println("Cannot write to " + employeesFile.getName() + ".");
       }
       
   }

   // This method will deserialize the Employees ArrayList when called, 
   // i.e. it will restore the employees ArrayList from the file employees.bin
   public void deserializeEmployees(){
      ObjectInputStream is=null;

      if( employeesFile.length() != 0) {	   // if there employeesFile is not empty	
         try {
            // Deserialize the ArrayList...
            FileInputStream fileStream = new FileInputStream(employeesFile);
				
            is = new ObjectInputStream(fileStream);
						
            employees = (ArrayList<Employee>)is.readObject();
          
            is.close();
         }
         catch(FileNotFoundException e){
            System.out.println("Cannot open file " + employeesFile.getName() + ".");
         }
         catch(IOException e){
            System.out.println("Cannot read from " + employeesFile.getName() + ". " + e.toString());
         }
         catch(ClassNotFoundException e){
            System.out.println("Employee class not found during deserialization.");
         }
      }
      
      int highestNumber = 9999;
      for (Employee emp : employees) {
          if (emp.getNumber() > highestNumber) {
              highestNumber = emp.getNumber();
          }
      }
      Employee.setNextEmployeeNumber(highestNumber + 1);
   }
}
