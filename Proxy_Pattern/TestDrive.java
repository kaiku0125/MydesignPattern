package Proxy_Pattern;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class TestDrive {
    public static void main(String[] args) throws RemoteException {
        
        WeaponStoreRemote weaponStoreremote = null;
        
        
        
        if(args.length < 2){
            System.out.println(".........");
            System.exit(1);
        }

        try {
            weaponStoreremote = new WeaponStore(args[0]);
            Naming.rebind(args[0], weaponStoreremote);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
