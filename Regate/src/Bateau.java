import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author Emilien Fritschy & Carol Hubert
 * @version 08.04.2013
 */
public class Bateau 
{
    private String nom; // nom du joueur
    private float vitesse; //en km/h
    private int cap; // en ° (0 = NORD, 90 = EST, ...)
    private Position position;
    private String etat;
    private int nbBalisesOK;
    private Vent vent;
    private int duree; // durée d'un pas de simulation

    /**
     * Constructeur de la classe Bateau
     * @param nom
     */
    public Bateau(String nom)
    {
        this.nom = nom;
        vitesse = 0;
        cap = 0;
        position = new Position(0,250);
        etat = "Inscrit";
        nbBalisesOK = 0;
    }
    
    /**
     * Calcul la nouvelle position à chaque pas de simulation
     */
    public void avancer(){

	// Algorithme de déplacement
		//coordonnées de départ
	 	int xd = position.getX();
	 	int yd = position.getY();
	 	
    	int xa, ya;			// coordonnées d’arrivée	(ce qu’on cherche)
    						//cap	angle (Variable de classe)
    						// vitesse	( variable de classe)
    	float r;			 //déplacement = vitesse * durée	(10 s)
    	
	// vent
    	int direction = vent.getDirection(); //angle
    	int f = vent.getForce(); //		force
    	
    	// si le bateau a un angle de moins de 30° avec le vent
    	// il reste sur place
	    if(	(Math.abs( (cap - direction) ) < 30)){
	    	vitesse = 0;
	    	r = 0;
	    	xa = xd;
	    	ya = yd;
	    }
	    // sinon, il avance à la vitesse du vent.
	    else{
	    	vitesse = f;
	    	r = duree * vitesse;
	    	// nouvelles positions
	    	xa = (int) (r * Math.cos(cap) + xd);
	    	ya = (int) (r * Math.sin(cap) + yd);

	    }
	   
	    position.setXY(xa, ya);
    }
    
    /**
     * Lorsque le bateau passe une balise
     */
    public void passageBalise(){
    	nbBalisesOK++;
    }
    public int getNbBalisesOK(){
    	return nbBalisesOK;
    }
	public void setVent(Vent vent) {
		this.vent = vent;
	}

	public void changerCap(int newCap){
        cap = newCap;
    }
    public void setDuree(int d){
    	this.duree = d;
    }
       
    public String getNom(){
        return nom;
    }
    
    public int getCap(){
        return cap;
    }
       
    
    public Position getPosition(){
    	return position;
    }
    
   
    public String toString(){
        return "Nom : " + nom +", vitesse : "+vitesse+", cap : " + cap + ", état : "+ etat 
        		+ ", pos : " + position.getX() + ", " + position.getY() ;
    }

	public void setEtat(String etat) {
		this.etat = etat;
		
	}
	public String getEtat(){
		return etat;
	}
	public float getVitesse(){
		return vitesse;
	}
    
}
