package Composite_Pattern;

import java.util.Iterator;

public class Overview {
    MenuComponent allGuns;

    public Overview(MenuComponent allGuns){
        this.allGuns = allGuns;
    }

    public void printall(){
        allGuns.print();
    }
    
    //今天allGuns有三個菜單，所以在create的時候會將三個菜單丟進stack中
    public void printAutoGun(){                                                 
        Iterator<MenuComponent> iterator = allGuns.createIterator(); 
        System.out.println("\nAutoGunMenu\n-------------------");
        while(iterator.hasNext()){
            MenuComponent menuComponent = (MenuComponent)iterator.next();
            try {
                if(menuComponent.isAuto()){
                    menuComponent.print();
                }
            } catch (Exception e) {
                
            }
        }
    }
}
