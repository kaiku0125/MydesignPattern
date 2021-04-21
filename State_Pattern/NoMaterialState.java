package State_Pattern;

public class NoMaterialState implements State{
    WeaponStore weaponstore;

    public NoMaterialState(WeaponStore weaponstore){
        this.weaponstore = weaponstore;
    }

    @Override
    public void insertMaterial() {
        System.out.println("放入強化素材");
        weaponstore.setState(weaponstore.getHasMaterialState());
    }

    @Override
    public void ejectMaterial() {
        System.out.println("尚未放入強化素材");

    }

    @Override
    public void pressEnhancement() {
        System.out.println("需要強化素材才能強化");
    }

    @Override
    public void onceagain() {
        System.out.println("無效動作!!");

    }
    
}
