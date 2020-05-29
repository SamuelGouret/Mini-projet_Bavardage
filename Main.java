package finales;

import javax.swing.JFrame;

public class Main {
	// Créé un concierge à l'execution
	public static void main(String[] args) {
	Concierge c= new Concierge();    
	InterConcierge ic = new InterConcierge(c);
	ic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
}
