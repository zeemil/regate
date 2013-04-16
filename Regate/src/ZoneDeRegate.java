/**
 * Write a description of class ZoneDeRegate here.
 * 
 * @author (Emilien Fritschy & Carol Hubert) 
 * @version (a version number or a date)
 */
import java.util.*;
public class ZoneDeRegate
{
	private static final int NB_PAS_MAX = 100;
    private static final int LONGUEUR = 1000;
    private static final int LARGEUR = 500;
    private Vent vent;
    private HashMap <String, Bateau> bateaux;
    private HashMap <Integer, Balise> balises;
  //  private SortedMap <Integer, Bateau> classement;
    private int pas; //0 = conception, 1+ en course
    private int nbBateauxEnCourse;
    
    /**
     * Constructeur pour la class ZoneDeRegate
     * @param longueur
     * @param largeur
     */
    public ZoneDeRegate(int longueur, int largeur){
       pas = 0;
       bateaux = new HashMap <String, Bateau>();
       balises = new  HashMap <Integer, Balise>();
    //   classement = new SortedMap <Integer, Bateau>();
       nbBateauxEnCourse = 0;
       System.out.println("Regate en création");
    }
    /**
     * Défini les paramètre du vent.
     * @param force
     * @param direction
     */
    public void creeVent(int force, int direction){
        vent = new Vent(force, direction);
        System.out.println("Vent créé : force = "+force+" direction = "+direction+".");
    }
    /**
     * Crée un nouveau bateau avec le nom passé en paramètre
     * @param nom
     */
    public void nouveauBateau(String nom){ 
        bateaux.put(nom, new Bateau(nom));
        System.out.println("Bateau créé : "+bateaux.get(nom)+".");
    }
    /**
     * Surcharge afin de créer un bateau créé dans la classe Demo
     * @param bateau
     */
    public void nouveauBateau(Bateau bateau){
    	if(bateau != null){
    		bateaux.put(bateau.getNom(), bateau);
        	System.out.println("Bateau créé : "+ bateau);
    	}else{
    		System.out.println("le bateau n'a pas été créé");
    	}
    }
    /**
     * Crée une balise avec sa position et le sens de passage
     * @param pos
     * @param sens
     */
    public void nouvelleBalise(Position pos, char sens){
        balises.put(balises.size()+1, new Balise(balises.size()+1, pos, sens));
        System.out.println("Balise créée :"+ balises.get(balises.size()));
    }
    /**
     * Surcharge afin de créer une balise dans la classe Demo
     * @param balise
     */
      public void nouvelleBalise(Balise balise){
        balises.put(balise.getNumero(),balise);
        System.out.println("Balise créée : "+ balise);
    }
    
    public void depart(){
        System.out.println("Régate démarrée");
    }
    /**
     * Fait avancer la simulation d'un pas
     */
    public void pasSuivant(){
    	
    }
    /**
     * Termine la simulation, établi le classement
     */
    public void fin(){
    	
    }
}
