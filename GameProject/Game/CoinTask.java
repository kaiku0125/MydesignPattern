package GameProject.Game;

import java.util.TimerTask;

public class CoinTask extends TimerTask {
    ModelInterface model;

    public CoinTask(ModelInterface model) {
        this.model = model;

    }

    @Override
    public void run() {
        Model.coin = Model.coin + 1;
        model.notifyCoinObserver();
        // System.out.println("Coin :" + Model.coin);
    }

}
