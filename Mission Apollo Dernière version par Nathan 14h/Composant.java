
public abstract class  Composant {
    
	public int poids;
	public int prix;
	String nom; 
	boolean deverouille;
	
	Boutique boutique;
	
	public Composant(String nom, int prix, int poids) {
    this.nom = nom;
    this.poids=poids;
    this.prix=prix;
    deverouille = false; 
    
    }
	
    public String toString(){
            String desc = nom ;
            return desc;
        
        	
	}
	
	public void deverouiller(){
		this.deverouille=true;
		
	}
	
	public  String apercu(){
		String apercu = " ? ";
		return apercu;
	}
		
		
		
	
}
