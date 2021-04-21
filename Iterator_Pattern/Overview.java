package Iterator_Pattern;


//import java.util.ArrayList;
import java.util.Iterator;

public class Overview {

    Menu sniperMenu;
    Menu rifleMenu;
    
    // ArrayList<Menu> menus; 

    public Overview(Menu sniperMenu, Menu rifleMenu){
        this.sniperMenu = sniperMenu;
        this.rifleMenu = rifleMenu;
        // this.menus = menus
    }

    public void printGun(){
    //    Iterator<?> menuIterator = menus.iterator();
    //    while(menuIterator.hasNext()){
    //        Menu menu = (Menu)menuIterator.next();
    //        System.out.println("-----------");
    //        printGun(menu.createIterator());
    //    }
        Iterator<Gun> snipeIterator = sniperMenu.createIterator();
        Iterator<Gun> riflIterator = rifleMenu.createIterator();
        System.out.println("狙擊槍...");
        printGun(snipeIterator);
        System.out.println("步槍...");
        printGun(riflIterator);
    }
    
    public void printGun(Iterator<Gun> intIterator){
        while(intIterator.hasNext()){
            Gun allguns = (Gun) intIterator.next();
            System.out.print(allguns.getname() + " : ");
            System.out.print(allguns.getammo()+"子彈孔徑, ");
            System.out.print("傷害:" + allguns.getdamage());
            if(allguns.auto){
                System.out.println(", 可全自動");
            }else{
                System.out.println(", 只支援單發射擊");
            }
        }
    }
}
