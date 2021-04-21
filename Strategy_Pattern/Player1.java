package Strategy_Pattern;

import java.util.Scanner;

public class Player1 extends Character{
    private WeaponBehavior sword, arrow;
    private String name;
    private int x;

    public Player1(String name) {

        this.name = name;
        sword = new SwordBehavior();
        arrow = new ArrowBehavior();
        
        WPB = arrow;
    
    }

    public String getname() {
        // System.out.println(name);
        return name;
    }

    public void setweapon(){
        
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();////////////////輸入要切換的武器
        
        switch(x){

            case 1 :
                WPB = sword;
                System.out.println(getname()+"裝備了長劍");
                break;
            
            case 2:
                WPB = arrow;
                System.out.println(getname()+"裝備了弓箭");
                break;
            
            default:
                System.out.println("無此欄位武器");

        }
 
        
    }
    public void weaponchanged(){

        System.out.println("切換武器");
        setweapon();
            
    }
}
