import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;

public class MenuWindows extends JFrame implements ActionListener {

    JButton But1;
    JButton But2;
    JButton But3;
    LaunchWindows Lancement;
    BuildWindows Construction;
    InterfaceBoutique iBoutique;
    
    
    public MenuWindows(LaunchWindows Lancement, BuildWindows Construction, InterfaceBoutique iBoutique) {
        this.Lancement = Lancement;
        this.Construction = Construction;
        this.iBoutique = iBoutique;
        
        setTitle("Mission Apollo : Menu");
        setSize(300,500);
        setLocation(1200,200);
        
        JPanel Cont = new JPanel();
        Cont.setLayout(null);
        Cont.setBackground(Color.black);
        
        But1 = new JButton("Lancement fusée");
        But1.setBounds(this.getWidth()/4,100,150,50);
        Cont.add(But1);
        But1.addActionListener(this);
        
        But2 = new JButton("Construction fusée");
        But2.setBounds(this.getWidth()/4,200,150,50);
        Cont.add(But2);
        But2.addActionListener(this);
        
        But3 = new JButton("Boutique");
        But3.setBounds(this.getWidth()/4,300,150,50);
        Cont.add(But3);
        But3.addActionListener(this);
        
        add(Cont);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == But1){
           
            Lancement.j1 = iBoutique.Return();
            Lancement.setVisible(true);
            Construction.setVisible(false);
            iBoutique.setVisible(false);
            //Lancement.Fusee = new Rocket();
            Lancement.reset();
            Lancement.repaint();
            
        }
        
        if(e.getSource() == But2){
           
            Construction.j1 = iBoutique.Return();
            Construction.setVisible(true);
            Lancement.setVisible(false);
            iBoutique.setVisible(false);
            Construction.RecupAchats();
            Construction.repaint();
            Lancement.reset();
            Lancement.repaint();
        }
        
        if(e.getSource() == But3){
           
            iBoutique.j1=Lancement.Return();
            Construction.setVisible(false);
            Lancement.setVisible(false);
            iBoutique.setVisible(true);
            Construction.repaint();
            Lancement.reset();
            Lancement.repaint();
            iBoutique.refreshArgent();
        }
        
    }
    
}
