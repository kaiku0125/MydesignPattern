package Adapter_Pattern;

public class GoodZombieAdapter implements Human {

    GoodZombie goodzombie;

    public GoodZombieAdapter(GoodZombie goodzombie){
        this.goodzombie = goodzombie;
    }


    @Override
    public void walk() {
       goodzombie.walk();

    }

    @Override
    public void eat() {
        goodzombie.attack();

    }
    
}
