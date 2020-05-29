package finales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

public class InterConcierge extends JFrame implements ActionListener{
	    // Création des variables pour concierge et autres elements graphiques
		public Concierge concierge = new Concierge();
		private JButton connexion = new JButton("Connexion");
		private JTextField nomUti = new JTextField(15);
		private JFrame frame;
		private JLabel welcome = new JLabel("Bienvenu sur Coffee Messenger");
		private JLabel voidlbl;
		private JLabel serveurlbl;
	    private JPanel pan;
		
		public InterConcierge(Concierge c){
			// Définition des elements de la fenêtre
			concierge = c;
		    this.setTitle("Connection");
		    this.setSize(500, 215);
		    this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		    connexion.addActionListener(this);
		    
		    pan = new JPanel(new GridBagLayout());
		    GridBagConstraints c1 = new GridBagConstraints();
		    Font f = welcome.getFont();
		    c1.insets = new Insets(10, 10, 10, 10);
		    
			frame = new JFrame("Serveur");
			frame.setBounds(100, 100, 450, 320);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setContentPane(pan);
			frame.setBackground(Color.GREEN);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			pan.setBackground(Color.GRAY);
			
			serveurlbl = new JLabel();
			serveurlbl.setForeground(Color.WHITE);
			serveurlbl.setText("Entrez votre nom");
			
			voidlbl = new JLabel("");
			voidlbl.setForeground(Color.RED);
			
			welcome.setForeground(Color.CYAN);
			welcome.setFont(f.deriveFont(f.getStyle() | Font.BOLD | Font.ITALIC,20));
			
			
			// ajout et positionnnement des elements graphiques
			c1.gridx=3;
			c1.gridy=2;
			pan.add(serveurlbl, c1);
			
			c1.gridx=3;
			c1.gridy=1;
			pan.add(voidlbl, c1);
			
			c1.gridx=3;
			c1.gridwidth = 1;
			c1.gridy=0;
			pan.add(welcome, c1);
			
			c1.gridx=3;
			c1.gridwidth = 1;
			c1.gridy=5;
			pan.add(connexion, c1);
			
			c1.gridx=3;
			c1.gridy=3;
			pan.add(nomUti, c1);

		}
		
		// Ce qu'il se passe si l'on appuit sur le bouton Connexion
		public void actionPerformed(ActionEvent e) {
			Object  source=e.getSource();
			if (source==connexion) {
				// Si aucun nom n'est saisi, on affiche un message d'erreur et on ne créer pas de bavard
				if(nomUti.getText().equals("")){
					voidlbl.setText("Aucun nom d'utilisateur saisi, merci d'entrer un nom.");
				}		
				/* Si un nom qui n'a pas déjà rentré est saisi :
				on supprime d'enventuels messages d'erreur 
				on créé un bavard et on affiche son interface graphique */
				else if(concierge.verifNom(nomUti.getText())==0){
					Bavard bvrd= new Bavard(nomUti.getText(),concierge);
					concierge.addBavard(bvrd);
					voidlbl.setText("");
					pan.updateUI();
					for (Bavard bvr:concierge.lstDeBavard) {
						}
				}
				// Si un nom qui a été déjà saisi est entré, alors on affiche un message d'erreur et on ne créer pas de bavard
				else if(concierge.verifNom(nomUti.getText())==1){
					pan.updateUI();
					voidlbl.setText("Nom d'utilisateur déjà existant");
					System.out.println("Nom d'utilisateur déjà existant, merci de saisir un autre pseudonyme.");
				}
				
			}
		}	
}
