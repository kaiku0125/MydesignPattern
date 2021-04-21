package Factory_Pattern;

public class MageRegister extends CharacterRegister{
    @Override
    Character createCharacter(String type) {
        
        if(type.equals("fire")){
            return new Mage_fire();
        }
        else if(type.equals("water")){
            return new Mage_water();
        }
        else return null;


    }
    
}
