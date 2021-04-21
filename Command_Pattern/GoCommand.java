package Command_Pattern;

public class GoCommand implements Command {

    Go go;
    String keyboard;
    
    public GoCommand(String keyboard,Go go){
        this.keyboard = keyboard;
        this.go = go;
    }

    @Override
    public void execute() {
        if(keyboard.equals("w")){
            go.Goahead(); 
        }
        else if (keyboard.equals("a")){
            go.Goleft();
        }
        else if (keyboard.equals("d")){
            go.Goright();
        }
        else if (keyboard.equals("s")){
            go.Goback();
        }
    }  
}


