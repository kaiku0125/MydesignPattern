package Factory_Pattern;

public abstract class Character {

    String name;
    int HP;
    int MP;

    void aboutcharacter(){
        System.out.println("角色定位:"+ name);
        System.out.println("角色血量:" + HP);
        System.out.println("角色魔力:" + MP);    
    }

    void NormalAttack(){
        System.out.println("普攻:使用預設普攻");
    }

    void Skill(){
        System.out.println("角色技能:使用預設技能");
    }

    abstract void Ult();



    public String getname(){
        return name;
    }
    public int getHP(){
        return HP;

    }
    public int getMP(){
        return MP;
    }

    
}
