package Observer_Pattern;

public class Player1 implements Observer, DisplayElement {

    PlayerData pd;
    private int HP,MP;


    public Player1(PlayerData pd) {
        this.pd = pd;
        pd.registerOb(this);

    }
    
    
    @Override
    public void update(int HP, int MP) {
        this.HP = HP;
        this.MP = MP;
        display();
    }
    
    @Override
    public void display() {
        if (HP<20){
            System.out.println("血量過低");
        }
        if (MP<20){
            System.out.println("魔力不足");
        }

    }

    
    
}
