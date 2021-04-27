package Memento_Pattern;

public class GamePlayer {
    private int mHp;
    private int mExp;

    public GamePlayer(int hp, int exp) {
        this.mHp = hp;
        this.mExp = exp;
    }

    public MyMemento saveToMemento() {
        return new MyMemento(mHp, mExp);
    }

    public void restoreFromMemento(MyMemento memento) {
        mHp = memento.getGameHp();
        mExp = memento.getGameExp();
    }

    public void playing(int hp, int exp) {
        mHp -= hp;
        mExp += exp;
    }

    public int getHp() {
        return mHp;
    }

}
