/**
 * Write a description of class ZoneDeRegate here.
 * 
 * @author (Emilien Fritschy & Carol Hubert) 
 * @version (a version number or a date)
 */
import java.util.*;
public class ZoneDeRegate
{
	private static final int NB_PAS_MAX = 5;
	private static final int DUREE_PAS = 10; 	// en secondes
    private static final int LONGUEUR = 1000; 	// en mètres
    private static final int LARGEUR = 500; 	// en mètres
    private Vent vent;
    private ArrayList <Bateau> bateaux;
    private ArrayList <Balise> balises;
    private HashSet <Bateau> classement;
    private int pas; //0 = conception, 1+ en course
  
   
    /**
     * Constructeur pour la class ZoneDeRegate
     * @param longueur
     * @param largeur
     */
    public ZoneDeRegate(int longueur, int largeur){
       pas = 0;
       bateaux = new ArrayList<Bateau>();
       balises = new  ArrayList <Balise>();
       classement = new HashSet<Bateau>();
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
    		Bateau b = new Bateau(nom);
    		b.setVent(vent);
    		b.setDuree(DUREE_PAS);
	        bateaux.add(b);
	        
	        System.out.println("Bateau créé : " + b);
    	}else{
    		System.out.println("Regate en cours, enregistrement impossible.");
    	}
    }
    /**
     * Surcharge afin de créer un bateau créé dans la classe Demo
     * @param bateau
     */
    public void nouveauBateau(Bateau bateau){
    	if(bateau != null && pas == 0){
    		bateau.setVent(vent);
    		bateau.setDuree(DUREE_PAS);
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
    	Balise balise = new Balise(balises.size()+1, pos, sens);
        balises.add(balise);
        System.out.println("Balise créée :"+ balise);
    }
    /**
     * Surcharge afin de créer une balise dans la classe Demo
     * @param balise
     */
      public void nouvelleBalise(Balise balise){
        balises.add(balise);
        System.out.println("Balise créée : "+ balise);
    }
    /**
     * Départ de la course.
     * Tous les bateaux sont passés dans l'état "En course".
     * La régate est dans l'état "En course"
     * impossible d'inscrire d'autres bateaux.
     */
    public void depart(){
    	if(bateaux.size() > 0){
    		
	        pas = 1;
	        for(Bateau b : bateaux){
	        	b.setEtat("En course");
	        }
	        System.out.println("Régate démarrée");
	        System.out.println( bateaux.size() + " bateaux ont pris le départ.");
	    
    	}else{
    		 System.out.println("Impossible de démarrer la régate : aucun bateau enregistré.");
    	}
         
        
    }
    /**
     * Fait avancer la simulation d'un pas
     */
    public void pasSuivant(){
    	// passage au pas suivant seulement si la cours n'est pas terminée   	
    	if(pas <= NB_PAS_MAX && bateaux.size() > 0 ){
    		
    		System.out.println("\nPas #" +pas);
    		
         	
    		for (Bateau b : bateaux){
    		
    			if(b.getEtat().equals("En course")){
    				b.avancer();
    				verifPosition(b);
    				System.out.println(b);
    				
    			}else if(b.getEtat().equals("Arrive")){
    				// on ne fait plus rien si le bateau est arrivé.
    				
    			}else if(b.getEtat().equals("Elimine")){
    				System.out.println("Le bateau de "+b.getNom() + " est éléminé.");
    			}	
    		} 	
    		
    		pas++;
    		
    	}else{
    		fin();
    	}
    }
    /**
     * Vérification de la nouvelle position d'un bateau
     * @param bateau
     */
    private void verifPosition(Bateau bateau) {
    	int xa = bateau.getPosition().getX();
    	int ya = bateau.getPosition().getY();
    	
    	// vérifications des positions
	    // si elles rentrent dans le cadre
	    if(xa >= 0 && ya >= 0 && xa <= LONGUEUR && ya <= LARGEUR){
	    	//si elles sont correctes,
	    	// vérifier si on dépasse une balise (plusieurs balises peuvent être dépassées en même temps)
	    	for(Balise balise : balises){
	    		// si on a pas déjà passé cette balise et qu'on est pas éléminé.
	    		if((bateau.getNbBalisesOK() < balise.getNumero()) && bateau.getEtat() != "Elimine"){
	    			// on vérifie si on l'a dépassée
	    			if(xa > balise.getPosition().getX()){
	    				// et on vérifie encore que ce soit dans le bon sens
	    				if((balise.getSensDePassage() == '+' && ya > balise.getPosition().getY()) ||
	    						(balise.getSensDePassage() == '-' && ya < balise.getPosition().getY())){
	    					bateau.passageBalise();
	    					// et pour finir, si c'était la balise finale;
	    					if(balise.getNumero() == balises.size() || balise.getNumero() == balises.size()-1){
	    						bateau.setEtat("Arrive");
	    	    				classement.add(bateau); // ajouté au classement
	    	    				//bateaux.remove(bateau); // retiré de la course
	    	    				
	    	    				System.out.println("Le bateau de : " + bateau.getNom() + " est " + bateau.getEtat() 
	    								+ " rang :"+ classement.size());
	    					}
	    					
	    					System.out.println( bateau.getNom() +" : Balise #"+ balise.getNumero()+" passée.");
	    				}else{
	    					// la balise est passée dans le mauvais sens --> éliminé
	    					bateau.setEtat("Elimine");
	    					
	    					System.out.println( "Le bateau de "+bateau.getNom() +" est éliminé : balise #"+balise.getNumero()+" passée dans le mauvais sens.");
	    							
	    				}
	    			}
	    		}
	    		
	    	}
	    	
	    }else{
	    	bateau.setEtat("Elimine");
	    	System.out.println("Le bateau de " + bateau.getNom() +" est éliminé : depassement du cadre."); // sinon, il faut voire ce que l'on fait (on reste sur place pour l'instant
	    }
	}
	/**
     * Termine la simulation, établi le classement
     */
    public void fin(){
    	
    	System.out.println("\nRegate terminée.");
    	System.out.println("---------------------------------");
    	System.out.println("Classement arrivées : ");
    	
   	if(!classement.isEmpty()){
   			int rang=1;
	    	for(Bateau b : classement ){
	    		System.out.println("Rang " + rang + " : " + b.getNom());
	    		rang++;
	    	}
    	}
    	else {
    		System.out.println("Aucun bateau n'a passé la ligne d'arrivée en "+ NB_PAS_MAX + " pas");
    	}
	    	
    	System.out.println("---------------------------------");
    	System.out.println("Les autres : ");
    	for(Bateau b : bateaux ){
    		if(!b.getEtat().equals("Arrive"))
    			System.out.println("Bateau " + b.getNom() + " : " + b.getEtat());
    	}
    }
}
