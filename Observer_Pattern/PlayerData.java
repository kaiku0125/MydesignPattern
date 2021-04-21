package Observer_Pattern;

import java.util.ArrayList;
import java.util.List;

public class PlayerData implements Subject {

    List<Observer> observers = new ArrayList<Observer>();
    private int HP,MP;

    @Override
    public void registerOb(Observer o) {
       observers.add(o);

    }

    @Override
    public void removeOb(Observer o) {
        observers.remove(o);

    }

    public void notifyOb(){
        for (int i=0 ; i<observers.size() ; i++){
            Observer observer = observers.get(i);
            observer.update(HP, MP);
        }
    }

    public void setMeasurement(int HP, int MP){
        
        this.HP = HP;
        this.MP = MP;
        notifyOb();
        
    }

    public int getHP(){
        return HP;
    }

    public int getMP(){
        return MP;
    }

    // public void getHP(){
        
    // }

    
}
