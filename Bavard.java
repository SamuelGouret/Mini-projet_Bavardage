package finales;
import java.awt.Font;
import java.util.ArrayList;

public class Bavard implements PapotageListener{
	private Concierge c;
	public String nom;
	public InterBavard pageMessagerie;

	// Constructeur
	public Bavard(String nom,Concierge c){
		this.c = c;
		this.nom = nom;
		pageMessagerie = new InterBavard(this,c);
	}
	
	// Generation d'un événement PapotageEvent
	public void generatePapotageEvent(String messag, String str){
		PapotageEvent pe = new PapotageEvent(this, messag);
		c.actionPerformed(pe);
		}
	
	// Recupere les informations du message tapé par un bavard donné, créé et affiche une ligne à ajouter dans le chat de tous les bavards
	public String actionPerformed(PapotageEvent pe) {
		Font f1 = pageMessagerie.zoneDeChat.getFont();
		String ligneChat2 = pe.getCorps();
		String ligneChat1 = pageMessagerie.zoneDeChat.getText()+"\n"+pe.getNom().nom+" a dit : ";
		pageMessagerie.zoneDeChat.setText(ligneChat1+ligneChat2);
		pageMessagerie.zoneDeChat.setFont(f1.deriveFont(f1.getStyle() | Font.BOLD));
		return("");
	}
}

