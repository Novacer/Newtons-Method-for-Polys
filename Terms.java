package newtonsMethod.Polynomials;
/**
 * 
 * @terms are individual terms of a polynomial
 * @contains the coefficient, and the power
 * @return the corresponding function value at a particular x
 * 
 */
public class Terms {
	private String term;
	private int coefficient;
	private int power;
	
/**constructor
* @param term.substring(0,1) is an integer. example: x^2 is not ok, 1x^2 is ok!
*/
	public Terms(String term){
		this.term = term;
		int temp = term.indexOf("x");
		boolean hasX;
		if (temp<0){
			coefficient = Integer.parseInt(term);
			power = 0;
			hasX = false;
		}
		else{
		coefficient = Integer.parseInt(term.substring(0, temp));
		hasX = true;
		}
		int raisePower = term.indexOf("^");
		if (raisePower<0 && hasX){ //check if above "else" loop was run
			power = 1;
		}
		else if(hasX){
			power = Integer.parseInt(term.substring(raisePower+1));
		}
	}
	/**
	 * overloaded constructor, allows term to be constructed just by a coefficient and power
	 * will be called by the Derivative class
	 * @param coefficient
	 * @param power
	 */
	public Terms(int coefficient, int power){
		this.coefficient = coefficient;
		this.power = power;
		this.term = coefficient +"x^"+ power;
	}
	/**
	 * calculateFunction calculates the value of the term by substituting a value into the x
	 * @precondition x is a double
	 * @param x the value to substitue into the function
	 * @return the value of the term at x
	 */
	public double calculateFunction(double x){
		if (term.indexOf("x")<0){
			return ((double)coefficient);
		}
		else{
			return ((Math.pow(x,power))*coefficient);
		}
	}
// the accessors
	public String getTerm(){
		return term;
	}
	public int getCoefficient(){
		return coefficient;
	}
	public int getPower(){
		return power;
	}

}
