package MVC_Pattern;

import java.util.ArrayList;

import javax.swing.Icon;

public class Model implements ModelInterface, State {
    ArrayList<TemperatureObserver> temperatureObservers = new ArrayList<TemperatureObserver>();
    public int temperature = 37;
    public boolean stoppable;
    Icon shower, bath;
    State high, low, no, state;

    @Override
    public Icon initImage() {
        return state.initImage();
    }

    @Override
    public void on() {
        stoppable = false;
        high = new HighWaterYield();
        low = new LowWaterYield();
        no = new NullState();
        notifyObserver();
    }

    @Override
    public void off() {
        state = no;
        stoppable = true;
        notifyObserver();
    }

    @Override
    public void registerObserver(TemperatureObserver o) {
        temperatureObservers.add(o);
    }

    @Override
    public void removeObserver(TemperatureObserver o) {
        int i = temperatureObservers.indexOf(o);
        temperatureObservers.remove(i);
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < temperatureObservers.size(); i++) {
            TemperatureObserver observer = temperatureObservers.get(i);
            observer.updataTemperature();
        }
    }

    @Override
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObserver();
    }

    @Override
    public int getTemperature() {
        return temperature;
    }

    @Override
    public boolean isStoppable() {
        return stoppable;
    }

    @Override
    public String setwaterYield() {
        return state.setwaterYield();
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public State getHighYieldState() {
        return high;
    }

    @Override
    public State getLowYieldState() {
        return low;
    }

    @Override
    public State getNOState() {
        return no;
    }

    @Override
    public State getState() {
        return state;
    }
}
