package de.unistgt.ipvs.vs.ex2.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import de.unistgt.ipvs.vs.ex1.common.ICalculation;



 public class CalculationImplFactory extends CalculationImpl  {
 	public CalculationImplFactory() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	} 
 	private CalculationImpl impl;
	private static final long serialVersionUID = 8409100566761383094L;
    public void createAbind(String url,int port,int CreateRegistry) throws RemoteException, MalformedURLException, AlreadyBoundException
    {
    	//Method to create a bind with url and object
    	impl = new CalculationImpl();
    	if(CreateRegistry==1)
    	{
    		LocateRegistry.createRegistry(port);
    	}
    	System.out.println("created local regis"+this.getClass());
    	java.rmi.Naming.bind(url, impl);
    }
 }
