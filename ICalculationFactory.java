package de.unistgt.ipvs.vs.ex2.common;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ICalculationFactory extends Remote {
	// create a new multiplication session
	public ICalculation getSession() throws RemoteException;
}