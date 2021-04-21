package Mediator_Pattern;

public abstract class AbstractUser {
    String name;

    protected String getname() {
        return name;
    }

    abstract void send(String msg);

    abstract void receive(String msg);

}
