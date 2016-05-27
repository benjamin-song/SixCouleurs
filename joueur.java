
public class joueur {
private String nom;
private int x0;
private int y0;
private int score;
private boolean ia;


public joueur (String nom, int x0,int y0,boolean ia){
	this.nom=nom;
	this.x0=x0;
	this.y0=y0;
	this.score=1;
	this.ia=ia;
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
public boolean getia(){
	return this.ia;
}
public void setscore(int score){
	this.score=score;
}}
