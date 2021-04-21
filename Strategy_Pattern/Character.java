package Strategy_Pattern;

public abstract class Character {

    WeaponBehavior WPB;

    public Character(){
        
    }

    public void fight(){

        WPB.useweapon();
        
    }

    public abstract String getname();
    public abstract void setweapon();
    public abstract void weaponchanged();
    
    
}
