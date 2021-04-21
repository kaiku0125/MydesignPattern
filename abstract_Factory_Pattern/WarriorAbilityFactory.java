package abstract_Factory_Pattern;

public class WarriorAbilityFactory implements CharacterAbilityFactory{

    @Override
    public Weapon createWeapon() {
        return new WarriorWeapon();
    }

    @Override
    public Equipment createEquipment() {
        return new WarriorEquipment();
    }

    
    
}
