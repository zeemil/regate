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
    private int rang;

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
        rang = 0;
    }
    
    public void changerCap(int newCap){
        cap = newCap;
    }
    
    public void changerVitesse(float newVitesse){
        vitesse =  newVitesse;
    }
    
    public String getNom(){
        return nom;
    }
    
    public int getCap(){
        return cap;
    }
    
    /**
     * Calcul la nouvelle position à chaque pas de simulation
     */
    public void deplacement(){
    	
    }
    
    public Position getPosition(){
    	return position;
    }
    
    public int getRang(){
    	return rang;
    }
    public String toString(){
        return "Nom : " + nom +", vitesse : "+vitesse+", cap : " + cap + ", état : "+ etat;
    }

    
}
