package Serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Ronda extends UnicastRemoteObject implements Ironda{
   
    private int[] score; // les scores du 2 joueurs
	private int[] table;
	private int tour=1;
	
	public Ronda() throws RemoteException {
		
		table=new int[10];
		score=new int[2];
		score[0]=0;
		score[1]=0;
		
		//  distrubuer 4 cartes sur la table.
		for(int i =0;i<10;i++) {
			if(i<4) {
				table[i]=(i+1)*4;
			}
			else
				table[i]=0;
		}
	}
	
    @Override
    public int GetTour() {
    	return tour;
    }
	
	@Override	
	public int[] GetTable() throws RemoteException {		
		return table;	
	}
	
	@Override	
	public int[] GetScore() throws RemoteException {
		return score;
	}
	
	@Override
	public void poser(int numdecarte,int joueur) throws RemoteException {
		
		int b=1;
		int manger=0;
		
		// changemement de tour		
		if(tour==1 && joueur==0)
			tour=0;
		
		if(tour==0 && joueur==1)
			tour=1;
		
		while(b==1)
		{
			for(int i=0;i<10;i++) {
				if(table[i]==numdecarte) {
					table[i]=0;
					b=2;
					if(joueur==1) {
						score[0]=score[0]+1;
					}
					else
						score[1]=score[1]+1;
					manger=1;
				}
			}
			if(b==2) {
				b=1;
				numdecarte=numdecarte+4;
			}
				
			else
				b=0;
			
		}
		
		if(manger==0) {
			for(int i=0;i<10;i++) {
				if(table[i]==0) {
					table[i]=numdecarte;
					break;
				}
			}
		}	
	
	}

}
