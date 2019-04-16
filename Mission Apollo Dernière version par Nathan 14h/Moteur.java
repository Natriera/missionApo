
public class  Moteur extends Composant {
	
	int prix;
	int poids; 
	int vitesse; 
	double consomation;
	String nom;
	
	public Moteur( String nom,  int prix, int poids, int vitesse, double consomation){
		super(nom, prix, poids);
		
        this.poids = poids;
        this.prix = prix;
        this.vitesse = vitesse;
        this.nom = nom;
        this.consomation=consomation;
	}
	
	
	public String apercu(){
		
		String apercu = "Composant : " + nom + "\n" ; 
		apercu = apercu + "Poids =" + poids + "\n" ;
		apercu = apercu + "Prix =" + prix + "\n";
		apercu = apercu + "Vitesse =" + vitesse;
		apercu = apercu + "Consommation =" + consomation;
		
		return apercu;
		
	}
}

