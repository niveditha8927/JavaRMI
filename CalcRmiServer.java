package de.unistgt.ipvs.vs.ex2.server;

import de.unistgt.ipvs.vs.ex2.common.ICalculationFactory;

import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CalcRmiServer extends Thread {
	private String regHost;
	private String objName;
	private int port;
	private static int CreateRegistry=1; //Set the variable to zero when registry is created to avoid creating again;
        String url; //Please use this variable to bind the object.
	
	public CalcRmiServer(String regHost, String objName) {
		this.regHost = regHost;
		this.objName = objName;
		this.port = 22345; 
                this.url = "rmi://" + regHost + ":"+port+"/" + objName;
	}
	@Override
	public void run() {
		if (regHost == null || objName == null) {
			System.err.println("<registryHost> or <objectName> not set!");
			return;
		}
			try {
				CalculationImplFactory implfac = new CalculationImplFactory();
				implfac.createAbind(url,port,CreateRegistry);
				CreateRegistry=0;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Add solution here
 catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AlreadyBoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

        public void stopServer(){
            try {
                Naming.unbind(url);
            } catch (RemoteException ex) {
                Logger.getLogger(CalcRmiServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(CalcRmiServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(CalcRmiServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
}
