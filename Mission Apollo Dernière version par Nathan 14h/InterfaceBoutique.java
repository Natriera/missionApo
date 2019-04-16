
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.Dimension;
import java.awt.Toolkit;



public class InterfaceBoutique extends JFrame implements ActionListener {
	
    
    JButton butRetour;
    JButton butAcheter;
    JLabel boutique;
    JLabel argent;
    JComboBox composant;
    JComboBox choix;
    Joueur j1;
    JPanel panelComposant = new JPanel();
    JPanel panelChoix = new JPanel();
    JPanel apercu = new JPanel();
    JTextArea textApercu = new JTextArea();
    Moteur nul = new Moteur("",0,0,0,0);
    Composant selection = nul;
    boolean changement = false;
    
    String affichageThune;
    
    LinkedList<Composant> affichage = new LinkedList<Composant>();
    
    Background b;

    
    
    Boutique b1 = new Boutique();
    
    
	public InterfaceBoutique (Joueur j1){
		
        
        Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
        
        int x = d.width;
		int y = d.height;
        
        this.j1 = j1;
        setTitle("Mission Apollo : Boutique");
        this.setLocationRelativeTo(null);
        this.setBounds(0,0,x, y);
        this.setLayout(null);
        this.setVisible(true);
        
		
       
         
        panelComposant.setBounds((int)x/13, (int)y/4, (int)x/4, (int)x/4);
        panelComposant.setBackground(Color.RED);
        this.add(panelComposant);
        
        panelChoix.setBounds((int)x/3, (int)y/4,(int)x/4,(int)x/4);
        panelChoix.setBackground(Color.RED);
        this.add(panelChoix);
        
        int x1= (int) x/10;
        
        apercu.setBounds((int)7*x1,(int)y/3,(int)x/4,(int)x/4);
        apercu.setBackground(Color.RED);
        this.add(apercu);
        
        textApercu.setBounds (10,10,(int)x/5, (int)x/5);
        textApercu.setText("");
        apercu.add(textApercu);
        
        butRetour = new JButton("Retour construction");
        butRetour.setBounds(10,10,200,60);
        butRetour.addActionListener(this);
        this.add(butRetour);
        
        int y1 = y*7;
        
        butAcheter = new JButton("Acheter");
        butAcheter.setBounds((int)x/4,(int)y1/10,300,100);
        butAcheter.addActionListener(this);
        this.add(butAcheter);
        
        boutique = new JLabel("Boutique");
        Font police = new Font("Arial",Font.BOLD,30);
        boutique.setFont(police);
        boutique.setBounds((int)x/3,50,400,50);
        this.add(boutique);
        
        affichageThune = Integer.toString(j1.argent);
        argent = new JLabel(affichageThune);
        argent.setForeground(Color.white);
        argent.setFont(police);
        argent.setBounds(x-200,10,200,60);
        this.add(argent);
        
        String[] tab ={"Corps","Pilote","Moteur","Réservoir","Aile","Réacteur","Etage"}; 
        composant = new JComboBox(tab);
        composant.setBounds(0,0,500,20);
        composant.addActionListener(this);
        panelComposant.add(composant);
        
        
        choix = new JComboBox();
        choix.setBounds(0,0,500,20);
        choix.addActionListener(this);
        panelChoix.add(choix);
        
        b = new Background("hangar.jpg");
        b.setBounds(0,0,d.width,d.height);
        this.add(b);
        
        repaint();
        
	}
    
    
    public void actionPerformed(ActionEvent e) {
        String item = null;
        Object comp;
        
        if(e.getSource() == butRetour){
            this.dispose();
        }
        
        
        
        if (e.getSource() == composant){
			changement = true;
            item =(String) composant.getSelectedItem();
            System.out.println("composant: " +item);
            if(item == "Corps"){
                choix.removeAllItems();
                affichage = b1.listeCorps;
                for(Composant c : affichage){
                    choix.addItem(c);
                }
            }else if (item == "Pilote"){
                choix.removeAllItems();
                affichage = b1.listePilote;
                for(Composant c : affichage){
                    choix.addItem(c);
                }
            }else if (item == "Moteur"){
                choix.removeAllItems();
                affichage = b1.listeMoteur;
                for(Composant c : affichage){
                    choix.addItem(c);
                }
            }else if (item == "Réservoir"){
                choix.removeAllItems();
                
                affichage = b1.listeReservoir;
                for(Composant c : affichage){
                    choix.addItem(c);
                }
            }else if (item == "Aile"){
                choix.removeAllItems();
                affichage = b1.listeAile;
                for(Composant c : affichage){
                    choix.addItem(c);
                }
            }else if (item == "Réacteur"){
                choix.removeAllItems();
                affichage = b1.listeReacteur;
                for(Composant c : affichage){
                    choix.addItem(c);
                }
                System.out.println("items placed");
            }/*else if (item == "Etage"){
                affichage = b1.listeEtage;
                for(Composant c : affichage){
                    choix.addItem(c);
            }*/
           selection=(Composant)choix.getSelectedItem();	
           System.out.println(changement);
           changement=false;
        } 
        
        
        
        if (e.getSource() == choix){
            comp = composant.getSelectedItem();
            System.out.println("choix: " + comp);
            System.out.println(changement);
            //changement = true;
            
            

        }
        
        if (e.getSource() == butAcheter ){
            Composant achat = (Composant) choix.getSelectedItem();
            System.out.println(achat.toString());
            System.out.println(j1.argent);
            System.out.println(achat.prix);
            
            if(achat.prix <= j1.argent){
                j1.acheterComposant(achat);
                System.out.println(j1.argent);
                affichageThune = Integer.toString(j1.argent);
                argent.setText(affichageThune);
                repaint();
            }else{
                JOptionPane.showMessageDialog(this,"Vous manquez d'argent : lancez votre fusée pour en gagner ! ");
            }
                
            this.repaint();
        }
        
        
        if (changement){
			textApercu.setText("");
        }else{
			selection=(Composant)choix.getSelectedItem();
			textApercu.setText(selection.apercu());
		}
        
    }
    
    public Joueur Return() {
        return j1;
        
    }
    
    public void refreshArgent() {
        affichageThune = Integer.toString(j1.argent);
        argent.setText(affichageThune);
    }
}

