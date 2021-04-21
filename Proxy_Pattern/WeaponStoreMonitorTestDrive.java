package Proxy_Pattern;

import java.rmi.Naming;

public class WeaponStoreMonitorTestDrive {
    public static void main(String[] args) {
        String[] location = {"rmi://santafe.mightygumball.com/gumballmachine",
                            "rmi://boulder.mightygumball.com/gumballmachine",
                            "rmi://austin.mightygumball.com/gumballmachine"};
        if(args.length >= 0){
            location = new String[1];
            location[0] = "rmi://" + args[0] + "/gumballmachine";
        }

        WeaponStoreMonitor[] monitor = new WeaponStoreMonitor[location.length];
        
        for (int i = 0; i < location.length; i++){
            try {
                WeaponStoreRemote remote = (WeaponStoreRemote) Naming.lookup(location[i]);
                monitor[i] = new WeaponStoreMonitor(remote);
                System.out.println(monitor[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i =0; i < monitor.length; i++){
            monitor[i].report();
        }

    }
    
}
