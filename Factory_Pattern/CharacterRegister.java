package Factory_Pattern;

public abstract class CharacterRegister {

    abstract Character createCharacter(String type);
    
    public Character regCha(String type){
        Character character = createCharacter(type);
        character.aboutcharacter();
        character.NormalAttack();
        character.Skill();
        character.Ult();

        return character;

    }  
    
}
