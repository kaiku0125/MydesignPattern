package MVC_Pattern;

import javax.swing.Icon;

public interface ModelInterface {
    Icon initImage();
    void on();
    void off();
    void registerObserver(TemperatureObserver o);
    void removeObserver(TemperatureObserver o);
    public void notifyObserver();
    void setTemperature(int temperature);
    int getTemperature();
    boolean isStoppable();
    public void setState(State state);
    public State getState();
    public State getHighYieldState();
    public State getLowYieldState();
    public State getNOState();
    
}
