/**
 * Write a description of class ZoneDeRegate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class ZoneDeRegate
{
    private  int longueur;
    private  int largeur;
    private Vent vent;
    private HashMap <String, Bateau> bateaux;
    private HashMap <Integer, Balise> balises;
    private int etat; //0 = conception, 1 = en course, 2 = terminé
    

    public ZoneDeRegate(int longueur, int largeur){
       this.longueur = longueur;
       this.largeur = largeur;
       etat = 0;
       System.out.println("Regate en création");
    }
    
    public void creeVent(int force, int direction){
        vent = new Vent(force, direction);
        System.out.println("Vent créé : force = "+force+" direction = "+direction+".");
    }

    public void nouveauBateau(String nom){
        bateaux.put(nom, new Bateau(nom));
        System.out.println("Bateau créé : "+bateaux.get(nom)+".");
    }
    // utilisé par la classe Demo
    public void nouveauBateau(Bateau bateau){
        bateaux.put(bateau.getNom(), bateau);
        System.out.println("Bateau créé : "+ bateau);
    }
    
    public void nouvelleBalise(Position pos, int sens){
        balises.put(balises.size()+1, new Balise(balises.size()+1, pos, sens));
        System.out.println("Balise créée :"+ balises.get(balises.size()));
    }
    // utilisé par la classe Demo
      public void nouvelleBalise(Balise balise){
        balises.put(balise.getOrdre(),balise);
        System.out.println("Balise créée : "+ balise);
    }
    
    public void demarrerRegate(){
        etat = 1;
        System.out.println("Régate démarrée");
    }
}
