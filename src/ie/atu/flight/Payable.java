/**
 * Class: B.Sc. in Computing
 * Instructor: Stephen McGinley

**/
package ie.atu.flight;

public interface Payable {
	public abstract double calculatePay(double taxPercentage);
	// Don't have to put in public abstract
	double incrementSalary(double incrementAmount);
}

// A Java interface can contain only abstract 
// methods, i.e. methods without a body, & constants
// It describes WHAT an implementing class will do,
// not HOW it will do it.

//An interface cannot contain instance variables, or
//constructors, or methods with a body.