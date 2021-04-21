package Iterator_Pattern;

// import java.util.ArrayList;

public class Iterator_Pattern {
    public static void main(String[] args) {

        // SniperMenu sniperMenu = new SniperMenu();
        
        // Gun[] sniperRifle = sniperMenu.getGuns();
        // for(int i = 0; i < sniperRifle.length; i++){

        //     Gun gun = sniperRifle[i];
        //     System.out.println(gun.getname());
        //     System.out.println(gun.getammo());
        //     System.out.println(gun.isauto());
        //     System.out.println(gun.getdamage());

        // }
        //-----------------------------------------------------------------

        SniperMenu sniperMenu = new SniperMenu();
        RifleMenu rifleMenu = new RifleMenu();
        Overview overview = new Overview(sniperMenu,rifleMenu);
        overview.printGun();

        //-----------------------------------------------------------------

        // SniperMenu sniperMenu = new SniperMenu();
        // RifleMenu rifleMenu = new RifleMenu();
        // ArrayList<Menu> gum_menus = new ArrayList<Menu>();
        // gum_menus.add(sniperMenu);
        // gum_menus.add(rifleMenu);
        // Overview overview = new Overview(gum_menus);
        // overview.printGun();
        
        
    }
    
}
