package finales;

import java.util.EventObject;

public class PapotageEvent extends EventObject{
	private Bavard bavard;
	private String corps;
	// Nos messages sont simples et ne requièrent pas de sujets 
	
	// Constructeur
	public PapotageEvent(Object src, String corps) {
		super(src);
		this.corps = corps;
		bavard = (Bavard)src;
	}
	// Recuperation nom
	public Bavard getNom() {
		return this.bavard;
	}
	// Recuration contenu
	public String getCorps() {
		return this.corps;
	}

}
