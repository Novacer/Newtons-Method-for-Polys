package newtonsMethod.Polynomials;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import newtonsMethod.Polynomials.FindPolyRoots;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
//driver class
public class GUI {
	public static void main(String[] args){
		//ui manager formats the window and font
		UIManager.put("OptionPane.minimumSize",new Dimension(500,250)); 
		UIManager.put("OptionPane.messageFont", new Font("Times New Roman", Font.BOLD, 25));
		
		JOptionPane.showMessageDialog(null, "Please start entering the terms, one by one", "Newton's Method for Polynomials", JOptionPane.PLAIN_MESSAGE);
		
		List<Terms> list = new ArrayList<Terms>();
		JOptionPane.showMessageDialog(null, "Please input the terms of the polynomial. Stop by typing \"stop\".", "Newton's Method for Polynomials", JOptionPane.PLAIN_MESSAGE);
		
		String newTerm = JOptionPane.showInputDialog("Please input a term!");
		while (!newTerm.equals("stop")){
			if ((newTerm.length()>1 || newTerm.equals("x")) && (newTerm.substring(0,1).equals("x") || newTerm.equals("") || newTerm.substring(0,2).equals("+x") || newTerm.substring(0,2).equals("-x"))){
				JOptionPane.showMessageDialog(null, "Please include a coefficient. Ex. \"x^2\" is not ok, but \"1x^2\" is ok.", "Newton's Method for Polynomials", JOptionPane.PLAIN_MESSAGE);
				newTerm = JOptionPane.showInputDialog("Please input another term!");
			}
			else{
				list.add(new Terms(newTerm));
				newTerm = JOptionPane.showInputDialog("Please input another term!");
			}
		}
		Polynomial poly = new Polynomial(list);
		Derivative deri = new Derivative(poly);
		
		JOptionPane.showMessageDialog(null, "Alright, we will now begin using Newton's Algorithm", "Newton's Method for Polynomials", JOptionPane.PLAIN_MESSAGE);
		while(!FindPolyRoots.done){
			JOptionPane.showMessageDialog(null, "Try to choose a starting value close to the x-intercept you want", "Newton's Method for Polynomials", JOptionPane.PLAIN_MESSAGE);
			while(!FindPolyRoots.done){
				double x0 = Double.parseDouble(JOptionPane.showInputDialog("Please choose a starting value!"));
					FindPolyRoots.root(poly, deri, x0);
			}
			
			String check = JOptionPane.showInputDialog("Are you done finding all the roots?");
			if (check.equals("yes") || check.equals("Yes") || check.equals("Y") || check.equals("y")){
			}
			else if (check.equals("no") || check.equals("No") || check.equals("n") || check.equals("N")){
				FindPolyRoots.done = false;
				FindPolyRoots.counter = 0;
			}
		}
		
		JOptionPane.showMessageDialog(null, "Alright! See you next time!!!", "Newton's Method for Polynomials", JOptionPane.PLAIN_MESSAGE);
	}
}
