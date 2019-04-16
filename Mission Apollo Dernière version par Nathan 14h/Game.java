

public class Game {
	
	public static void main (String[] args) {
    
    Joueur j1 = new Joueur("Carole");
    LaunchWindows Lancement = new LaunchWindows(j1);
    BuildWindows Construction = new BuildWindows(j1);
    InterfaceBoutique iBoutique = new InterfaceBoutique(j1);
    MenuWindows Menu = new MenuWindows(Lancement,Construction,iBoutique);
     
    

    
	}
}


