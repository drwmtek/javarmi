package com.drwmtek.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.drwmtek.iface.RMIInterface;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class Server extends UnicastRemoteObject implements RMIInterface{

	protected Server() throws RemoteException {
		super();
	}

	@Override
	public String helloTo(String msg, Date date) throws RemoteException{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date curdate = new Date();
		System.err.println("MSG: " + msg + "     Client time: " + dateFormat.format(date));
		return "Server message for " + msg;
	}

	public String shutdown() throws RemoteException {
		System.exit(0);
		return "Exit";
	}
	
	public static void main(String[] args){
		try {
			Naming.rebind("//localhost/server", new Server());            
            System.err.println("Server ready");
            
        } catch (Exception e) {
        	System.err.println("Server exception: " + e.toString());
          e.printStackTrace();
        }
	}
}
