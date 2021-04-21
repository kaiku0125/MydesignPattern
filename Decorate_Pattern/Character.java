package Decorate_Pattern;

public abstract class Character {

    String Description = "角色";
    
    public String getDescription(){
        return Description;
    }

    public abstract int defense();
}
