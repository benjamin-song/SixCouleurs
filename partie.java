public class partie {
	private joueur[] j;
	private plateau p =new plateau(13);;
	private boolean finpartie;
	
	public partie(){
		j=null;
		finpartie=false;
	}
	public void menu(){
		StdDraw.setCanvasSize(800,600);
		StdDraw.setXscale(-0.5,p.getl()+3.5);
		StdDraw.setYscale(-2.5,p.getl()-0.5);
		StdDraw.clear(StdDraw.BOOK_LIGHT_BLUE);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(p.getl()/2+2, p.getl()-3, "Jeu des 6 couleurs");
			StdDraw.text(p.getl()/2+2, 8, "Nombre de joueur");
		StdDraw.rectangle(p.getl()/2+2, 6, p.getl()/2,p.getl()/8);
		StdDraw.rectangle(p.getl()/2+2, 3, p.getl()/2,p.getl()/8);
		StdDraw.rectangle(p.getl()/2+2, 0, p.getl()/2,p.getl()/8);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(p.getl()/2+2, 6, p.getl()/2,p.getl()/8);
		StdDraw.filledRectangle(p.getl()/2+2, 3, p.getl()/2,p.getl()/8);
		StdDraw.filledRectangle(p.getl()/2+2, 0, p.getl()/2,p.getl()/8);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(p.getl()/2+2, 6, "2 joueurs");
		StdDraw.text(p.getl()/2+2, 3, "3 joueurs");
		StdDraw.text(p.getl()/2+2, 0, "4 joueurs");
		int choix =0;
		while(true){
			if(StdDraw.mousePressed()){
				
				int x=(int)Math.round(StdDraw.mouseX());
				int y=(int)Math.round(StdDraw.mouseY());
			if(x<=14 && x>=2 && y<=7 && y>=5 ){
				choix=2;
				break;
				}
			if(x<=14 && x>=2 && y<=4 && y>=2 ){
				choix=3;
				break;
				}
			if(x<=14 && x>=2 && y<=1 && y>=-1 ){
				choix=4;
				break;
				}
			}}
			p.affplateau(this.j);
				this.initjoueur(choix);
			
	}
	public void initjoueur(int nb){
		this.j=new joueur[nb];
       for(int i=0;i<nb;i++){
    	   int c=0;
    	   StdDraw.setPenColor(StdDraw.BLACK);
		   StdDraw.text(p.getl()/2+1, -1, "Joueur "+Integer.toString(i+1) +" choisissez votre case de départ");
		   StdDraw.text(p.getl()/2+1, -1.5, "Appuyez sur espace pour créer une IA");
    	   while(c==0){
    	   if(StdDraw.mousePressed()){
				int x=(int)Math.round(StdDraw.mouseX());
				int y=(int)Math.round(StdDraw.mouseY());
				if(y>=0 && x<p.getl()-0.5){
				this.j[i]=new joueur("Joueur "+Integer.toString(i+1),x,y,false);
				if(p.getp()[j[i].getx0()][j[i].gety0()].getcasecolor().getjcolor()==null){
				p.getp()[j[i].getx0()][j[i].gety0()].setj(j[i]);
				p.getp()[j[i].getx0()][j[i].gety0()].getcasecolor().setjcolor(j[i]);
				c+=1;}
				
				}
		 }
    	   if(StdDraw.hasNextKeyTyped() ){
    		   System.out.println("e");
    			int nx=StdDraw.nextKeyTyped();
    			if(nx==32){
    				 System.out.println("space");
    				int[] tab=p.caseDepIa();
    				int x=tab[0];
    				int y=tab[1];
    				this.j[i]=new joueur("Joueur "+Integer.toString(i+1)+" (IA)",x,y,true);
    				p.getp()[j[i].getx0()][j[i].gety0()].setj(j[i]);
    				p.getp()[j[i].getx0()][j[i].gety0()].getcasecolor().setjcolor(j[i]);
    				c+=1;
    			}}
    			}
    	   for(int k=0;k<p.getl();++k){
   			for(int t=0;t<p.getl();++t){
   				for(int l=0;l<p.getl();++l){
   					p.controlCase(t, l);
   				}
   			}}
    	   p.affplateau(this.j);
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
boolean caselibre=true;
while(c!=1){
	for(int a=0;a<p.getl();++a){
		for(int b=0;b<p.getl();++b){
			if(p.getp()[a][b].getjcase()==null){
				caselibre=false;
			}
		}
	}
	for(int d=0;d<j.length;++d){
		if(j[d].getscore()>p.getl()*p.getl()/2){
			caselibre=true;	
	}}
		if(caselibre==true){
			this.finpartie=true;
			c=1;
		}
	if(j[i].getia()==false){
	if(StdDraw.mousePressed()){
		
		int x=(int)Math.round(StdDraw.mouseX());
		int y=(int)Math.round(StdDraw.mouseY());
		
		if(y<0){
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
		}}}}
		if(j[i].getia()==true){
			couleur mc=p.bestColor(j[i]);
			tour(j[i],mc);
			c=1;
			 try {Thread.sleep(10000);}
			 catch(InterruptedException x){}
		}
		if(c==1){
		p.affplateau(this.j);}
	}
}
public void affscore(){
	joueur comp=j[0];
	int best=j[0].getscore();
	for(int i=1;i<this.j.length;++i){
		int score=j[i].getscore();
		if(score>best){
			best=score;
			comp=j[i];
		}
	}
	StdDraw.clear();
	StdDraw.setPenColor(StdDraw.BLACK);
	StdDraw.setPenRadius(1000);//à modifier
	StdDraw.text(p.getl()/2,p.getl()/2,"Victoire de "+ comp.getnom());
	StdDraw.text(p.getl()/2,p.getl()/2-1,"avec un score de "+Integer.toString(comp.getscore())+" points");
	
}
	public void game(){
		p.defplateau();
		menu();
		int t=0;
		while(t==0){
			for(int i=0;i<this.j.length;++i){
		this.clickBouton(i);
		if(this.finpartie==true){
			t=1;
			break;
		}}
			
	}
		affscore();}

	}


