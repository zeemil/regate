
/**
 * Write a description of class Position here.
 * 
 * @author (Emilien Fritschy & Carol Hubert) 
 * @version (a version number or a date)
 */
public class Position
{
    // position :
    // X = axe horizontal Max 1000;
    // Y = axe vertical Max 500;
    // Origine en haut à gauche.
    private int x;
    private int y;

    /**
     * Constructeur pour la classe Position
     * @param x
     * @param y
     */
    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    /**
     * Change la position
     * @param x
     * @param y
     */
    public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}


	
  
}
