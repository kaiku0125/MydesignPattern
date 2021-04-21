package Bridge_Pattern;

public abstract class MarvelCharacter {
    SuperPower superPower;
    String name;

    public MarvelCharacter(SuperPower superPower){
        this.superPower = superPower;
    }

    public abstract void characteristic();
}

