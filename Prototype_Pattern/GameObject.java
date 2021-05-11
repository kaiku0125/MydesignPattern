package Prototype_Pattern;

public abstract class GameObject implements Cloneable {
    protected int id;
    protected String type;

    abstract void ability();

    public String getType() {
        return type;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clone;
    }
}
