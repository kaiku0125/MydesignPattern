package Bridge_Pattern;

public class Hero extends MarvelCharacter{
    
    public Hero(SuperPower superPower){
        super(superPower);
    }
    @Override
    public void characteristic() {
        superPower.useSuperPower();
    }
    
}

