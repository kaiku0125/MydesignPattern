package GameProject.Game;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

public abstract class ClockTask extends TimerTask {
    ModelInterface model;
    protected int second = 0;
    protected int minute = 0;
    protected String dsecond, dminute;
    protected boolean finish;
    DecimalFormat dFormat = new DecimalFormat("00");

    public ClockTask(ModelInterface model) {
        this.model = model;
    }

    protected void setSecond(int second) {
        this.second = second;
    }

    protected void setMinute(int minute) {
        this.minute = minute;
    }

    protected void minusSecond() {
        second--;
        dsecond = dFormat.format(second);
        dminute = dFormat.format(minute);
    }

    protected void minusMinute() {
        minute--;
        dsecond = dFormat.format(second);
        dminute = dFormat.format(minute);
    }

    protected abstract Timer getTimer();

    protected abstract void again();

    protected abstract boolean isfinish();

    public String getSecond() {
        return String.valueOf(second);
    }

    public String getMinute() {
        return String.valueOf(minute);
    }

}
