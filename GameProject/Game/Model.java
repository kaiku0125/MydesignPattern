package GameProject.Game;

import java.util.*;
import java.util.logging.Logger;

public class Model implements ModelInterface {
    private static Logger logger = Logger.getLogger(Model.class.getName());
    ArrayList<CoinObserver> coinObservers = new ArrayList<CoinObserver>();
    ArrayList<ClockObserver> clockObservers = new ArrayList<ClockObserver>();
    Dataset dataset;
    Callback callback;
    ClockTask stoneTask, dailyTask;
    String password = null;
    public static int coin;
    public int stone = 0;
    boolean ismain = false;
    int banana, apple, orange, melon;
    int swordLevel, bowLevel, currentLevel;

    public Model() {
        dataset = new Dataset(this);
    }

    @Override
    public void on() {
        ismain = true;
        initData();
        coincounter();
        startallTimer();
    }

    @Override
    public void off() {
        saveData();
    }

    public void startallTimer() {
        initDailyTimer();
        initStoneTimer();
    }

    @Override
    public void initData() {
        dataset.readcoin();
        dataset.readStone();
        dataset.readClock();
        dataset.readElement();
    }

    @Override
    public void initWeapon() {
        dataset.readWeaponLevel();
    }

    @Override
    public void checkID() {
        dataset.checkUserID();
        password = dataset.getPassword();
    }

    @Override
    public String getpassword() {
        return password;
    }

    @Override
    public void coincounter() {
        Timer cointimer = new Timer();
        cointimer.schedule(new CoinTask(this), 0, 333);
    }

    @Override
    public int getCoin() {
        return coin;
    }

    @Override
    public void setCoin(int coin) {
        Model.coin = coin;
        notifyCoinObserver();
    }

    @Override
    public void saveData() {
        dataset.savecoin();
        dataset.saveStone();
        dataset.saveClock();
        dataset.saveElement();
        dataset.saveWeaponLevel();
    }

    @Override
    public void initStoneTimer() {
        stoneTask = new StoneClock(this);
        stoneTask.setMinute(dataset.getClockindex(0));
        stoneTask.setSecond(dataset.getClockindex(1));
        stoneTask.getTimer().scheduleAtFixedRate(stoneTask, 0, 1000);

    }

    @Override
    public void restartStoneTimer() {
        stoneTask = new StoneClock(this);
        stoneTask.setMinute(1);
        stoneTask.setSecond(1);
        stoneTask.getTimer().scheduleAtFixedRate(stoneTask, 0, 1000);
    }

    @Override
    public void initDailyTimer() {
        dailyTask = new DailyClock(this);
        dailyTask.setMinute(dataset.getClockindex(2));
        dailyTask.setSecond(dataset.getClockindex(3));
        dailyTask.getTimer().scheduleAtFixedRate(dailyTask, 0, 1000);
    }

    @Override
    public void restartDailyTimer() {
        dailyTask.again();
        dailyTask = new DailyClock(this);
        dailyTask.setMinute(1);
        dailyTask.setSecond(1);
        dailyTask.getTimer().scheduleAtFixedRate(dailyTask, 0, 1000);
    }

    @Override
    public boolean isDailyfinish() {
        // logger.info(String.valueOf(dailyTask.isfinish()));
        return dailyTask.isfinish();
    }

    @Override
    public ClockTask getDailyClock() {
        return dailyTask;
    }

    @Override
    public ClockTask getStoneClock() {
        return stoneTask;
    }

    @Override
    public void registerCoinObserver(CoinObserver o) {
        coinObservers.add(o);
    }

    @Override
    public void removeCoinObserver(CoinObserver o) {
        int index = coinObservers.indexOf(o);
        coinObservers.remove(index);
    }

    @Override
    public void notifyCoinObserver() {
        for (int i = 0; i < coinObservers.size(); i++) {
            CoinObserver observers = coinObservers.get(i);
            observers.updateCoin();
        }
    }

    @Override
    public void registerClockObserver(ClockObserver o) {
        clockObservers.add(o);

    }

    @Override
    public void removeClockObserver(ClockObserver o) {
        int index = clockObservers.indexOf(o);
        clockObservers.remove(index);
    }

    @Override
    public void notifyStoneClockObserver() {
        for (int i = 0; i < clockObservers.size(); i++) {
            ClockObserver observers = clockObservers.get(i);
            observers.updateStoneClock();
        }
    }

    @Override
    public void notifyDailyClockObserver() {
        for (int i = 0; i < clockObservers.size(); i++) {
            ClockObserver observers = clockObservers.get(i);
            observers.updateDailyClock();
        }
    }

    @Override
    public String getStoneSecond() {
        return stoneTask.dsecond;
    }

    @Override
    public String getStoneMinute() {
        return stoneTask.dminute;
    }

    @Override
    public String getDailySecond() {
        return dailyTask.dsecond;
    }

    @Override
    public String getDailyMinute() {
        return dailyTask.dminute;
    }

    @Override
    public void setStone(int stone) {
        this.stone = stone;
        stoneListener();
    }

    @Override
    public int getStone() {
        return stone;
    }

    @Override
    public void stoneListener() {
        callback.updateStone();
    }

    @Override
    public void enhanceProgressListener() {
        callback.enhanceProgressEnd();
    }

    @Override
    public void alchemyProgressListener() {
        callback.alchemyProgressEnd();
    }

    @Override
    public void bananaListener(int num) {
        callback.updateBanana(banana);

    }

    @Override
    public void appleListener() {
        callback.updateApple();
    }

    @Override
    public void orangeListener() {
        callback.updateOrange();
    }

    @Override
    public void melonListener() {
        callback.updateMelon();
    }

    @Override
    public void regStoneCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public int getBanana() {
        return banana;
    }

    @Override
    public void setBanana(int num) {
        this.banana = num;
        bananaListener(banana);
    }

    @Override
    public int getApple() {
        return apple;
    }

    @Override
    public void setApple(int num) {
        this.apple = num;
        appleListener();
    }

    @Override
    public int getOrange() {
        return orange;
    }

    @Override
    public void setOrange(int num) {
        this.orange = num;
        orangeListener();
    }

    @Override
    public int getMelon() {
        return melon;
    }

    @Override
    public void setMelon(int num) {
        this.melon = num;
        melonListener();
    }

    @Override
    public int getSwordLevel() {
        return swordLevel;
    }

    @Override
    public void setSwordLevel(int level) {
        this.swordLevel = level;
    }

    @Override
    public int getBowLevel() {
        return bowLevel;
    }

    @Override
    public void setBowLevel(int level) {
        this.bowLevel = level;
    }

    @Override
    public int getCurrentLevel() {
        return currentLevel;
    }

    @Override
    public void setCurrentLevel(int level) {
        this.currentLevel = level;
    }
}
