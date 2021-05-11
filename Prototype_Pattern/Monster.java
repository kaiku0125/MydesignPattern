package Prototype_Pattern;

public class Monster extends GameObject {
    public Monster() {
        type = "Monster";
    }

    @Override
    void ability() {
        System.out.println("Do monster's ability");
    }

}
