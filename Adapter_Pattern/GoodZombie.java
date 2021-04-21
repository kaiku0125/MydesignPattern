package Adapter_Pattern;

public class GoodZombie implements AllZombie{

    @Override
    public void walk() {
        System.out.println("模仿人類走路");

    }

    @Override
    public void attack() {
        System.out.println("模仿人類進食，但以生肉為食");

    }
    
}
