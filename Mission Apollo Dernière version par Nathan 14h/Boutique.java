import java.util.LinkedList;

 
public class Boutique {
	
        // création des corps disponibles dans la boutique
		Corps corps1 = new Corps("Ariane 5", 5000000, 500000, 10);
		Corps corps2 = new Corps("Soyuz", 1000000, 550000, 12); 
		Corps corps3 = new Corps("Saturn V", 4000000, 530000, 14);
		Corps corps4 = new Corps("Falcon Heavy", 7000000, 550000, 16);
		
        //création des pilotes disponibles dans la boutique
		Pilote pilote1 = new Pilote(" Thomas Pesquet", 0, 75, 10);
		Pilote pilote2 = new Pilote(" Chris Hadfield", 50000, 80, 15);
		Pilote pilote3 = new Pilote(" Alan Shepard", 750000, 70, 20);
		Pilote pilote4 = new Pilote(" Yuri Gagarin", 900000, 70, 25);
		Pilote pilote5 = new Pilote(" Neil Amstrong", 1500000, 65, 30);
	
	
        //création des moteurs disponibles dans la boutique
		Moteur moteurNull = new Moteur("moteur de base",500000,2000,0,0.00003);
		Moteur moteur2 = new Moteur("F-1 (Saturn V)", 750000, 2700, 100,0.00002);
		Moteur moteur3 = new Moteur("RD-107 (Soyouz) ", 1000000, 2600, 150,0.00001); 
		Moteur moteur4 = new Moteur("Vulcain (Ariane 5)", 1250000, 2400, 100,0.0000080); 
		Moteur moteur5 = new Moteur("Merlin (Falcon heavy)", 1500000, 2100, 250,0.0000060); 
		
        // création des réservoirs disponibles dans la boutique
		Reservoir reservoirNull = new Reservoir("reservoir de base", 0,0,0);
		Reservoir reservoir1 = new Reservoir("reservoir de niveau 1", 600000, 180000, 600000);
		Reservoir reservoir2 = new Reservoir("reservoir de niveau 2", 700000, 193000, 700000); 
		Reservoir reservoir3 = new Reservoir("reservoir de niveau 3", 800000, 185000, 800000); 
		Reservoir reservoir4 = new Reservoir("reservoir de niveau 4", 900000, 175000, 900000); 
		Reservoir reservoir5 = new Reservoir("reservoir de niveau 5", 1000000, 170000, 1000000); 
		
        // création des ailes disponibles dans la boutique
		Aile aileNull = new Aile("aile0", 0,0,0);
		Aile aile1 = new Aile("aile de niveau 1", 750000, 2400,10);
		Aile aile2 = new Aile("aile de niveau 2", 850000, 2500, 20);
		Aile aile3 = new Aile("ailen de niveau 3", 950000, 2450, 30);
		Aile aile4 = new Aile("aile de niveau 4", 1500000, 2300, 40);
		Aile aile5 = new Aile("aile de niveau 5", 2000000, 2200, 50);
		
        // création des réacteur disponibles dans la boutique
		Reacteur reacteurNull = new Reacteur("reacteur0", 0, 0, 0);
		Reacteur reacteur1 = new Reacteur("reacteur de niveau 1", 100000, 11000, 120);
		Reacteur reacteur2 = new Reacteur("reacteur de niveau 2", 500000, 12000, 140);
		Reacteur reacteur3 = new Reacteur("reacteur de niveau 3", 1000000, 13000, 160);
		Reacteur reacteur4 = new Reacteur("reacteur de niveau 4", 2000000, 10000, 180);
		Reacteur reacteur5 = new Reacteur("reacteur de niveau 5", 3000000, 9000, 200);
		
        //création des étages disponibles dans la boutique
		Etage etage1 = new Etage("etage 1", 0, 100, moteur2 , aileNull, reservoir1, reacteurNull);
		Etage etage2 = new Etage("etage 2", 0, 100, moteurNull , aileNull, reservoir1, reacteurNull);
		Etage etage3 = new Etage("etage 3", 0, 100, moteurNull , aileNull, reservoir1, reacteurNull);
		Etage etage4 = new Etage("etage 4", 0, 100, moteurNull , aileNull, reservoir1, reacteurNull);

	
	// création d'une liste des composants disponibles dans la boutique pour chaque type de composant
	LinkedList<Composant> listeComposants=new LinkedList<Composant>();
    LinkedList<Composant> listeCorps=new LinkedList<Composant>();
    LinkedList<Composant> listePilote=new LinkedList<Composant>();
    LinkedList<Composant> listeMoteur=new LinkedList<Composant>();
    LinkedList<Composant> listeReservoir=new LinkedList<Composant>();
    LinkedList<Composant> listeAile=new LinkedList<Composant>();
    LinkedList<Composant> listeReacteur=new LinkedList<Composant>();
 
    
	public Boutique() {
        
        // liste de tous les Corps
        listeCorps.add(corps1);
		listeCorps.add(corps2);
		listeCorps.add(corps3);
		listeCorps.add(corps4);
		
        //liste de tous les pilotes
		listePilote.add(pilote1);
		listePilote.add(pilote2);
		listePilote.add(pilote3);
		listePilote.add(pilote4);		
		listePilote.add(pilote5);
        
        //liste de tous les moteurs
        listeMoteur.add(moteurNull);
		//listeMoteur.add(moteur1);
		listeMoteur.add(moteur2);
		listeMoteur.add(moteur3);
		listeMoteur.add(moteur4);
		listeMoteur.add(moteur5);
		
        //liste de tous les reservoirs
        listeReservoir.add(reservoirNull);
		listeReservoir.add(reservoir1);
		listeReservoir.add(reservoir2);
		listeReservoir.add(reservoir3);
		listeReservoir.add(reservoir4);
		listeReservoir.add(reservoir5);
		
        //liste de toutes les ailes
        listeAile.add(aileNull);
		listeAile.add(aile1);
		listeAile.add(aile2);
		listeAile.add(aile3);
		listeAile.add(aile4);
		listeAile.add(aile5);
		
        //liste de tous les réacteurs
        listeReacteur.add(reacteurNull);
		listeReacteur.add(reacteur1);
		listeReacteur.add(reacteur2);
		listeReacteur.add(reacteur3);
		listeReacteur.add(reacteur4);
		listeReacteur.add(reacteur5);
    
		System.out.println("Création de la boutique");
		
	}
	

     
    // permet d'afficher tous les composants dans la liste
    public String toString(){
		String liste = "COMPOSANTS :" + "\n" ;
        for(int k=0; k< listeComposants.size(); k++){
			liste = liste + listeComposants.get(k).toString();
		}
		
		
		return liste;
    }
    
	
	public Composant listeComposantsget(int n){
		listeComposants.get(n).toString();
		return this.listeComposants.get(n);
	}


	
}

