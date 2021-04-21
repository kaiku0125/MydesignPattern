package GameProject.Game;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import GameProject.Game.Rate.BounsItem;
import GameProject.Game.Rate.Result;

public class ControllerMain implements ControllerMainInterface {
    private static Logger logger = Logger.getLogger(ControllerMain.class.getName());
    ModelInterface model;
    JProgressBar jProgressBar;
    ProgressBar progress;
    ViewLogin viewlogin;
    ViewMain viewMain;
    BounsItem bonus;
    Result result;
    int tempcoin, tempstone;
    int dailySecond, dailyMinute;
    StringBuilder sb;

    public ControllerMain(ModelInterface model) {
        this.model = model;
        ViewLogin viewlogin = new ViewLogin(this, model);
        ViewMain viewMain = new ViewMain(this, model);
        this.viewlogin = viewlogin;
        this.viewMain = viewMain;
        viewlogin.createLoginView();
    }

    @Override
    public void login() {
        viewlogin.enableLoginFrame(false);
        viewMain.createMainView();
        viewMain.createControls();
        model.on();
    }

    @Override
    public void stop() {
        model.off();
    }

    @Override
    public void minusCoin(int coin) {
        tempcoin = model.getCoin();
        tempcoin -= coin;
        model.setCoin(tempcoin);
    }

    public void plusCoin(int coin) {
        tempcoin = model.getCoin();
        tempcoin += coin;
        model.setCoin(tempcoin);
    }

    @Override
    public boolean coinchecker(int coin) {
        int i = model.getCoin();
        i = i - coin;
        if (i < 0) {
            logger.warning("coin < 0");
            return false;
        }
        return true;
    }

    @Override
    public void minusStone(int stone) {
        tempstone = model.getStone();
        tempstone -= stone;
        model.setStone(tempstone);
    }

    public void plusStone(int stone) {
        tempstone = model.getStone();
        tempstone += stone;
        model.setStone(tempstone);
    }

    @Override
    public boolean stoneChecker(int stone) {
        int i = model.getStone();
        i = i - stone;
        if (i < 0) {
            logger.warning("stone < 0");
            return false;
        }
        return true;
    }

    @Override
    public boolean bananChecker(int banana) {
        int i = model.getBanana();
        i = i - banana;
        if (i < 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean appleChecker(int apple) {
        int i = model.getApple();
        i = i - apple;
        if (i < 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean orangeChecker(int orange) {
        int i = model.getOrange();
        i = i - orange;
        if (i < 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean melonChecker(int melon) {
        int i = model.getMelon();
        i = i - melon;
        if (i < 0) {
            return false;
        }
        return true;
    }

    @Override
    public void enhanceStart() {
        viewMain.visibleProgressbar(true);
        viewMain.enableEnhanceBtn(false);
    }

    @Override
    public void enhanceEnd() {
        viewMain.visibleProgressbar(false);
        viewMain.enableEnhanceBtn(true);
    }

    @Override
    public void setDailybtnEnable(boolean b) {
        viewMain.enableDailybtn(b);
    }

    @Override
    public void dailystart() {
        model.restartDailyTimer();
    }

    @Override
    public void getdailyBouns() {
        SimpleDateFormat form = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String msg = form.format(date);
        bonus = Rate.getDailyBouns();
        switch (bonus) {
        case STONE:
            plusStone(5);
            viewMain.setdescription(msg + ", get 5 Stone");
            break;

        case COIN:
            plusCoin(5000);
            viewMain.setdescription(msg + ", get 5000 coin");
            break;

        default:
            break;
        }
    }

    @Override
    public void getEnhanceResult() {
        SimpleDateFormat form = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String msg = form.format(date);
        result = Rate.getEnhanceResult();
        switch (result) {
        case SUCCESS:
            jProgressBar.setString("強化成功");
            viewMain.setdescription(msg + ", enhance Success");
            model.setCurrentLevel(model.getCurrentLevel() + 1);
            break;

        case FAIL:
            jProgressBar.setString("強化失敗");
            viewMain.setdescription(msg + ", enhance Fail");
            model.setCurrentLevel(model.getCurrentLevel() - 1);
            break;

        default:
            break;
        }
    }

    @Override
    public void enhanceThread(JProgressBar jProgressBar) {
        this.jProgressBar = jProgressBar;
        progress = new ProgressBar(jProgressBar, this);
        progress.runEnhance();
    }

    @Override
    public boolean isEnhanceRunning() {
        return ProgressBar.enhanceRunning;
    }

    @Override
    public void enhanceProgressEnd() {
        model.enhanceProgressListener();
    }

    public void alchemyThread(JProgressBar jProgressBar) {
        this.jProgressBar = jProgressBar;
        progress = new ProgressBar(jProgressBar, this);
        progress.runAlchemy();
    }

    @Override
    public boolean isAlchemyRunning() {
        return ProgressBar.alchemyRunning;
    }

    @Override
    public void alchemyProgressEnd() {
        model.alchemyProgressListener();
    }

    @Override
    public void alchemyMinus(int banana, int apple, int orange, int melon) {
        int e = model.getBanana();
        model.setBanana(e - banana);
        e = model.getApple();
        model.setApple(e - apple);
        e = model.getOrange();
        model.setOrange(e - orange);
        e = model.getMelon();
        model.setMelon(e - orange);
    }

    @Override
    public void getAlchemyResult() {
        SimpleDateFormat form = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String msg = form.format(date);
        result = Rate.getEnhanceResult();
        sb = new StringBuilder();
        sb.append(String.valueOf(viewMain.getBananaCombo()));
        sb.append(String.valueOf(viewMain.getAppleCombo()));
        sb.append(String.valueOf(viewMain.getOrangeCombo()));
        sb.append(String.valueOf(viewMain.getMelonCombo()));
        System.out.println(sb);
        switch (sb.toString()) {
        case "0010":
            plusStone(1);
            viewMain.setdescription(msg + ", Alchemy result : gstone +1");
            break;
        }
    }

}
