package com.drwmtek.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.drwmtek.iface.RMIInterface;
import java.util.Date;

public class Client {
	private static RMIInterface iface;

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		iface = (RMIInterface) Naming.lookup("//localhost/server");
		while(true) {
			System.out.print("Enter text:");
			String txt = System.console().readLine();
			if (txt.equals("exit")) {
				break;
			}

			if(txt.equals("shutdown server")) {
				try {
					iface.shutdown();
				} catch (Exception e) {
					break;
				}
			}

			Date date = new Date();
			String response = iface.helloTo(txt, date);
			System.err.println("From SERVER: " + response);
		}
	}
}
