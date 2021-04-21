package Factory_Pattern;

public class Warrior_fire extends Character{
    
    public Warrior_fire(){
        name = "火屬性戰士";
        HP = 1000;
        MP = 100;
    }

	@Override
	void Ult() {
		System.out.println("特殊技能:火屬性大招");
	}
    
}
