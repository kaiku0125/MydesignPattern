package State_Pattern;

public class State_Pattern {
    public static void main(String[] args) {
        Weapon mysword = new Weapon();
        WeaponStore weaponStore = new WeaponStore(mysword);
        
        


        System.out.println("武器名稱:" + Weapon.getname()+ "//" + 
                            "武器階級:" + Weapon.getLevel() + "\n");
        
        for(int i = 0; i < 10; i++){
            weaponStore.insertMaterial();
            weaponStore.pressEnhancement();
            if(Weapon.getLevel() >= 7){
                System.out.println("武器已為最高等級!!");
                break;
            }else{
                weaponStore.onceagain();
                System.out.println("-------------------------");
            }
        }
    }
}
