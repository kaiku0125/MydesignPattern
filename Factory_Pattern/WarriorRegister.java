package Factory_Pattern;

public class WarriorRegister extends CharacterRegister {

    @Override
    Character createCharacter(String type) {
        
        if(type.equals("fire")){
            return new Warrior_fire();
        }
        else if(type.equals("water")){
            return new Warrior_water();
        }
        else return null;


    }
    
}
