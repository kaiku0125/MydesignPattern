package abstract_Factory_Pattern;

public abstract class Character {
    Weapon weapon;
    Equipment equipment;

    public abstract void CharacterInit();

    public void NormalAttack(){
        System.out.println("普攻:使用預設普攻");
    }

    public void Skill(){
        System.out.println("角色技能:使用預設技能");
    }
}
