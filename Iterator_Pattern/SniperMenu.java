package Iterator_Pattern;

import java.util.Iterator;

public class SniperMenu implements Menu{
    public static int MAXVALUE = 4;
    Gun[] SniperRifle;
    int position = 0;

    public SniperMenu(){
        SniperRifle = new Gun[MAXVALUE];

        addguns("KAR98K", 7.62, false, 72);
        addguns("SKS", 7.62, false, 55);
        addguns("VSS", 9, true, 35);
        addguns("Mini14", 5.56, false, 44);
    }

    @Override
    public Iterator<Gun> createIterator() {
        
        return new Sniper_Iterator(SniperRifle);
        
    }

    @Override
    public void addguns(String name, double ammo, boolean auto, int damage){
        Gun gun = new Gun(name, ammo, auto, damage);
        if(position >= MAXVALUE){
            System.out.println("無法新增更多槍枝");
        }else{
            SniperRifle[position] = gun;
            position = position + 1;
        }
    }
    //---------------------------------
    public Gun[] getGuns(){
        return SniperRifle;
    }

    
}






    

