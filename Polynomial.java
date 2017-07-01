package newtonsMethod.Polynomials;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Polynomial {
	private List<Terms> polynomial;
	/**
	 * constructs a polynomial from a list of terms
	 * @param polynomial the list of terms
	 * @precondition polynomial is a list of Terms objects
	 * @postcondition object has been initialized with the list of terms
	 */
	public Polynomial(List<Terms> polynomial){
		this.polynomial = polynomial;
	}
	/**
	 * calculateFunction calculates the value of the function at x
	 * @param x the number to substitute into the function
	 * @precondition x is a double
	 * @return the value of the function at x
	 */
	public double calculateFunction(double x){
		double value = 0;
		for (Terms term : polynomial){
			value += term.calculateFunction(x);
		}
		return value;
	}
	/**
	 * printTerms iterates over polynomial and prints out each term with a + or - in the middle
	 * @precondition polynomial is a non empty list
	 * @postcondition every element in polynomial has been printed
	 */
	public void printTerms(){
		for (Terms t: polynomial){
			if (t.getCoefficient()>0){
				System.out.print("+");
			}
			System.out.print(t.getTerm() + " ");
		}
	}
	
// accessor methods
	public List<Terms> getPolynomial(){
		return polynomial;
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		List<Terms> list = new ArrayList<Terms>();
		System.out.println("Please input the terms. Type stop to stop");
		String newTerm = input.nextLine();
		
		while (!newTerm.equals("stop")){
			list.add(new Terms(newTerm));
			newTerm = input.nextLine();
		}
		Polynomial poly = new Polynomial(list);
		poly.printTerms();
		
		System.out.println(poly.calculateFunction(0.5));
	}
}
