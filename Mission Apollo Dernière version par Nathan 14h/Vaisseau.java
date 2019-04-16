import java.awt.Image;

public class Vaisseau {
	
	int poids; 
	int vitesse;
	int stabilite;
	double consomation; 
	int boost;
	int essence;
	int xFond = 600 ;
	int yFond = -7000; 
	double vitesseDeplacement = 0;
	double facteur = 0; //pour gérer l'accélération
	double facteur1 =0;
	boolean hypervitesse=false;
	long tempsDebut =0;
	long tempsFin = 0;
	boolean crash;
	float altitude = 0;
	boolean passageCouche = false;
	boolean ariveeCouche = false;
	boolean coeffCalcule = false;
    boolean checklist = false; 
	double proba;
	// int ycrash =0 faire que la fusée s'arrête après avoir tourné 
	
	
	Pilote pilote;
	Corps corps;


	Etage etage1;
	Etage etage2;
	Etage etage3;
	Etage etage4;
	
	//variables nécéssaires à l'affichage du vaisseau et à son déplacement

	
	int distanceParcourue;
	int essenceDebut;

	
	
	public Vaisseau(Etage etage1 , Etage etage2 , Etage etage3, Etage etage4 , Pilote pilote , Corps corps ){
	
	
	
	// les attributs du vaisseau sont définis par les attributs des etages + corps et pilote
	this.essence=etage1.volume + etage2.volume + etage3.volume + etage4.volume;
	this.poids=etage1.poids + etage2.poids + etage3.poids + etage4.poids+corps.poids;
	this.vitesse=etage1.vitesse+etage2.vitesse+etage3.vitesse+etage4.vitesse+corps.vitesse;
	this.stabilite=etage1.stabilite+etage2.stabilite+etage3.stabilite+etage4.stabilite+pilote.stabilite+corps.stabilite;
	this.consomation=etage1.consomation+etage2.consomation+etage3.consomation+etage4.consomation;
	this.essence=etage1.volume + etage2.volume + etage3.volume + etage4.volume;
    this.etage1=etage1;//ajouté
    this.etage2=etage2;//ajouté
    this.etage3=etage3;//ajouté
    this.etage4=etage4;//ajouté
    this.pilote = pilote;//ajouté
    this.corps = corps;//ajouté
	
	//distance parcourue initialisée à zéro
	distanceParcourue=0; 
	
	//essence initialisé à la taille du réservoir
	essenceDebut=essence; // pour pouvoir déssiner avec l'essence qu'il reste et celui qui a été consommé
	
	// trucs que lucas a rajouté
	

	
	}
	
	
	
	
	
	 

	public void vol(long temps , int couche){ 				// le but de cette méthode est que dans l'action performed de la fenetre on ai juste à dire Vaisseau.vol() et que ça ressorte à chaque instant les coordonnées du fond(à quel point il est scroll) pour pouvoir faire un print avec ses valeurs 
												//Je pars du postulat que c'est le fond qui bouge (les nuages sont donc importants pout se rendre compte de l'avancement); //pourcentage de la vitesse à laquelle il va aller 
						// sert à voir si la constion pour qu'elle décolle est respectée (on peut la faire devenir un tableau si on veut rajuter des fonctionalités)
		//this.crash = false; 							//sert à dire si la fusee est toujours en vol
		int distanceDeja =0;
        
		//checklist = false; 
										
		if (this.poids*10<this.vitesse*20000)
			checklist=true;
        checklist=true;
        System.out.println("checklist :"+checklist);
		if (checklist==true){
			
			if (this.essence>0){
				
				if (this.vitesseDeplacement<this.vitesse){ //décollage progressif 
					
					this.vitesseDeplacement= this.vitesse*facteur;
					facteur= facteur+0.1;
					this.altitude += facteur* 0.4;
					//System.out.println(this.vitesseDeplacement);
				}
				
				//System.out.println(this.vitesseDeplacement);
				
				if (crash == false){
				
					//System.out.println(yFond);
					
					if (yFond<0) {
						tempsDebut = temps;
						int conso = (int)(this.vitesse*this.consomation*this.poids/10);
						
						if ((hypervitesse ==true) && (tempsFin-tempsDebut>0)){ //Permet de booster pendant un temps donné
							this.yFond+=300;
							this.essence = this.essence/2;
						}
							
						else{
							if ((this.yFond < -5000)&&(this.yFond > -6000)){
								if (!coeffCalcule){
									proba = this.stabilite/(Math.random()*100);
									coeffCalcule = true;
								}
								//System.out.println(proba);
								this.ariveeCouche = true;
								this.altitude += 0.125;
								
								//System.out.println(conso);
								this.essence = this.essence-conso; 
								if (this.crash ==false) this.yFond+=(int)(vitesseDeplacement*0.05*0.21);

								if ( proba>1){
									this.passageCouche = true;

									}
								if ( proba<1){
									this.passageCouche = false;
									//this.crash= true;

									}	
									
								}
							else{
								this.yFond+=(int)(vitesseDeplacement*0.05*0.21); // accélération normale
								this.essence =  this.essence-conso;
								//System.out.println(conso);
								if (this.essence<0) this.essence=0;
								this.altitude += 0.125;
								
							}
							
						
						}
					
					}
				}
			}
			if (this.essence<0) this.essence=0;
			if (this.essence==0){
				this.vitesseDeplacement= this.vitesse*facteur;
				facteur1= facteur1+0.1;
				this.yFond -= (int)(vitesseDeplacement*0.05*0.21);
				//System.out.println(this.vitesseDeplacement);
				
			}
			if (this.essence==0) {this.crash=true;}
			

	}
	}
    
    public void updateVaisseau() { //ajouté
        this.essence=etage1.volume + etage2.volume + etage3.volume + etage4.volume;
        this.poids=etage1.poids + etage2.poids + etage3.poids + etage4.poids+corps.poids+pilote.poids;
        this.vitesse=etage1.vitesse+etage2.vitesse+etage3.vitesse+etage4.vitesse+corps.vitesse;
        this.stabilite=etage1.stabilite+etage2.stabilite+etage3.stabilite+etage4.stabilite+pilote.stabilite+corps.stabilite;
        this.consomation=etage1.consomation+etage2.consomation+etage3.consomation+etage4.consomation;
        this.essence=etage1.volume + etage2.volume + etage3.volume + etage4.volume;
        
        
    }
	public void remiseAzero(){
			this.essence = essenceDebut;
			this.yFond = -7000;
			this.xFond = 600;
			this.facteur =0;
			this.facteur1=0;
			this.vitesseDeplacement =0;
			this.altitude =0;
			this.crash = false;
            hypervitesse=false;
			tempsDebut =0;
            tempsFin = 0;

            passageCouche = false;
            ariveeCouche = false;
            coeffCalcule = false;
		}
	
	public String affichage(){
		String text = "poids: " + poids + "\n" ; 
		text = text +"vitesse: " + vitesse+ "\n";
		text = text + "stabilite :" +stabilite+ "\n";
		text = text + "consomation :" + consomation+ "\n"; 
		text = text +"essence: " +essence ;
		
		return text;
	}

}

