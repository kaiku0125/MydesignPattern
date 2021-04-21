package Decorate_Pattern;

public class armor extends EquipmentDecorator{

    Character character;

    public armor(Character character){
        this.character = character;
    }
    @Override
    public String getDescription() {
        return character.getDescription()+"+盔甲";
    }

    @Override
    public int defense() {
        return 500+character.defense();

    }
    
}
