package abstract_Factory_Pattern;

public abstract class CharacterReg  {


    protected abstract Character createCharacter(String type);

    public Character regCha(String type){
        Character character = createCharacter(type);
        System.out.println("準備創建角色");
        character.CharacterInit();////包裝在warrior裡
        character.NormalAttack();///未變動
        character.Skill();////未變動
       
        return character;
    }
}
