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
	private static final int DUREE_PAS = 5; 	// en secondes
    private static final int LONGUEUR = 1000; 	// en mètres
    private static final int LARGEUR = 500; 	// en mètres
    private Vent vent;
    private ArrayList <Bateau> bateaux;
    private HashMap <Integer, Balise> balises;
    private SortedSet<Bateau> classement;
    private int pas; //0 = conception, 1+ en course
    private int nbBateauxEnCourse;
   
    /**
     * Constructeur pour la class ZoneDeRegate
     * @param longueur
     * @param largeur
     */
    public ZoneDeRegate(int longueur, int largeur){
       pas = 0;
       bateaux = new ArrayList<Bateau>();
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
        System.out.println("Vent créé : " + vent +".");
    }
    /**
     * Crée un nouveau bateau avec le nom passé en paramètre si l'état de la régate le permet
     * @param nom
     */
    public void nouveauBateau(String nom){
    	if(pas == 0){
	        bateaux.add(new Bateau(nom));
	        System.out.println("Bateau créé : "+nom+".");
    	}else{
    		System.out.println("Regate en cours, enregistement impossible.");
    	}
    }
    /**
     * Surcharge afin de créer un bateau créé dans la classe Demo
     * @param bateau
     */
    public void nouveauBateau(Bateau bateau){
    	if(bateau != null){
    		bateaux.add(bateau);
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
    /**
     * Départ de la course.
     * Tous les bateaux sont passés dans l'état "En course".
     * La régate est dans l'état "En course"
     * impossible d'inscrire d'autres bateaux.
     */
    public void depart(){
        System.out.println("Régate démarrée");
        
        pas = 1;
        for(Bateau b : bateaux){
        	b.setEtat("En course");
        	nbBateauxEnCourse++;
        }
         
        System.out.println( nbBateauxEnCourse + " bateaux ont pris le départ.");
    }
    /**
     * Fait avancer la simulation d'un pas
     */
    public void pasSuivant(){
    	System.out.println("Pas #" +pas);
    	    	
    	Iterator<Bateau> it = bateaux.iterator();
    	boolean trouve = false;
    	
    	if(pas < NB_PAS_MAX && nbBateauxEnCourse >0 ){
    		
    		while (!trouve && it.hasNext()){
    			Bateau b = it.next();
    			
    			if(b.getEtat().equals("En course")){
    				b.avancer();
    				
    				System.out.println(b);
    				
    			}else if(b.getEtat().equals("Arrive")){
    				System.out.println("le bateau de : " + b.getNom() + "est " + b.getEtat() + "rang :"+ b.getRang());
    				
    				classement.add(b); // ajouté au classement
    				it.remove(); // retiré de la course
    			}
    		}
    		
    		pas++;
    	}else{
    		fin();
    	}
    }
    /**
     * Termine la simulation, établi le classement
     */
    public void fin(){
    	
    	System.out.println("Regate terminée.");
    	System.out.println("Classement : ");
    	
    	for(Bateau b : classement ){
    		System.out.println("Rang : " + b.getRang() + ", " + b.getNom());
    	}
    	
    	System.out.println("---------------------------------");
    	
    	for(Bateau b : bateaux ){
    		System.out.println("Bateau " + b.getNom() + " : " + b.getEtat());
    	}
    }
}
