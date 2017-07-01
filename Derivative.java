package newtonsMethod.Polynomials;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Derivative {
	List<Terms> derivative;
	/**
	 * constructs the Derivative object from a polynomial based on the power rule
	 * @param polynomial which we'll use to find the derivative
	 * @precondition polynomial is a polynomial in the form y=f(x). It must have at least 1 x-int.
	 * @postcondition the List derivative has size 1
	 */
	public Derivative(Polynomial polynomial){
		List<Terms> temp = polynomial.getPolynomial();
		derivative = new ArrayList<Terms>();
		int co, power;
		for (Terms term: temp){
			co = term.getCoefficient();
			power = term.getPower();
			
			if (power>0){
			derivative.add(new Terms(co*power, power-1));
			}
		}
	}
	/**
	 * calculates the value of the Function.
	 * @param x the value to substitute into the function
	 * @precondition x is a double, derivative is a non-empty list of terms
	 * @postcondition (value != 0)
	 */
	public double calculateFunction(double x){
		double value = 0;
		for (Terms term : derivative){
			value += term.calculateFunction(x);
		}
		return value;
	}
	//prints out the terms of the derivative. for testing purposes only.
	public void printDerivative(){
		for (Terms term : derivative){
			System.out.print(term.getTerm() + " ");
		}
	}
	//for testing purposes only
	public static void main(String[] args){
		List<Terms> list = new ArrayList<Terms>();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please input the terms of the polynomial. Stop by pressing \"stop\".");
		String newTerm = input.nextLine();
		
		while (!newTerm.equals("stop")){
			if (newTerm.length()>1 && (newTerm.substring(0,1).equals("x") || newTerm.substring(0,1).equals("") || newTerm.substring(0,2).equals("+x") || newTerm.substring(0,2).equals("-x"))){
				System.out.println("Please include a coefficient. Ex. \"x^2\" is not ok, but \"1x^2\" is ok.");
				newTerm = input.nextLine();
			}
		
			else{
				list.add(new Terms(newTerm));
				newTerm = input.nextLine();
			}
		}	
		System.out.println(list.get(2).getPower() + " ");
		Polynomial poly = new Polynomial(list);
		Derivative deri = new Derivative(poly);
		
		System.out.println(poly.calculateFunction(0.5));
		System.out.println(deri.calculateFunction(0.5));
		
	}
}
