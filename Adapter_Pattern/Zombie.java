package Adapter_Pattern;

public class Zombie implements AllZombie{

    @Override
    public void walk() {
        System.out.println("走路一拐一拐");

    }

    @Override
    public void attack() {
        System.out.println("攻擊人類");

    }
    
}
