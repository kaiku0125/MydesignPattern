package Prototype_Pattern;

import java.util.Hashtable;

public class Manager {
    private static Hashtable<Integer, GameObject> table = new Hashtable<Integer, GameObject>();

    public static GameObject getObject(int ID) {
        GameObject obj = table.get(ID);
        return (GameObject) obj.clone();
    }

    public static void loadAllobject() {
        Player player = new Player();
        player.setID(1);

        Monster monster = new Monster();
        monster.setID(2);

        table.put(player.getID(), player);
        table.put(monster.getID(), monster);
    }
}
