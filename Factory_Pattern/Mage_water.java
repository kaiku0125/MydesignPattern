package Factory_Pattern;

public class Mage_water extends Character {

    public Mage_water(){
        name = "水屬性法師";
        HP = 200;
        MP = 1000000;
    }

    @Override
    void Ult() {
        System.out.println("特殊技能:喝更多水");
    }

    void Skill(){

        System.out.println("角色技能:喝水");
    }

    
}
