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
				c+=1;}
				}
		 }}
    	   p.affplateau();
    	   for(int k=0;k<p.getl();++k){
   			for(int t=0;t<p.getl();++t){
   				for(int l=0;l<p.getl();++l){
   					p.controlCase(t, l);
   				}
   			}}}
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
		if((x==1||x==0) && (y==-1||y==-2) && p.getrouge().getjcolor()==null){
			tour(j[i],p.getrouge());
			c=1;
		}
		if((x==2||x==3) && (y==-1||y==-2) && p.getorange().getjcolor()==null){
			tour(j[i],p.getorange());
			c=1;
		}
		if((x==4||x==5) && (y==-1||y==-2) && p.getjaune().getjcolor()==null){
			tour(j[i],p.getjaune());
			c=1;
		}
		if((x==6||x==7) && (y==-1||y==-2) && p.getvert().getjcolor()==null){
			tour(j[i],p.getvert());
			c=1;
		}
		if((x==8||x==9) && (y==-1||y==-2) && p.getbleu().getjcolor()==null){
			tour(j[i],p.getbleu());
			c=1;
		}
		if((x==10||x==11) && (y==-1||y==-2) && p.getcyan().getjcolor()==null){
			tour(j[i],p.getcyan());
			c=1;
		}
		if(c==1){
		p.affplateau();}}}
	}
}
	public void game(){
		p.defplateau();
		p.affplateau();
		this.initjoueur(2);
		while(true){
			for(int i=0;i<2;++i){
		this.clickBouton(i);
		}}
	}

	}


