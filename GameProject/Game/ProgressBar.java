package GameProject.Game;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JProgressBar;

public class ProgressBar {
    ExecutorService agent;
    ControllerMainInterface controller;
    JProgressBar jProgressBar;
    static boolean enhanceRunning;
    static boolean alchemyRunning;

    public ProgressBar(JProgressBar jProgressBar, ControllerMainInterface controller) {
        this.jProgressBar = jProgressBar;
        this.controller = controller;
    }

    public void runEnhance() {
        agent = Executors.newSingleThreadExecutor();
        agent.execute(new Runnable() {

            @Override
            public void run() {
                enhanceRunning = true;
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(25);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    jProgressBar.setValue(i);
                }
                try {
                    controller.getEnhanceResult();
                    Thread.sleep(2000);
                    jProgressBar.setString("");
                    jProgressBar.setValue(0);
                    enhanceRunning = false;
                    controller.enhanceProgressEnd();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        agent.shutdown();
    }

    public void runAlchemy() {
        agent = Executors.newSingleThreadExecutor();
        agent.execute(new Runnable() {

            @Override
            public void run() {
                alchemyRunning = true;
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(25);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    jProgressBar.setValue(i);
                }
                try {
                    jProgressBar.setString("煉金成功");
                    Thread.sleep(2000);
                    jProgressBar.setString("");
                    jProgressBar.setValue(0);
                    alchemyRunning = false;
                    controller.alchemyProgressEnd();
                    controller.getAlchemyResult();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
        agent.shutdown();
    }

}
