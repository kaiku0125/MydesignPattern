package abstract_Factory_Pattern;

public class Warrior extends Character {
    CharacterAbilityFactory characterAbilityFactory;

    
    public Warrior(CharacterAbilityFactory characterAbilityFactory) {
        this.characterAbilityFactory = characterAbilityFactory;
    }

    @Override
    public void CharacterInit() {
        System.out.println("初始化角色...");
        weapon = characterAbilityFactory.createWeapon();
        System.out.println("Warrior" + weapon);
        equipment = characterAbilityFactory.createEquipment();
        System.out.println("Warrior" + equipment);
    }

    
    
}
