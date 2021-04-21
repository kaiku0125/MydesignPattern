package Command_Pattern;


public class Command_Pattern{
    public static void main(String[] args) {
        
        CharacterControl character = new CharacterControl();
        Go go = new Go();
        GoCommand w = new GoCommand("w", go);
        GoCommand d = new GoCommand("d", go);
        GoCommand a = new GoCommand("a", go);
        GoCommand s = new GoCommand("s", go);
        
        character.setCommand(w);
        character.keyboardPressed();
        character.setCommand(d);
        character.keyboardPressed();
        character.setCommand(a);
        character.keyboardPressed();
        character.setCommand(s);
        character.keyboardPressed();
    }
}

