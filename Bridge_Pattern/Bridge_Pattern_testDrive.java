package Bridge_Pattern;

import java.util.ArrayList;

public class Bridge_Pattern_testDrive {
    public static void main(String[] args) {
        ArrayList<MarvelCharacter> characters = new ArrayList<>();

        MarvelCharacter BatMan = new Hero(new Rich());
        MarvelCharacter CaptainAmerica = new Hero(new Muscle());
        characters.add(BatMan);
        characters.add(CaptainAmerica);
        
        for(int i = 0; i < characters.size(); i++){
            Object obj = characters.get(i);
            ((MarvelCharacter) obj).characteristic();
        }        
    }
}

