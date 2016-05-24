import java.util.Scanner;
public class partie {
	private joueur[] j;
	private plateau p =new plateau(13);;
	
	public partie(){
		j=null;
	}
	public void initjoueur(int nb){
		Scanner s = new Scanner(System.in);
		this.j=new joueur[nb];
       for(int i=0;i<nb;i++){
    	   System.out.println("veuillez entrer votre nom");
    	   String nom=s.nextLine();
    	   int c=0;
    	   System.out.println("veuillez séléctionner votre case de départ");
    	   while(c==0){
    	   if(StdDraw.mousePressed()){
				int x=(int)Math.round(StdDraw.mouseX());
				int y=(int)Math.round(StdDraw.mouseY());
				if(y>=0){
				this.j[i]=new joueur(nom,x,y);
				if(p.getp()[j[i].getx0()][j[i].gety0()].getcasecolor().getjcolor()==null){
				p.getp()[j[i].getx0()][j[i].gety0()].setj(j[i]);
				p.getp()[j[i].getx0()][j[i].gety0()].getcasecolor().setjcolor(j[i]);
				c+=1;}}
		 }}
       }
	}
	public void tour(joueur j,couleur c){
		couleur exc=p.getp()[j.getx0()][j.gety0()].getcasecolor();
		exc.setjcolor(null);
		c.setjcolor(j);
		for(int i=0;i<p.getl();++i){
			for(int l=0;l<p.getl();++l){
				if (p.getp()[i][l].getjcase()==j){
					p.getp()[i][l].setcolor(c);
				}
			}
		}
		for(int k=0;k<p.getl();++k){
			for(int i=0;i<p.getl();++i){
				for(int l=0;l<p.getl();++l){
					p.controlCase(i, l);
				}
			}
		}
	}
public void clickBouton(int i){
int c=0;
while(c!=1){
	if(StdDraw.mousePressed()){
		
		int x=(int)Math.round(StdDraw.mouseX());
		int y=(int)Math.round(StdDraw.mouseY());
		
		if(y<0){
			System.out.println(x);
			System.out.println(y);
		if((x==1||x==0) && (y==-1||y==-2)){
			tour(j[i],p.getrouge());
			
		}
		if((x==2||x==3) && (y==-1||y==-2)){
			tour(j[i],p.getorange());
			
		}
		if((x==4||x==5) && (y==-1||y==-2)){
			tour(j[i],p.getjaune());
			
		}
		if((x==6||x==7) && (y==-1||y==-2)){
			tour(j[i],p.getvert());
			
		}
		if((x==8||x==9) && (y==-1||y==-2)){
			tour(j[i],p.getbleu());
			
		}
		if((x==10||x==11) && (y==-1||y==-2)){
			tour(j[i],p.getcyan());
			
		}
		c+=c;}}
	}
}
	public void game(){
		p.defplateau();
		p.affplateau();
		this.initjoueur(2);
		p.affplateau();
		while(true){
			for(int i=0;i<2;++i){
		this.clickBouton(i);
		p.affplateau();
		}}
	}

	}


