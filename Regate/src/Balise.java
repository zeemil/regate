
/**
 * Write a description of class Balise here.
 * 
 * @author (Emilien Fritschy & Carol Hubert) 
 * @version (15.04.2013)
 */
public class Balise
{
    private int ordre;
    private Position position;
    private int sensDePassage;
    /**
     * Constructor for objects of class Balise
     */
    public Balise(int ordre, Position position, int sensDePassage)
    {
        this.ordre = ordre;
        this.position = position;
        this.sensDePassage = sensDePassage;
    }
    
    public int getOrdre(){
        return ordre;
    }
    
    public String toString(){
        return "Ordre : " + ordre + " sens : " + sensDePassage;
    }

   
   
}
