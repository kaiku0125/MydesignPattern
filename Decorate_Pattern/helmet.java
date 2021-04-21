package Decorate_Pattern;

public class helmet extends EquipmentDecorator{

    Character character;

    public helmet(Character character){

        this.character = character;
    }
    @Override
    public String getDescription() {
        return character.getDescription()+"+helmet";
        
    }
    @Override
    public int defense() {
        return 100 + character.defense();

    }
}
