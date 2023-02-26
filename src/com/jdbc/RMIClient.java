package com.jdbc;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

public class RMIClient {
    public static void main(String[] args) throws MalformedURLException, NotBoundException {
        System.setSecurityManager(new RMISecurityManager());
        try {
            SampleServer remServer = (SampleServer) Naming.lookup("sample1");
            System.out.println("Got remote object");
            System.out.print("1+2: " + remServer.sum(1, 2));

        } catch (RemoteException e) {

        }

    }

}
