package Iterator_Pattern;

import java.util.ArrayList;
import java.util.Iterator;

public class RifleMenu implements Menu {

    ArrayList<Gun> Rifle;

    public RifleMenu(){
        Rifle = new ArrayList<Gun>();

        addguns("AKM", 7.62, true, 48);
        addguns("M416", 5.56, true, 41);
        addguns("SCAR-L", 5.56, true, 41);
        addguns("M16A4", 5.56, false, 41);
    }

    @Override
    public void addguns(String name, double ammo, boolean auto, int damage){
        Gun gun = new Gun(name, ammo, auto, damage);
        Rifle.add(gun);
    }

    @Override
    public Iterator<Gun> createIterator() {
       return Rifle.iterator();
    }

    
    
}
