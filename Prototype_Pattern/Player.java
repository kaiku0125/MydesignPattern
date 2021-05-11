package Prototype_Pattern;

public class Player extends GameObject {
    public Player() {
        type = "Player";
    }

    @Override
    void ability() {
        System.out.println("Do player's ability");
    }
}
