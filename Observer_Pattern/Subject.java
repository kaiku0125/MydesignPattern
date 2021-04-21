package Observer_Pattern;



public interface Subject {

    public void registerOb(Observer o);
    public void removeOb(Observer o);
    public void notifyOb();

}
