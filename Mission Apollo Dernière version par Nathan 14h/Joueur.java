import java.util.LinkedList;

public class Joueur {
	
    String nom;
    int argent;
    
    
    Boutique boutique = new Boutique();
    
    Vaisseau monVaisseau;
    
    Vaisseau vaisseauBase = new Vaisseau(boutique.etage1, boutique.etage2, boutique.etage3, boutique.etage4, boutique.pilote1, boutique.corps1);
    
    LinkedList<Moteur> mesMoteurs = new LinkedList<Moteur>();
    LinkedList<Reservoir> mesReservoirs = new LinkedList<Reservoir>();
    LinkedList<Aile> mesAiles = new LinkedList<Aile>();
    LinkedList<Pilote> mesPilotes = new LinkedList<Pilote>();
    LinkedList<Reacteur> mesReacteurs = new LinkedList<Reacteur>();
    LinkedList<Corps> mesCorps = new LinkedList<Corps>();
    
   
    
    
	
	public Joueur(String nom) {
		this.nom=nom;
        monVaisseau = vaisseauBase;
        argent = 1000000000;
        
        this.mesMoteurs.add((Moteur)boutique.listeMoteur.get(0));
        this.mesReservoirs.add((Reservoir)boutique.listeReservoir.get(1));
        this.mesAiles.add((Aile)boutique.listeAile.get(0));
        this.mesPilotes.add((Pilote)boutique.listePilote.get(1));
        this.mesReacteurs.add((Reacteur)boutique.listeReacteur.get(0));
        this.mesCorps.add((Corps)boutique.listeCorps.get(1));
        
		
	}
    
    public void acheterComposant(Composant c){
		
		if(c instanceof Moteur){
			mesMoteurs.add((Moteur)c);		
		}
		
		if(c instanceof Reservoir){
			mesReservoirs.add((Reservoir)c);				
		}
		
		if(c instanceof Aile){
			mesAiles.add((Aile)c);				
		}
		
		if(c instanceof Pilote){
			mesPilotes.add((Pilote)c);				
		}
		if(c instanceof Corps){
			mesCorps.add((Corps)c);				
		}
		if(c instanceof Reacteur){
			mesReacteurs.add((Reacteur)c);				
		}
		
        this.argent = this.argent-c.prix;
                
    }
    
    
    
    public String toString(){

        String thune = "il me reste " + Integer.toString(this.argent) + " euros";
        return  thune; 
    }
    
    
        public void addComposant( Composant c, int numEtage){
		
		if(c instanceof Pilote){
			this.monVaisseau.pilote=(Pilote) c;
		}
		
		if(c instanceof Corps){
			this.monVaisseau.corps=(Corps) c;
			
		}
		
		switch (numEtage){
			case 1:
				if(c instanceof Reservoir){
					this.monVaisseau.etage1.reservoir=(Reservoir)c;
				}
				if(c instanceof Aile){
					this.monVaisseau.etage1.aile=(Aile)c;;				
				}
				if(c instanceof Reacteur){
					this.monVaisseau.etage1.reacteur=(Reacteur)c;
				}
				break;
				
			case 2:
				if(c instanceof Reservoir){
					this.monVaisseau.etage2.reservoir=(Reservoir)c;
				}
				if(c instanceof Aile){
					this.monVaisseau.etage2.aile=(Aile)c;;				
				}
				if(c instanceof Reacteur){
					this.monVaisseau.etage2.reacteur=(Reacteur)c;
				}
				break; 	 
				
			case 3:
				if(c instanceof Reservoir){
					this.monVaisseau.etage3.reservoir=(Reservoir)c;
				}
				if(c instanceof Aile){
					this.monVaisseau.etage3.aile=(Aile)c;;				
				}
				if(c instanceof Reacteur){
					this.monVaisseau.etage3.reacteur=(Reacteur)c;
				}
				break; 
			
			case 4:
				if(c instanceof Reservoir){
					this.monVaisseau.etage4.reservoir=(Reservoir)c;
				}
				if(c instanceof Aile){
					this.monVaisseau.etage4.aile=(Aile)c;;				
				}
				if(c instanceof Reacteur){
					this.monVaisseau.etage4.reacteur=(Reacteur)c;
				}
				break; 
		}
	}
	
	
	public void addMoteur( Moteur m, int numEtage){
		
		switch (numEtage){
			case 1:
				
					this.monVaisseau.etage1.moteur1=(Moteur)m;	
				
					this.monVaisseau.etage1.moteur2=(Moteur)m;
				
				
				break;
				
			case 2:
				
					this.monVaisseau.etage2.moteur1=(Moteur)m;	
				
				
					this.monVaisseau.etage2.moteur2=(Moteur)m;
				
				break; 	 
				
			case 3:
				
					this.monVaisseau.etage3.moteur1=(Moteur)m;	
				
					this.monVaisseau.etage3.moteur2=(Moteur)m;
				
				break; 
			
			case 4:
				
					this.monVaisseau.etage4.moteur1=(Moteur)m;	
				
				
					this.monVaisseau.etage4.moteur2=(Moteur)m;
				
				break;
		}
		
	}

    
    
    
}

