import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.event.*;
import java.util.LinkedList;

public class BuildWindows extends JFrame implements ActionListener{
    
    JPanel Cont = new JPanel();
    Joueur j1 = new Joueur("");
    Background Composants = new Background("composants.jpg");
    Background Etages = new Background("etages.jpg");
    Rocket Fusee = new Rocket();
    Background Blanc = new Background("blanc.jpg");
    int etage=1;
    
    //Pour afficher l'étage actuel
    JTextArea currentEtage = new JTextArea("Etage 1");
    
    JTextField titre = new JTextField("  STATISTIQUES VAISSEAU");
    JTextArea affichageStats = new JTextArea("");
    
    JComboBox moteur = new JComboBox(recupererComposants(j1.mesMoteurs));
    JComboBox corps = new JComboBox(recupererComposants(j1.mesCorps));
    JComboBox pilote = new JComboBox(recupererComposants(j1.mesPilotes));
    JComboBox reservoir = new JComboBox(recupererComposants(j1.mesReservoirs));
    JComboBox aile = new JComboBox(recupererComposants(j1.mesAiles));
    JComboBox reacteur = new JComboBox(recupererComposants(j1.mesReacteurs));
    
    //Créations des boutons pour changer d'étage
    JButton Butetage1 = new JButton("Etage 1");
    JButton Butetage2 = new JButton("Etage 2");
    JButton Butetage3 = new JButton("Etage 3");
    JButton Butetage4 = new JButton("Etage 4");
    
    JButton ajouter = new JButton("Ajouter");
    
    //Création des étages qui vont constituer la fusée
    Etage etage1;
	Etage etage2;
	Etage etage3;
	Etage etage4;
    
	public BuildWindows(Joueur j1) {
        
        System.out.println("Conso moteur: " + j1.monVaisseau.etage1.moteur1.consomation);
        System.out.println("Conso etage1: " + j1.monVaisseau.etage1.consomation);
        System.out.println("Conso fusee: " + j1.monVaisseau.consomation);
        
        this.j1 = j1;
        
        setTitle("Mission Apollo : Construis ta fusée");
        setSize(1000,800);
        setLocation(100,100);
        
        Cont.setLayout(null);
        Composants.setLayout(null);
        Etages.setLayout(null);
    
        add(Cont);
        
        moteur.setBounds(20,20,200,100);
        corps.setBounds(20,100,200,100);
        pilote.setBounds(20,180,200,100);
        reservoir.setBounds(20,260,200,100);
        aile.setBounds(20,340,200,100);
        reacteur.setBounds(20,420,200,100);
        
        Composants.setBounds(50,100,300,650);
        Composants.setBackground(Color.white);
        
        currentEtage.setBounds(800,20,150,50);
        //currentEtage.setBackground(new Color(0,0,0));
        
        Composants.add(moteur);
        Composants.add(corps);
        Composants.add(pilote);
        Composants.add(reservoir);
        Composants.add(aile);
        Composants.add(reacteur);
        
        ajouter.setBounds(100,680,200,50);
        Cont.add(ajouter);
        Cont.add(Composants);
        
        
        Butetage1.setBounds(100,20,150,40);
        Butetage2.setBounds(250,20,150,40);
        Butetage3.setBounds(400,20,150,40);
        Butetage4.setBounds(550,20,150,40);
        
        
        Butetage1.addActionListener(this);
        Butetage2.addActionListener(this);
        Butetage3.addActionListener(this);
        Butetage4.addActionListener(this);
        ajouter.addActionListener(this);
        
        Etages.add(Butetage1);
        Etages.add(Butetage2);
        Etages.add(Butetage3);
        Etages.add(Butetage4);
        Etages.add(currentEtage);
        
        titre.setBounds(300,300,200,20);
        Blanc.setBounds(700,270,200,200);
        Blanc.setBackground(Color.white);
        affichageStats.setBounds(300,400,50,50);

		Blanc.add(titre);
        Blanc.add(affichageStats);
        
        Cont.add(Blanc);
        
        Etages.setBounds(10,10,900,100);
        Cont.add(Etages);
        
        
        
        
        Background Fond = new Background("hangar.png");
        Fond.setBounds(0,0,this.getWidth(),this.getHeight());
        Cont.add(Fond);
        
       
        
      
        //this.setVisible(true);
        
    }
    
    public Composant[] recupererComposants(LinkedList composant) {
        
        Composant[] listComposants= new Composant[composant.size()];
        for (int i =0;i<composant.size();i++) {
            listComposants[i]=(Composant) composant.get(i);
        }
        return listComposants;
    }
    
    
    
   
    
        public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource() == Butetage1) {
        etage=1;
        currentEtage.setText("Etage 1");
        }
        if(e.getSource() == Butetage2) {
        etage=2;
        currentEtage.setText("Etage 2");
        }
        if(e.getSource() == Butetage3) {
        etage=3;
        currentEtage.setText("Etage 3");
        }
        if(e.getSource() == Butetage4) {
        etage=4;
        currentEtage.setText("Etage 4");
        }
        
        if(e.getSource() == ajouter) {
            
        this.identifierComposant(pilote);
        this.identifierComposant(corps);
        this.identifierComposant(reservoir);
        this.identifierComposant(aile);
        this.identifierComposant(reacteur);
        this.identifierComposant(moteur);
        
        System.out.println(moteur.getSelectedItem());
        System.out.println(pilote.getSelectedItem());
        System.out.println(corps.getSelectedItem());
        System.out.println(reservoir.getSelectedItem());
        System.out.println(aile.getSelectedItem());
        System.out.println(reacteur.getSelectedItem());
        
        this.updateAttributs();
        
        
        System.out.println("Poids Fusée : " + j1.monVaisseau.poids);
        System.out.println("Essence : " + j1.monVaisseau.essence);
        System.out.println("Conso : " + j1.monVaisseau.consomation);
        System.out.println("Stabilite : " + j1.monVaisseau.stabilite);
        System.out.println("Vitesse : " + j1.monVaisseau.vitesse);
        
        }
        
        
    }
    
        public void RecupAchats() {
            updateItems(moteur,j1.mesMoteurs);
            updateItems(corps,j1.mesCorps);
            updateItems(pilote,j1.mesPilotes);
            updateItems(aile,j1.mesAiles);
            updateItems(reacteur,j1.mesReacteurs);
            updateItems(reservoir,j1.mesReservoirs);
            this.repaint();
            
        }
        
        public void updateItems(JComboBox box, LinkedList liste) {
            box.removeAllItems();
            for(int i=0;i<liste.size();i++) {
                box.addItem(liste.get(i).toString());
            }
        }
        
        
        public void identifierComposant(JComboBox box){
            LinkedList<Composant> ListComposants = new LinkedList<Composant>();
            ListComposants.addAll(j1.mesAiles);
            ListComposants.addAll(j1.mesReservoirs);
            ListComposants.addAll(j1.mesPilotes);
            ListComposants.addAll(j1.mesCorps);
            ListComposants.addAll(j1.mesReacteurs);
            ListComposants.addAll(j1.mesMoteurs);
            
            for (int i=0;i<ListComposants.size();i++) {
                if(box.getSelectedItem()==ListComposants.get(i).nom)
                    j1.addComposant(ListComposants.get(i),etage);
            }
        }
        
        
        
        public void updateAttributs() {
            j1.monVaisseau.updateVaisseau();
            j1.monVaisseau.etage1.updateEtage();
            j1.monVaisseau.etage2.updateEtage();
            j1.monVaisseau.etage3.updateEtage();
            j1.monVaisseau.etage4.updateEtage();
            affichageStats.setText(j1.monVaisseau.affichage());
            
        }
}

