package FlyWeight_Pattern;

import java.util.HashMap;

public class GemFactory {
    private static HashMap<String, Gem> gempools = new HashMap<String, Gem>();

    public static Gem getGem(String color) {
        Gem gems = gempools.get(color);

        if (gems == null) {
            gems = new InfinityGems(color);
            gempools.put(color, gems);
            System.out.println("Pool中無此顏色，因此創建" + color + "顏色的寶石");
        }
        return gems;
    }
}
