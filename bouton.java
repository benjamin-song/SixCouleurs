
public class bouton {
	private couleur c;

	public bouton(couleur c){
		this.c=c;
	}
	
	public void afficherBouton(double x, double y){
		if(this.c.getjcolor()==null){
		c.defCouleur();}
		else{StdDraw.setPenColor(StdDraw.BLACK);}
		StdDraw.filledCircle(x, y, 1);
	}
}
