package Proxy_Pattern;

public class WeaponStoreMonitor {
    WeaponStoreRemote remote;
    
    public WeaponStoreMonitor(WeaponStoreRemote remote){
        this.remote = remote;
    }
    public void report(){
        try {
            System.out.println("Currrent state :" + remote.getState());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
