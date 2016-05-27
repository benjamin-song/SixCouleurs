
public class couleur {
private int id;
private joueur j;

public couleur(int id){
	this.id=id;
	this.j=null;
}

public void defCouleur(){
	if (this.id==1){
		StdDraw.setPenColor(StdDraw.RED);
	}
	if (this.id==2){
		StdDraw.setPenColor(StdDraw.ORANGE);
	}
	if (this.id==3){
		StdDraw.setPenColor(StdDraw.YELLOW);
	}
	if (this.id==4){
		StdDraw.setPenColor(StdDraw.GREEN);
	}
	if (this.id==5){
		StdDraw.setPenColor(StdDraw.BLUE);
	}
	if (this.id==6){
		StdDraw.setPenColor(StdDraw.CYAN);
	}
}
public joueur getjcolor(){
	return this.j;
}
public void setjcolor(joueur j){
	this.j=j;
}
public int getid(){
 return this.id;
}
}
