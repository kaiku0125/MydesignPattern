package GameProject.Game;

public class GameDrive {
    public static void main(String[] args) {
        ModelInterface model = new Model();
        ControllerMainInterface controller = new ControllerMain(model);
    }
}
