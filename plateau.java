
public class plateau {
private Case[][] p;
private int l;
private  couleur rouge=new couleur(1);
private  couleur orange=new couleur(2);
private  couleur jaune=new couleur(3);
private  couleur vert=new couleur(4);
private  couleur bleu=new couleur(5);
private  couleur cyan=new couleur(6);
private bouton Brouge=new bouton(rouge);
private bouton Borange=new bouton(orange);
private bouton Bjaune=new bouton(jaune);
private bouton Bvert=new bouton(vert);
private bouton Bbleu=new bouton(bleu);
private bouton Bcyan=new bouton(cyan);

public plateau(int l){
	this.l=l;
	this.p=new Case[l][l];
}
public couleur random(){
	int r=(int)(6*(Math.random()));
	couleur c=this .rouge;
	switch(r){
	case 0:
	c=this.rouge;
	break;
	case 1:
		c=this.orange;
		break;
	case 2:
		c=this.jaune;
		break;
	case 3:
		c=this.vert;
		break;
	case 4:
		c=this.bleu;
		break;
	case 5:
		c=this.cyan;
		break;
	case 6:
		c=this.cyan;
		break;
	}
	return(c);
		
}

public void defplateau(){
	for(int i=0;i<l;i++){
		for(int j=0;j<l;j++){
			couleur c=random();
			p[i][j]=new Case(i,j,c);
	}
}
}

public void affplateau(joueur[] jou){
	StdDraw.setCanvasSize(800,600);
	StdDraw.setXscale(-0.5,this.l+3.5);
	StdDraw.setYscale(-2.5,this.l-0.5);
	for(int i=0;i<l;i++){
		for(int j=0;j<l;j++){
			p[i][j].affCase();
		}
	}
	if(jou!=null){
	for(int t=0;t<jou.length;++t){
		if(jou[t]!=null){
			this.p[jou[t].getx0()][jou[t].gety0()].getcasecolor().defCouleur();
		StdDraw.text(this.l+1,this.l-2-2*t,jou[t].getnom());
		StdDraw.text(this.l+1,this.l-3-2*t,Integer.toString(jou[t].getscore()));
	}}}
	Brouge.afficherBouton(0.5, -1.5);
	Borange.afficherBouton(2.5, -1.5);
	Bjaune.afficherBouton(4.5, -1.5);
	Bvert.afficherBouton(6.5, -1.5);
	Bbleu.afficherBouton(8.5, -1.5);
	Bcyan.afficherBouton(10.5, -1.5);
}
public void controlCase(int x,int y){
	int voisin=0;
if(p[x][y].getcasecolor().getjcolor()!=null && p[x][y].getjcase()==null){
	if(y>0 &&(p[x][y].getcasecolor()==p[x][y-1].getcasecolor()) && p[x][y-1].getjcase()!=null){
		p[x][y].setj(p[x][y-1].getjcase());
		voisin=1;
	}
	if(y<this.l-1 &&(p[x][y].getcasecolor()==p[x][y+1].getcasecolor()) && p[x][y+1].getjcase()!=null){
		p[x][y].setj(p[x][y+1].getjcase());
		voisin=1;
	}
	if(x>0 &&(p[x][y].getcasecolor()==p[x-1][y].getcasecolor()) && p[x-1][y].getjcase()!=null){
		p[x][y].setj(p[x-1][y].getjcase());
		voisin=1;
	}
	if(x<this.l-1 &&(p[x][y].getcasecolor()==p[x+1][y].getcasecolor()) && p[x+1][y].getjcase()!=null){
		p[x][y].setj(p[x+1][y].getjcase());
		voisin=1;
	}
	if(voisin==1){
		p[x][y].getcasecolor().getjcolor().setscore(p[x][y].getcasecolor().getjcolor().getscore()+1);

	}
}	
}
public Case[][] getp(){
	return this.p;
}
public int getl(){
	return l;
}
public couleur getrouge(){
	return rouge;
}
public couleur getorange(){
	return orange;
}
public couleur getjaune(){
	return jaune;
}
public couleur getvert(){
	return vert;
}
public couleur getbleu(){
	return bleu;
}
public couleur getcyan(){
	return cyan;
}
}

