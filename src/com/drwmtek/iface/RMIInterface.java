package com.drwmtek.iface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface RMIInterface extends Remote {
	public String helloTo(String msg, Date date) throws RemoteException;
	public String shutdown() throws RemoteException;
}