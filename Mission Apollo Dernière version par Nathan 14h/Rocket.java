import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
 
public class Rocket extends JPanel {
	boolean crash = false ;
	int stade =1;
	boolean rotation=true;
	int i =0;
	boolean passage= true;
	boolean coucheAtteinte = false;
	boolean couchePassee = false;
	int j =0;
	boolean fin = false;

  public void paintComponent(Graphics g){
	  //System.out.println("crash : "+crash);
	if (crash == false ){
		BufferedImage img= LoadImage("Rocket.png");
		
		if (coucheAtteinte == true){ // rajouté pour le faire begayer a la couche
			AffineTransform at = AffineTransform.getTranslateInstance(this.getWidth()/2-80,this.getHeight()-600);
			boolean sensPositif = true;
			if (j==-2) sensPositif = false;
			if (j==2) sensPositif = true;
			if (sensPositif == true){ 
				at.rotate(Math.toRadians(j));
				j=-2;
				};
			if (sensPositif == false) {
				at.rotate(Math.toRadians(j));
				j=2;
				};
	  
			Graphics2D g2D = (Graphics2D) g;
			g2D.drawImage(img, at, null);
			 if ((passage == true)&&(couchePassee == true)){ coucheAtteinte = false;} 
			 if ((passage == false )&&(couchePassee == true)) {crash = true; }
			}
		if (coucheAtteinte == false  ){
			g.drawImage(img, this.getWidth()/2-80,this.getHeight()-600, this);
			
			}
	}  
	else {
        //System.out.println("stade"+stade);
		/*if (i<360){
			BufferedImage img= LoadImage("Rocket.png");
			AffineTransform at = AffineTransform.getTranslateInstance(this.getWidth()/2-60,this.getHeight()/2-400);
			at.rotate(Math.toRadians(i+= 10));
	  
			Graphics2D g2D = (Graphics2D) g;
			g2D.drawImage(img, at, null);
			
			
		else{}*/
			if(stade<15){
			BufferedImage img = LoadImage("explosion"+String.valueOf(stade)+".png");
			g.drawImage(img, this.getWidth()/2-80,this.getHeight()-600, this);
			stade = stade+1;
			System.out.println(".");
			}
			if (stade == 15) fin = true; // gérer le fait que ça peut dépasser le stade max vu qu'on l'a déplacé ici
		//}
	}             
  }
  BufferedImage LoadImage(String Filename){
	  BufferedImage img = null;
	  try {
		  img = ImageIO.read(new File(Filename));
		} catch (IOException e) {
		  e.printStackTrace();
		} 
		return img;
	  }               
}
