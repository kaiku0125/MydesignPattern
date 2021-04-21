package GameProject.Game;

import java.util.logging.Logger;
import java.util.Timer;

public class DailyClock extends ClockTask {
    private Logger logger = Logger.getLogger(DailyClock.class.getName());
    Timer dailyTimer;
    private boolean finish = false;
    Thread thread;

    public DailyClock(ModelInterface model) {
        super(model);
        this.dailyTimer = new Timer();
    }

    @Override
    public void run() {
        if (!finish) {
            minusSecond();
            model.notifyDailyClockObserver();
            if (second == -1) {
                if (minute == 0) {
                    try {
                        logger.info("daily分秒皆0");
                        second = 0;
                        finish = true;
                        dailyTimer.cancel();
                        model.notifyDailyClockObserver();
                        return;
                    } catch (Exception e) {
                        logger.warning("minute == 0 error!");
                    }
                }
                second = 59;
                minusMinute();
                model.notifyDailyClockObserver();
            }
        }

    }

    @Override
    protected Timer getTimer() {
        return dailyTimer;
    }

    @Override
    protected void again() {
        finish = false;
        this.dailyTimer = new Timer();
        model.notifyDailyClockObserver();
    }

    @Override
    protected boolean isfinish() {
        return this.finish;
    }

}
