package GameProject.Game;

import javax.swing.JProgressBar;

public interface ControllerMainInterface {
    void login();

    void stop();

    void minusCoin(int coin);

    boolean coinchecker(int coin);

    void minusStone(int stone);

    boolean stoneChecker(int stone);

    boolean bananChecker(int banana);

    boolean appleChecker(int apple);

    boolean orangeChecker(int orange);

    boolean melonChecker(int melon);

    void enhanceStart();

    void enhanceEnd();

    void setDailybtnEnable(boolean b);

    void dailystart();

    void getdailyBouns();

    void getEnhanceResult();

    void enhanceThread(JProgressBar jProgressBar);

    boolean isEnhanceRunning();

    void enhanceProgressEnd();

    void alchemyThread(JProgressBar jProgressBar);

    boolean isAlchemyRunning();

    void alchemyProgressEnd();

    void alchemyMinus(int banana, int apple, int orange, int melon);

    void getAlchemyResult();
}
