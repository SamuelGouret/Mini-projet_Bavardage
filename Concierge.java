package finales;
import java.util.ArrayList;

public class Concierge implements PapotageListener{
	// Création d'une liste de bavards
	public ArrayList<Bavard> lstDeBavard = new ArrayList <Bavard>();
	
	/* Methode qui compare les noms des bavards et renvoie 1 si le nom saisi est déjà existant, 0 sinon
	On utilise cette fonction dans la fonction actionPerformed du bouton connexion de la classe InterConcierge */
	public int verifNom(String str){
		int val = 0;
		for (Bavard e:lstDeBavard) {
			if(e.nom.equals(str))
				val = 1;				
		}
		return val;
	}
	
	// S'il n'existe pas déjà, ajoute un bavard à la liste des bavards
	public void addBavard(Bavard b){
		boolean available = true;
		for (Bavard b0:lstDeBavard) {
			if(b0.nom.equals(b.nom))
				available = false;
		}
		if(available) {
			this.lstDeBavard.add(b);
		}
	}
	
	// Fonction qui récupère le corps (message) d'un bavard
	public String actionPerformed(PapotageEvent pe ) {
		for(Bavard b2:this.lstDeBavard) {
			b2.actionPerformed(pe);
		}
		return(pe.getCorps());
	}
}

