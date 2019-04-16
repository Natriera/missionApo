
public class Reacteur extends Composant {
	
	public int poids;
	public int prix;
	String nom; 
	
	int acceleration;
	
	public Reacteur (String nom, int prix , int poids, int acceleration) {
		
		super(nom, prix, poids);
		this.acceleration=acceleration;
        this.poids = poids;
        this.prix = prix;
        this.nom = nom;
	}
	
	public String apercu(){
		
		String apercu = "Composant : " + nom + "\n" ; 
		apercu = apercu + "Poids =" + poids + "\n" ;
		apercu = apercu + "Prix =" + prix + "\n";
		apercu = apercu + "Acceleration= " + acceleration;
		return apercu;
		
	}
}

