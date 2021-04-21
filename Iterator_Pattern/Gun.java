package Iterator_Pattern;

public class Gun {
    String name;
    double ammo;
    boolean auto;
    int damage;

    public Gun(String name, double ammo, boolean auto, int damage){
        this.name = name;
        this.ammo = ammo;
        this.auto = auto;
        this.damage = damage;
    }
 
    public String getname(){
        return name;
    }
    public double getammo(){
        return ammo;
    }
    public boolean isauto(){
        return auto;
    }
    public int getdamage(){
        return damage;
    }
}
