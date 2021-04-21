package Adapter_Pattern;

public class Adapter_Pattern {
    public static void main(String[] args) {
        
        Zombie zombie = new Zombie();
        GoodZombie goodZombie = new GoodZombie();
        Human human = new Guy();
        GoodZombieAdapter goodZombieAdapter = new GoodZombieAdapter(goodZombie);
        

        System.out.println("測試一般殭屍行為...");
        zombie.walk();
        zombie.attack();
        System.out.println("----------------------");
        System.out.println("測試人類行為...");
        testhuman(human);
        System.out.println("----------------------");
        System.out.println("測試goodzombie適應人類生活的情況....");
        testhuman(goodZombieAdapter);

    }

    public static void testhuman(Human human){
        human.walk();
        human.eat();
    }
    
}
