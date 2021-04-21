package FlyWeight_Pattern;

public class InfinityGems implements Gem {
    private String color;
    private static String colors[] = { "Green", "Orange", "Purple", "Blue", "Yellow", "Red" };

    public InfinityGems(String color) {
        this.color = color;
    }

    @Override
    public void power() {
        System.out.println("使用" + color + "寶石的能力");
    }

    public static String randomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

}
