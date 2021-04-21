package GameProject.Game;

public interface ModelInterface {
    void on();

    void off();

    void initData();

    void initWeapon();

    void checkID();

    String getpassword();

    void coincounter();

    int getCoin();

    void setCoin(int coin);

    void saveData();

    void initStoneTimer();

    void restartStoneTimer();

    void initDailyTimer();

    void restartDailyTimer();

    boolean isDailyfinish();

    ClockTask getStoneClock();

    ClockTask getDailyClock();

    void registerCoinObserver(CoinObserver o);

    void removeCoinObserver(CoinObserver o);

    void notifyCoinObserver();

    void registerClockObserver(ClockObserver o);

    void removeClockObserver(ClockObserver o);

    void notifyStoneClockObserver();

    void notifyDailyClockObserver();

    String getStoneSecond();

    String getStoneMinute();

    String getDailySecond();

    String getDailyMinute();

    void setStone(int stone);

    int getStone();

    void stoneListener();

    void enhanceProgressListener();

    void alchemyProgressListener();

    void bananaListener(int num);

    void appleListener();

    void orangeListener();

    void melonListener();

    void regStoneCallback(Callback callback);

    int getBanana();

    void setBanana(int num);

    int getApple();

    void setApple(int num);

    int getOrange();

    void setOrange(int num);

    int getMelon();

    void setMelon(int num);

    int getSwordLevel();

    void setSwordLevel(int level);

    int getBowLevel();

    void setBowLevel(int level);

    int getCurrentLevel();

    void setCurrentLevel(int level);

}
