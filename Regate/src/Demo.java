
/**
 * Classe de d�monstration pour faire fonctionner la r�gate.
 * - Cr�ation du parcours puis avancement de la simulation.
 * 
 * @author (Emilien Fritschy & Carol Hubert) 
 * @version (a version number or a date)
 */
public class Demo
{
	public static void main(String[] args) {
		new Demo();
	}
    private ZoneDeRegate r;
    private Bateau emilien;
    private Bateau carol;
    private Balise b1,b2,b3,b4,b5,b6,b7;

    /**
     * Constructor for objects of class Demo
     */
    public Demo()
    {
        r = new ZoneDeRegate(1000,500);
        r.creeVent(30, 300);
        
        emilien = new Bateau("Emilien");
        carol = new Bateau ("Carol");
        r.nouveauBateau(emilien);
        r.nouveauBateau(carol);
        
        // balises Start
        b1= new Balise(1, new Position(10, 150), '+'); // par le sud
        b2= new Balise(2, new Position(10, 350), '-'); // par le nord
        // balises de parcours
        b3= new Balise(3, new Position(180, 300), '+'); // par le sud
        b4= new Balise(4, new Position(420, 180), '-'); // par le nord
        b5= new Balise(5, new Position(700, 280), '+'); // par le sud
        // baslises de fin
        b6= new Balise(6, new Position(990, 150), '+'); // par le sud
        b7= new Balise(7, new Position(990, 350), '-'); // par le nord
        
        r.nouvelleBalise(b1);
        r.nouvelleBalise(b2);
        r.nouvelleBalise(b3);
        r.nouvelleBalise(b4);
        r.nouvelleBalise(b5);
        r.nouvelleBalise(b6);
        r.nouvelleBalise(b7);
        
        r.depart();
        
        emilien.changerCap(0);
        carol.changerCap(20);
        
    }

    
}

