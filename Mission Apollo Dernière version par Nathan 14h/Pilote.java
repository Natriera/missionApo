
public class Pilote extends Composant {
	
	
	int prix;
	int poids; 
	int vitesse; 
	int stabilite;
	String nom;  
	
	public Pilote(String nom, int prix, int poids, int stabilite) {
		super(nom, prix, poids);
        
        this.poids = poids;
        this.prix = prix;
        this.stabilite = stabilite;
        this.nom = nom;
	}
	
	public String apercu(){
	
		
		String apercu = "Composant : " + nom + "\n" ; 
		apercu = apercu + "Poids =" + poids + "\n" ;
		apercu = apercu + "Prix =" + prix + "\n";
		apercu = apercu + "Stabilite =" + stabilite;
		
		return apercu;
		
	}
}

