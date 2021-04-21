package FlyWeight_Pattern;

public class TestDrive {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Gem gem = GemFactory.getGem(InfinityGems.randomColor());
            gem.power();
        }
    }
}
