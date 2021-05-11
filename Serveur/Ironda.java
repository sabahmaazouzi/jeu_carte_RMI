package Serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Ironda extends Remote {
	public void poser(int numdecarte,int joueur) throws RemoteException;
    public int GetTour() throws RemoteException;
    public int[] GetTable() throws RemoteException;
    public int[] GetScore() throws RemoteException;
}

