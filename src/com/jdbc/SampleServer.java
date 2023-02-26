package com.jdbc;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SampleServer extends UnicastRemoteObject implements RMI {
    SampleServer() throws RemoteException {
        super();
    }

    @Override
    public int sum(int a, int b) throws RemoteException {
        return a + b;
    }

}
