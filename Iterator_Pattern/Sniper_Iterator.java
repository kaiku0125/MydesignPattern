package Iterator_Pattern;

import java.util.Iterator;

public class Sniper_Iterator implements Iterator<Gun>{
    Gun[] SniperRifle;
    int position = 0;

    public Sniper_Iterator(Gun[] SniperRifle){
        this.SniperRifle = SniperRifle;
    }

    @Override
    public boolean hasNext() {
        if(position >= SniperRifle.length || SniperRifle[position] == null){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public Gun next() {
        Gun gun = SniperRifle[position];
        position = position + 1;
        return gun;
    }
    
}
