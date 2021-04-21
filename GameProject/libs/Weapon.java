package GameProject.libs;

public class Weapon {
    private String name;
    private int level;

    public Weapon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLeveltext() {
        return "+" + String.valueOf(level);
    }

    public int getLevel() {
        return level;
    }

    public void setlevel(int level) {
        this.level = level;
    }
}
