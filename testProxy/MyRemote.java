package testProxy;

import java.rmi.Remote; 
import java.rmi.RemoteException; 

public interface MyRemote extends Remote{
    public String printMsg() throws RemoteException;  
}


