


public class TestJoueur {
	
	public static void main (String[] args) {
		Joueur j1 = new Joueur("Nathan");
        String[] listComposants= new String[j1.mesMoteurs.size()];
        for (int i =0;i<j1.mesMoteurs.size();i++) {
            listComposants[i]=j1.mesMoteurs.toString();
            System.out.println(listComposants[i]);
        }
	}
}

