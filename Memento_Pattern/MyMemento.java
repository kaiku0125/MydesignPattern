package Memento_Pattern;

public class MyMemento {
    private int gameHp;
    private int gameExp;

    public MyMemento(int hp, int exp) {
        this.gameHp = hp;
        this.gameExp = exp;
    }

    public int getGameHp() {
        return gameHp;
    }

    public int getGameExp() {
        return gameExp;
    }
}
