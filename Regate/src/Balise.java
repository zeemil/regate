
/**
 * Write a description of class Balise here.
 * 
 * @author (Emilien Fritschy & Carol Hubert) 
 * @version (15.04.2013)
 */
public class Balise
{
    private int numero;
    private Position position;
    private char sensDePassage;
    /**
     * Constructor for objects of class Balise
     */
    public Balise(int ordre, Position position, char sensDePassage)
    {
        this.numero = ordre;
        this.position = position;
        this.sensDePassage = sensDePassage;
    }
    
    public int getNumero() {
		return numero;
	}

	public Position getPosition() {
		return position;
	}

	public char getSensDePassage() {
		return sensDePassage;
	}

	public String toString(){
        return "Numero : " + numero + " sens : " + sensDePassage;
    }

   
   
}
