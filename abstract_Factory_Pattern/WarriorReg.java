package abstract_Factory_Pattern;



public class WarriorReg extends CharacterReg {

    @Override
    protected Character createCharacter(String type) {
        Character character = null;
        CharacterAbilityFactory characterAbilityFactory = new WarriorAbilityFactory();

        if (type.equals("warrior")){
            character = new Warrior(characterAbilityFactory);
        }

        return character;
    }
    
}
