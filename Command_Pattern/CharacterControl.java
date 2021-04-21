package Command_Pattern;

public class CharacterControl {

    Command action;
    public void setCommand(Command command){
        action = command;
    }

    public void keyboardPressed(){
        action.execute();
    }
}
