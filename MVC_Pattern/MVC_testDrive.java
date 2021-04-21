package MVC_Pattern;

public class MVC_testDrive {
    public static void main(String[] args) {
        ModelInterface model = new Model();
        ControllerInterface controller = new Controller(model);
    }
}
