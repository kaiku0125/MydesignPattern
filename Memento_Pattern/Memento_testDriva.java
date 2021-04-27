package Memento_Pattern;

public class Memento_testDriva {
    public static void main(String[] args) {
        GamePlayer player = new GamePlayer(100, 0);

        CareTaker careTaker = new CareTaker();

        player.playing(10, 20);
        // 存檔
        careTaker.setMemento(player.saveToMemento());

        // 打王死掉
        player.playing(100, 70);

        // 回到進度點
        player.restoreFromMemento(careTaker.getMemento());
        System.out.println(player.getHp());
    }
}
