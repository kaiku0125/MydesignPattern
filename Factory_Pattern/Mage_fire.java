package Factory_Pattern;

public class Mage_fire extends Character{

    public Mage_fire(){
        name = "火屬性法師";
        HP = 200;
        MP = 1000;

    }

    @Override
    void Ult() {
        System.out.println("特殊技能:隕石轟炸");

    }
    void NormalAttack(){
        System.out.println("普攻:火球");
    }

}
    

