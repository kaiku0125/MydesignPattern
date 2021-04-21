package Strategy_Pattern;



public class Player2 extends Character {

    private String name;

    public Player2(String name){
        
        this.name = name;
        WPB = new ArrowBehavior();
    }
    
    public String getname() {
        // System.out.println(name);
        return name;
    }

    public void setweapon(){
        
    }
    public void weaponchanged(){

    }
}
