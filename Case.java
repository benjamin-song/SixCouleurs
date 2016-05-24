
public class Case {
private double x;
private double y;
private couleur c;
private joueur j;
public Case(double x,double y,couleur c){
	this.x=x;
	this.y=y;
	this.c=c;
	j=null;
}
public void affCase(){
	c.defCouleur();
	StdDraw.filledSquare(x, y, 0.5);
}
public void setj(joueur j){
	this.j=j;
}
public void setcolor(couleur c){
	this.c=c;
}
public joueur getjcase(){
	return this.j;
}
public couleur getcasecolor(){
	return this.c;
}
}
