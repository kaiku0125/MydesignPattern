package Composite_Pattern;

import java.util.ArrayList;
import java.util.Iterator;


public class GunMenu extends MenuComponent{
    
    ArrayList<MenuComponent> ArraymenuComponents = new ArrayList<MenuComponent>(); //令一個 MenyComponent的arraylist
    public String name;
    MenuComponent menuComponent;
    

    public GunMenu(String name) {
        this.name = name;
    }

    public void add(MenuComponent menuComponent){
        ArraymenuComponents.add(menuComponent);
    }
    public void remove(MenuComponent menuComponent){
        ArraymenuComponents.remove(menuComponent);
    }

    public String getName(){
        return name;
    }
    public void print(){
        System.out.println("\n" + getName());
        System.out.println("-------------------");

        Iterator<MenuComponent> iterator = ArraymenuComponents.iterator(); //一個反覆器可以取得所有menuComponent的print
        while(iterator.hasNext()){
            menuComponent = (MenuComponent) iterator.next();
            menuComponent.print();
        }
    }
    public Iterator<MenuComponent> createIterator(){
        return new CompositeIterator(ArraymenuComponents.iterator()); //menuComponents 是arraylist
    }
}
    

