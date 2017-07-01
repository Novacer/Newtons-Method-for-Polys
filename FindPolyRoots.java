package newtonsMethod.Polynomials;
import java.util.*;
import newtonsMethod.Polynomials.Terms;
import newtonsMethod.Polynomials.Polynomial;
import newtonsMethod.Polynomials.Derivative;

import javax.swing.JOptionPane;

//static class
public class FindPolyRoots {
	public static final double EPSILON = Math.pow(10,-8); //precision must be within 10^-8 decimal places
	public static boolean done = false;
	public static int counter = 0;
/**
 * root recursively calculates the roots of a polynomial based on Newton's Method
 * uses a counter to prevent a diverging recursion
 * @param poly the polynomial, deri the polynomial's derivative, and x the x-value
 * @precondition poly is a Polynomial, deri is a Derivative, and x is a double, done = false, counter = 0
 */
	public static void root(Polynomial poly, Derivative deri, double x){
		if (Math.abs(poly.calculateFunction(x))<EPSILON){
			JOptionPane.showMessageDialog(null, "A possible root is " + x, "Newton's Method for Polynomials", JOptionPane.PLAIN_MESSAGE);
			done = true;	
		}
		else if (counter > 2000){
			JOptionPane.showMessageDialog(null, "Method Failed! No x intercept found! Pick another value!", "Newton's Method for Polynomials", JOptionPane.PLAIN_MESSAGE);
			counter = 0;
		}
		else if (Math.abs(deri.calculateFunction(x)) < EPSILON){
			JOptionPane.showMessageDialog(null, "Method Failed! Tangent line has no intercept. Pick another value!", "Newton's Method for Polynomials", JOptionPane.PLAIN_MESSAGE);

		}
		else{
			counter++;
			double xn; 
			xn = (x - ((poly.calculateFunction(x))/(deri.calculateFunction(x))));
			root(poly, deri, xn);
		}
	}
	
	public static void main(String[] args){
		List<Terms> list = new ArrayList<Terms>();
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		
		System.out.println("Please input the terms of the polynomial. Stop by pressing \"stop\".");
		String newTerm = input.nextLine();
		
		while (!newTerm.equals("stop")){
			if ((newTerm.length()>1 || newTerm.equals("x")) && (newTerm.substring(0,1).equals("x") || newTerm.equals("") || newTerm.substring(0,2).equals("+x") || newTerm.substring(0,2).equals("-x"))){
				System.out.println("Please include a coefficient. Ex. \"x^2\" is not ok, but \"1x^2\" is ok.");
				newTerm = input.nextLine();
			}
		
			else{
				list.add(new Terms(newTerm));
				newTerm = input.nextLine();
			}
		}	
		
		Polynomial poly = new Polynomial(list);
		Derivative deri = new Derivative(poly);
		System.out.print("The terms of the polynomial are: ");
		poly.printTerms();
		
		System.out.println("Ok, now let's begin using Newton's Method");
		while (!done){
			System.out.println("Pick a new starting value. Try to choose it close to the root you want.");
			while (!done){
				double x0 = input2.nextDouble();
				root(poly, deri, x0);
			}
			System.out.println("Have you found all the roots?");
			
			String check = input.nextLine();
			
			if (check.equals("yes") || check.equals("Yes") || check.equals("Y") || check.equals("y")){
			}
			else if (check.equals("no") || check.equals("No") || check.equals("n") || check.equals("N")){
				done = false;
				counter = 0;
			}
		}
		
		System.out.println("All done! See you next time!");
	}

}
