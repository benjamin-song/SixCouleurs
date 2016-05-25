
public class joueur {
private String nom;
private int x0;
private int y0;
private int score;


public joueur (String nom, int x0,int y0){
	this.nom=nom;
	this.x0=x0;
	this.y0=y0;
	this.score=1;
}
public int getx0(){
	return this.x0;
}
public int gety0(){
	return this.y0;
}
public String getnom(){
	return this.nom;
}
public int getscore(){
	return this.score;
}
public void setscore(int score){
	this.score=score;
}}
