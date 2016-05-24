
public class bouton {
	private couleur c;

	public bouton(couleur c){
		this.c=c;
	}
	
	public void afficherBouton(double x, double y){
		c.defCouleur();
		StdDraw.filledCircle(x, y, 1);
	}
}
