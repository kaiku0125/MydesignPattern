package Proxy_Pattern;

public class SuccessState implements State{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    transient WeaponStore weaponstore;

    public SuccessState(WeaponStore weaponstore){
        this.weaponstore = weaponstore;
    }

    @Override
    public void insertMaterial() {
        System.out.println("無效動作!!");

    }

    @Override
    public void ejectMaterial() {
        System.out.println("無效動作!!");

    }

    @Override
    public void pressEnhancement() {
        System.out.println("無效動作!!");

    }

    @Override
    public void onceagain() {
        System.out.println("您按下再次強化");
        weaponstore.setState(weaponstore.getNoMaterailState());
        System.out.println("請放入素材...");

    }
    
}
