package abstract_Factory_Pattern;

public class abstract_Factory_Pattern {

    public static void main(String[] args) {
        CharacterReg reg = new WarriorReg();
        Character Kevin = reg.regCha("warrior");
        
    }
        
    
    
}
