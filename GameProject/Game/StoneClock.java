package GameProject.Game;

import java.util.logging.Logger;
import java.util.Timer;

public class StoneClock extends ClockTask {
    private Logger logger = Logger.getLogger(StoneClock.class.getName());
    Timer stoneTimer;
    private boolean finish = false;
    Thread thread;

    public StoneClock(ModelInterface model) {
        super(model);
        this.stoneTimer = new Timer();
    }

    @Override
    public void run() {
        if (!finish) {
            minusSecond();
            model.notifyStoneClockObserver();
            if (second == -1) {
                if (minute == 0) {
                    try {
                        logger.info("stone分秒皆0");
                        finish = true;
                        stoneTimer.cancel();
                        int stone = model.getStone();
                        stone++;
                        model.setStone(stone);
                        again();
                    } catch (Exception e) {
                        logger.warning("minute == 0 error!");
                    }
                }
                second = 59;
                minusMinute();
                model.notifyStoneClockObserver();
            }
        }
    }

    @Override
    protected Timer getTimer() {
        return stoneTimer;
    }

    @Override
    protected void again() {
        model.notifyStoneClockObserver();
        // model.updateStoneClock();
        this.stoneTimer = new Timer();
        finish = false;
        model.restartStoneTimer();
    }

    @Override
    protected boolean isfinish() {
        return this.finish;
    }

}
