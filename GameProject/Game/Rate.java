package GameProject.Game;

import java.util.Random;

public class Rate {
    ModelInterface model;
    static int[] rate;

    enum BounsItem {
        STONE, COIN
    }

    enum Result {
        SUCCESS, FAIL
    }

    public Rate(ModelInterface model) {
        this.model = model;
    }

    public static void setRate(int[] rate) {
        Rate.rate = rate;
    }

    public static BounsItem getDailyBouns() {
        int[] rate = { 40, 60 };
        setRate(rate);
        int total = 0;
        for (int i = 0; i < rate.length; i++) {
            total += rate[i];
        }
        Random r = new Random();
        int randomInt = r.nextInt(total);
        System.out.println("此次機率為 : " + randomInt);
        for (int i = 0; i < rate.length; i++) {
            randomInt = randomInt - rate[i];
            if (randomInt < 0) {
                return BounsItem.values()[i];
            }
        }
        return null;
    }

    public static Result getEnhanceResult() {
        rate = new int[] { 70, 30 };
        int total = 0;
        for (int i = 0; i < rate.length; i++) {
            total += rate[i];
        }
        Random r = new Random();
        int randomInt = r.nextInt(total);
        System.out.println("此次機率為 : " + randomInt);
        for (int i = 0; i < rate.length; i++) {
            randomInt = randomInt - rate[i];
            if (randomInt < 0) {
                return Result.values()[i];
            }
        }
        return null;
    }

}
