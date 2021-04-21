package Factory_Pattern;

public class Warrior_water extends Character{

    public Warrior_water(){
        name = "水屬性戰士";
        HP = 1000;
        MP = 100;
    }

	@Override
	void Ult() {
		System.out.println("特殊技能:水屬性大招");
    }
    
    
}
