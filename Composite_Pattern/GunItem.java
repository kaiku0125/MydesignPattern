package Composite_Pattern;
import java.util.Iterator;

public class GunItem extends MenuComponent{
    String name;
    double ammo;
    boolean auto;
    int damage;

    public GunItem(String name, double ammo, boolean auto, int damage){
        this.name = name;
        this.ammo = ammo;
        this.auto = auto;
        this.damage = damage;
    }
    public String getName(){
        return name;
    }
    public double getAmmo(){
        return ammo;
    }
    public boolean isAuto(){
        return auto;
    }
    public int getDamage(){
        return damage;
    }
    public void print(){
        System.out.print(" " + getName() + " : ");
        System.out.print(" " + getAmmo() + "子彈孔徑, ");
        if(isAuto()){
            System.out.print("全自動");
        }
        System.out.println(" 傷害:" + getDamage());
        
    }
    public Iterator<MenuComponent> createIterator(){
        return new NullIterator();
    }
}
