package Serveur;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;


public class serveur {


	public static void main(String[] args) {
		
		try {
			
			LocateRegistry.createRegistry(1090);			
			Ronda joueur1=new Ronda();
			Naming.rebind("rmi://localhost:1090/banque", joueur1);			
		    int[] carte=new int[3];
		    carte[0]=4;
		    carte[1]=8;
		    carte[2]=19;
		    int trouver=0;
		    Scanner o=new Scanner(System.in);
		    int NumCarte;
			while(true) {
			
			System.out.println("choisir une carte");
			for(int i=0;i<3;i++) {
				System.out.println("carte["+(i+1)+"]="+carte[i]);
			}
			
			
			NumCarte=o.nextInt();
			trouver=0;
			while(trouver==0) {
				
				for(int i=0;i<3;i++) {
					if(carte[i]==NumCarte) {
						trouver=1;
						carte[i]=0;
					}
				}
				if(trouver==0) {
					System.out.println("entrer un num de carte valide");
					NumCarte=o.nextInt();
				}
			    
			}
			if(joueur1.GetTour()==1) {
				joueur1.poser(NumCarte,0);
				System.out.println("la nouvelle table");
				int[] table=joueur1.GetTable();
				for(int i=0;i<10;i++) {
					System.out.println("table["+i+"] = "+table[i]);
				}
				System.out.println("le score du 2 joueurs");
				int[] score=joueur1.GetScore();
				for(int i=0;i<2;i++) {
					System.out.println("le score du joueur numero "+i+"vaut :"+score[i]);
				}
			}
				
			
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}

