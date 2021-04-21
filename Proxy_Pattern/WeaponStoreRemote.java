package Proxy_Pattern;
import java.rmi.*;

public interface WeaponStoreRemote extends Remote{ //遠端介面
    public State getState() throws RemoteException;
    public String getLocation() throws RemoteException;
}
