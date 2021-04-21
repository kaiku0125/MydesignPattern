package Composite_Pattern;

import java.util.Iterator;

public abstract class MenuComponent {
    
    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }
    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }
    public String getName(){
        throw new UnsupportedOperationException();
    }
    public double getAmmo(){
        throw new UnsupportedOperationException();
    }
    public boolean isAuto(){
        throw new UnsupportedOperationException();
    }
    public int getDamage(){
        throw new UnsupportedOperationException();
    }
    public void print(){
        throw new UnsupportedOperationException();
    }
    public Iterator<MenuComponent> createIterator(){
        throw new UnsupportedOperationException();
    }
}
