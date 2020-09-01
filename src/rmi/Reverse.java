package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface Reverse represents simple remote interface with a single method.
 * Creates in both server and client packages.
 *
 * @author Kamila Meshcheryakova
 * created by 01.09.2020
 */
public interface Reverse extends Remote {
    String reverse(String str) throws RemoteException;
}

