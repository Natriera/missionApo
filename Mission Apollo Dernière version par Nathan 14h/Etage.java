
public class Etage extends Composant {
	
	public int poids;
	public int prix;
	String nom; 
	
	int vitesse;
	int stabilite;
	double consomation; 
	int acceleration;
	int volume;

	
	
	Moteur moteur1;
	Moteur moteur2;
	Reservoir reservoir;
	Aile aile;
	Reacteur reacteur;
	
	
	public Etage ( String nom, int prix , int poids ,Moteur moteur1 , Aile aile , Reservoir reservoir , Reacteur reacteur ){
		
    super(nom, prix, poids);
		
		// On affecte les composants au vaisseau
	this.moteur1=moteur1;
	//this.moteur2=moteur2;
	this.reservoir=reservoir;
	this.aile=aile;
	
		// les attributs du vaisseau sont définis par les attributs des composants
	this.consomation=moteur1.consomation;
	this.poids =  reservoir.poids + moteur1.poids + aile.poids ;
	this.vitesse = (   moteur1.vitesse + aile.vitesse ) ;
	this.stabilite = aile.stabilite; 
	this.volume=reservoir.volume;
	
	}
    
    public void updateEtage() {
    this.consomation=moteur1.consomation;
	this.poids =  reservoir.poids + moteur1.poids + aile.poids;
	this.vitesse = (   moteur1.vitesse + aile.vitesse ) ;
	this.stabilite = aile.stabilite; 
	this.volume=reservoir.volume;
        
    }
	
}

