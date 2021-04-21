package MVC_Pattern;

public class Controller implements ControllerInterface {
    ModelInterface model;
    View view;
    State state;

    public Controller(ModelInterface model) {
        this.model = model;
        View view = new View(this, model);
        this.view = view;
        view.createView();
        view.createControls();
        view.enableStartMenuItem();
        view.disableStopMenuItem();
        view.enableCombobox(false);
        view.enablebtn(false);
    }

    @Override
    public void start() {
        System.out.println("按下啟動");
        model.on();
        System.out.println("model.on..");
        view.disableStartMenuItem();
        view.enableStopMenuItem();
        view.enableCombobox(true);
    }

    @Override
    public void stop() {
        model.off();
        view.setcomboboxNULL();
        view.enableStartMenuItem();
        view.disableStopMenuItem();
        view.enableCombobox(false);
    }

    @Override
    public void increaseTemp() {
        int temp = model.getTemperature();
        if (temp < 45) {
            temp += 1;
        } else {
            return;
        }
        model.setTemperature(temp);
    }

    @Override
    public void decreaseTemp() {
        int temp = model.getTemperature();
        if (temp > 35) {
            temp -= 1;
        } else {
            return;
        }
        model.setTemperature(temp);
    }

    @Override
    public void changeHighState() {
        model.setState(model.getHighYieldState());
    }

    @Override
    public void changeLowState() {
        model.setState(model.getLowYieldState());
    }

    @Override
    public void changenoState() {
        model.setState(model.getNOState());

    }
}
