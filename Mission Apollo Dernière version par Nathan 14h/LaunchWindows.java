import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;

public class LaunchWindows extends JFrame implements ActionListener{
	
    JButton LaunchBut;
    JPanel Cont = new JPanel();
    Background Fond;
    Rocket Fusee;
    long temps=0;
    boolean decollage = false;
    JButton boost;
    
    
    JLabel essence;
    JLabel Altitude;
    JLabel Argent; // rajouté
    JLabel alerteCouche;
    boolean alerteVisible = false;
    int tempsFrame =0;
    int couche = 1;
    int tempsCouche = 2000;
    Joueur j1;

    
    boolean messageAffiche= false;
    
    
    int argentGagne =0;
    Timer refresh;
    int y = -7000;
    int xFusee=0;
    int yFusee=0;
    
	public LaunchWindows(Joueur j1) {
        
        this.j1 = j1;
        
        setTitle("Mission Apollo : Lancement de la fusée");
        setSize(1200,1000);
        setLocation(100,100);
        this.setLocationRelativeTo(null);
        
        Cont.setLayout(null);
        
        
        
        LaunchBut = new JButton("Décollage");
        LaunchBut.setBounds(this.getWidth()/10,300,150,50);
        Cont.add(LaunchBut);
        LaunchBut.addActionListener(this);
        
        boost = new JButton("Boost");
        boost.setBounds(this.getWidth()/10,100,150,50);
        Cont.add(boost);
        boost.addActionListener(this);
        
        essence = new JLabel(" Essence = " + j1.monVaisseau.essence );
        essence.setBounds (this.getWidth()/10,0,200,50);
        Cont.add(essence);
        essence.setForeground(new Color(255,255,255));
        
        Altitude = new JLabel(" Altitude = " + j1.monVaisseau.altitude + " km");
        Altitude.setBounds (2*this.getWidth()/5,0,200,50);
        Cont.add(Altitude);
        Altitude.setForeground(new Color(255,255,255));
        
        Argent = new JLabel(" Argent Récolté = " + argentGagne + " $");
        Argent.setBounds (4*this.getWidth()/5,0,200,50);
        Cont.add(Argent);
        Argent.setForeground(new Color(255,255,255));
        
        alerteCouche = new JLabel("TRAVERSEE D'UNE COUCHE" ); //+ " RISQUE D'EXPLOSION EGAL À " +(j1.monVaisseau.stabilite /100));
        alerteCouche.setBounds (this.getWidth()/5,this.getHeight()/2,200,200);
        Cont.add(alerteCouche);
        alerteCouche.setForeground(new Color(255,0,0));
        alerteCouche.setVisible(false);
        
        add(Cont);
        Cont.add(LaunchBut);
        
        Fusee = new Rocket();
        Fusee.setBounds(0,0,this.getWidth(),this.getHeight());
        Cont.add(Fusee);
 
        Fond = new Background("space1.jpg");
        Fond.setBounds(0,y,1200,8000);
        Cont.add(Fond);
        
        refresh = new Timer(50,this);
        refresh.start();
        
        
        //Magouille
        /*
      j1.monVaisseau.vitesse = 4800;
      j1.monVaisseau.essence = 800000;
      j1.monVaisseau.stabilite = 0;
      j1.monVaisseau.consomation = 0.0000148;
      j1.monVaisseau.poids = 729002;
      */
      Fusee.crash =false; 
      
      
      
       
    }
    
   
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource() == LaunchBut) {
           decollage = true;
        }
        
        if (e.getSource() == refresh && decollage) {
            
            System.out.println(j1.argent);
            
            //xFusee+=(Math.random()-0.5)*5;
            System.out.println("crashVaisseau"+j1.monVaisseau.crash);
            
           if((j1.monVaisseau.crash == false)&&(Fusee.fin == false)){
            j1.monVaisseau.vol(temps,couche);
            Fond.setLocation(xFusee,(int)j1.monVaisseau.yFond);
            
            // System.out.println(j1.monVaisseau.yFond);
            
            
            this.nouvelleCouche();
            
            
            temps+=50;
            argentGagne += 10000*0.050;
            essence.setText(" Essence = " + j1.monVaisseau.essence);
            Altitude.setText("Altitude = " + j1.monVaisseau.altitude + " km ");
            Argent.setText("Argent = " + argentGagne + " $ ");
            
            
            // Arrivée à une couche
            if (j1.monVaisseau.ariveeCouche ==true ){   
				Fusee.coucheAtteinte = true;
				if ((temps%200 == 0)&& (Fusee.couchePassee==false)) {
					alerteVisible = !alerteVisible;
					alerteCouche.setVisible(alerteVisible);
					}
				if (j1.monVaisseau.passageCouche == true) Fusee.passage=true;
				if (j1.monVaisseau.passageCouche == false) {
					Fusee.passage=false; 
				}
				if (tempsCouche != 0) tempsCouche -= 50;
				else {
					Fusee.couchePassee = true;
					if (j1.monVaisseau.passageCouche == true) {
						Fusee.coucheAtteinte = false;
						tempsCouche = 2000;
						j1.monVaisseau.ariveeCouche = false;
					}
				}   
            }
			}
            
            
            if (j1.monVaisseau.crash){
				Fusee.crash = true;
                
                
				if(tempsFrame % 100 == 0 && Fusee.stade<14) 
                    Fusee.stade+=1;
					tempsFrame +=50;
			}
			
			if ((Fusee.fin == true)&&(messageAffiche == false)){
				 JOptionPane.showMessageDialog(this, "Votre Fusée a explosé après" + j1.monVaisseau.altitude + " km ... Dommage \n" + " Tu as quand même amassé " + argentGagne + " $ ! \n"+ "Tu as ce qu'il te faut pour te construire une nouvelle fusée et repartir de plus belle \n" + " 'Viser la lune ,ça me fait pas peur'. Amel Bent ");
				 messageAffiche = true;
				 // implémenter un retour menu
				} 
        }
        
        if(e.getSource() == boost){
			 j1.monVaisseau.tempsFin = temps+300;
			 j1.monVaisseau.hypervitesse=true;
		 }
        //System.out.println(" crash Vaisseau = " + j1.monVaisseau.crash);
        //System.out.println(" crash Fusee = " + j1.monVaisseau.crash);
    }
    
    public Joueur Return() {
        return j1;
        
    }
    
    public void nouvelleCouche() {
        if(j1.monVaisseau.yFond>0) {
                couche+=1;
                j1.monVaisseau.yFond=-7000;
                j1.monVaisseau.coeffCalcule = false;
                Fusee.couchePassee = false;
                Fond.URL="space"+String.valueOf(couche)+".jpg";
            }
    }
    
    public void reset() {
        j1.monVaisseau.remiseAzero();
        decollage=false;
        j1.argent+=argentGagne;
        argentGagne=0;
        temps=0;
        
        alerteVisible = false;
        tempsFrame =0;
        couche = 1;
        tempsCouche = 2000;
        messageAffiche= false;
        Fusee.stade=1;
        Fusee.i=1;
        Fusee.j=1;
        Fusee.crash = false;
        Fusee.rotation=true;
        Fusee.passage= true;
        Fusee.coucheAtteinte = false;
        Fusee.couchePassee = false;
        Fusee.fin = false;
        Fond.setLocation(xFusee,(int)j1.monVaisseau.yFond);
        Fond.URL="space"+String.valueOf(couche)+".jpg";
        
    }
}



 

