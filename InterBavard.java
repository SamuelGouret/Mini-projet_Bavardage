package finales;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InterBavard extends JFrame implements ActionListener{
	// Création des variables pour bavard concierge et autres elements graphiques
	private Bavard connecté;
	private Concierge conci;
	private JPanel pan = new JPanel();
	public JTextField zoneMessage = new JTextField(25);
	private JList<String> users = new JList<String>();
	public JTextArea zoneDeChat = new JTextArea(18,20);
	private JScrollPane fenetreDeroulante = new JScrollPane(zoneDeChat, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private JButton broadcast = new JButton("Envoyer message");
	private JLabel lab = new JLabel();
	private JLabel chatlbl = new JLabel();
	private JLabel messagelbl = new JLabel();
	
	
	// Création de l'interface graphique d'un bavard / client
	public InterBavard(Bavard b,Concierge c){
		connecté = b;
		conci = c;
		DefaultListModel<String> model = new DefaultListModel<String>();
		for(Bavard e:conci.lstDeBavard) {
			    model.addElement(e.nom);
			}
		users.setModel(model);
		
		// Défnition de la fenetre et de ses paramètre
		this.setTitle("Messagerie bavard");
	    this.setSize(550, 510);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // définition d'une grille pour positionner les éléments graphiques
	    pan.setLayout(new GridBagLayout());
	    GridBagConstraints c2 = new GridBagConstraints();
	    c2.weightx = 0;
	    c2.weighty = 1;
	    c2.fill = GridBagConstraints.HORIZONTAL;
	    c2.insets = new Insets(5, 5, 5, 5);
	    
	    
	    // définition des couleurs, texte dans les labels, typographie de ses dernières
	    Font f = lab.getFont();
	    lab.setFont(f.deriveFont(f.getStyle() | Font.BOLD | Font.ITALIC));
	    lab.setText("Vous êtes : " +b.nom);
	    chatlbl.setText("Fenêtre de discussion : ");
	    messagelbl.setText("Tapez votre message ici : ");
	    pan.setBackground(Color.CYAN);
	    
	    // Ajout des elements graphiques au panel
	    
	    c2.gridx = 0; c2.gridy = 2; pan.add(fenetreDeroulante, c2);
		
		c2.gridx = 0; c2.gridy = 0; pan.add(lab, c2);
	    
		c2.gridx = 0; c2.gridy = 1; pan.add(chatlbl, c2);
	    
		c2.gridx = 0; c2.gridy = 3; pan.add(messagelbl, c2);
	    
		c2.gridx = 0; c2.gridwidth = 4; c2.gridy = 4; pan.add(zoneMessage, c2);
	    
	    c2.gridx = 0; c2.gridwidth = 4; c2.gridy = 5; pan.add(broadcast, c2);

	    // On ne peut changer les dimentions de la fenetre
		zoneDeChat.setEditable(false);
		// affectation de l'interface pan + rendue visible
	    this.setContentPane(pan);
	    this.setVisible(true);
	    // Permet d'exectuer l'actionPerformed()
	    broadcast.addActionListener(this);
	    
	}

		// methode executant la diffusion d'un message lors de l'appui sur le bouton envoyer message
	    public void actionPerformed(ActionEvent e) {
			Object  src=e.getSource();
			if (src.equals(broadcast)) {  
				connecté.generatePapotageEvent(zoneMessage.getText(), connecté.nom);
			}				
	}
}
