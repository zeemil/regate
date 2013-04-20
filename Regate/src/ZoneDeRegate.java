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
    private static final int LONGUEUR = 1000; 	// en m�tres
    private static final int LARGEUR = 500; 	// en m�tres
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
       System.out.println("Regate en cr�ation");
    }
    /**
     * D�fini les param�tre du vent.
     * @param force
     * @param direction
     */
    public void creeVent(int force, int direction){
        vent = new Vent(force, direction);
        System.out.println("Vent cr�� : " + vent +".");
    }
    /**
     * Cr�e un nouveau bateau avec le nom pass� en param�tre si l'�tat de la r�gate le permet
     * @param nom
     */
    public void nouveauBateau(String nom){
    	if(pas == 0){
	        bateaux.add(new Bateau(nom));
	        System.out.println("Bateau cr�� : "+nom+".");
    	}else{
    		System.out.println("Regate en cours, enregistement impossible.");
    	}
    }
    /**
     * Surcharge afin de cr�er un bateau cr�� dans la classe Demo
     * @param bateau
     */
    public void nouveauBateau(Bateau bateau){
    	if(bateau != null){
    		bateaux.add(bateau);
        	System.out.println("Bateau cr�� : "+ bateau);
    	}else{
    		System.out.println("le bateau n'a pas �t� cr��");
    	}
    }
    /**
     * Cr�e une balise avec sa position et le sens de passage
     * @param pos
     * @param sens
     */
    public void nouvelleBalise(Position pos, char sens){
        balises.put(balises.size()+1, new Balise(balises.size()+1, pos, sens));
        System.out.println("Balise cr��e :"+ balises.get(balises.size()));
    }
    /**
     * Surcharge afin de cr�er une balise dans la classe Demo
     * @param balise
     */
      public void nouvelleBalise(Balise balise){
        balises.put(balise.getNumero(),balise);
        System.out.println("Balise cr��e : "+ balise);
    }
    /**
     * D�part de la course.
     * Tous les bateaux sont pass�s dans l'�tat "En course".
     * La r�gate est dans l'�tat "En course"
     * impossible d'inscrire d'autres bateaux.
     */
    public void depart(){
        System.out.println("R�gate d�marr�e");
        
        pas = 1;
        for(Bateau b : bateaux){
        	b.setEtat("En course");
        	nbBateauxEnCourse++;
        }
         
        System.out.println( nbBateauxEnCourse + " bateaux ont pris le d�part.");
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
    				
    				classement.add(b); // ajout� au classement
    				it.remove(); // retir� de la course
    			}
    		}
    		
    		pas++;
    	}else{
    		fin();
    	}
    }
    /**
     * Termine la simulation, �tabli le classement
     */
    public void fin(){
    	
    	System.out.println("Regate termin�e.");
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
