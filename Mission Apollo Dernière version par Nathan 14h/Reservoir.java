
public class Reservoir extends Composant{
 
	
	int prix;
	int poids; 
	String nom;
	int volume;
	
 
		public Reservoir(String nom, int prix, int poids, int volume){
			
			super(nom, prix, poids);
			this.volume=volume;
            this.poids = poids;
            this.prix = prix;
            this.nom = nom;
			}
		
	public String apercu(){
		
		String apercu = "Composant : " + nom + "\n" ; 
		apercu = apercu + "Poids =" + poids + "\n" ;
		apercu = apercu + "Prix =" + prix + "\n";
		apercu = apercu + "Volume = " + volume;
		return apercu;
		
	}
}

