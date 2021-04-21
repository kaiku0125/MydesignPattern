package Iterator_Pattern;

import java.util.Iterator;

public interface Menu {
    public Iterator<Gun> createIterator();
    public void addguns(String name, double ammo, boolean auto, int damage);
        
}
