/**
 * @author Carol et Emilien
 * @version 08.04.2013
 */
public class Bateau
{
    String nom; // nom du joueur
    float vitesse; //en km/h
    int cap; // en ° (0 = NORD, 90 = EST, ...)
    Position position;

    /**
     * Constructor for objects of class Bateau
     */
    public Bateau(String nom)
    {
        this.nom = nom;
        vitesse = 0;
        cap = 0;
        position = new Position(0,250);
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
    
    public String toString(){
        return "Nom : " + nom +", vitesse : "+vitesse+", cap : " + cap;
    }

    
}
