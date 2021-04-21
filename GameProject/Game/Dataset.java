package GameProject.Game;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class Dataset {
    private static Logger logger = Logger.getLogger(Dataset.class.getName());
    ArrayList<String> allClock = new ArrayList<String>();
    ArrayList<String> weaponLevel = new ArrayList<String>();
    HashMap<String, Integer> allElement = new HashMap<String, Integer>();
    ModelInterface model;
    BufferedReader reader = null;
    FileWriter fw = null;
    int tempcoin, count, tempStone;
    String UserID, temp;

    public Dataset(ModelInterface model) {
        this.model = model;
    }

    public void readcoin() {
        try {
            reader = new BufferedReader(new FileReader("GameProject//res//Coin.txt"));
            String temp = reader.readLine();
            tempcoin = model.getCoin();
            tempcoin = Integer.valueOf(temp);
            model.setCoin(tempcoin);
            logger.info("Read Coin :" + String.valueOf(tempcoin));
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void savecoin() {
        try {
            fw = new FileWriter("GameProject//res//Coin.txt");
            tempcoin = model.getCoin();
            fw.write(String.valueOf(tempcoin));
            logger.info("Save coin : " + String.valueOf(tempcoin));
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkUserID() {
        try {
            reader = new BufferedReader(new FileReader("GameProject//res//UserID.txt"));
            String tempPassword = reader.readLine();
            UserID = tempPassword;
            reader.close();
        } catch (Exception e) {
            System.out.println("cant login");
        }
    }

    public String getPassword() {
        return UserID;
    }

    public void readClock() {
        try {
            reader = new BufferedReader(new FileReader("GameProject//res//Clock.txt"));
            while ((temp = reader.readLine()) != null) {
                String[] s = temp.split(",");
                allClock.add(s[0]);
                allClock.add(s[1]);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveClock() {
        try {
            fw = new FileWriter("GameProject//res//Clock.txt");
            allClock.set(1, model.getStoneClock().getSecond());
            allClock.set(0, model.getStoneClock().getMinute());
            allClock.set(3, model.getDailyClock().getSecond());
            allClock.set(2, model.getDailyClock().getMinute());
            for (int i = 0; i < allClock.size(); i = i + 2) {
                fw.write(allClock.get(i) + "," + allClock.get(i + 1) + "\n");
            }
            for (int i = 0; i < allClock.size(); i++) {
                String print = allClock.get(i);
                System.out.print(print + ",");
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getClockindex(int index) {
        return Integer.parseInt(allClock.get(index));
    }

    public void readWeaponLevel() {
        try {
            reader = new BufferedReader(new FileReader("GameProject//res//Weapon.txt"));
            temp = reader.readLine();
            String[] s = temp.split(",");
            weaponLevel.add(s[0]);
            weaponLevel.add(s[1]);
            model.setSwordLevel(Integer.parseInt(s[0]));
            model.setBowLevel(Integer.parseInt(s[1]));
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveWeaponLevel() {
        try {
            fw = new FileWriter("GameProject//res//Weapon.txt");
            weaponLevel.set(0, String.valueOf(model.getSwordLevel()));
            weaponLevel.set(1, String.valueOf(model.getBowLevel()));
            fw.write(weaponLevel.get(0) + "," + weaponLevel.get(1));
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getWeaponLevelindex(int index) {
        return Integer.parseInt(weaponLevel.get(index));
    }

    public void readElement() {
        try {
            reader = new BufferedReader(new FileReader("GameProject//res//Element.txt"));
            temp = reader.readLine();
            String[] s = temp.split(",");
            allElement.put("element1", Integer.parseInt(s[0]));
            allElement.put("element2", Integer.parseInt(s[1]));
            allElement.put("element3", Integer.parseInt(s[2]));
            allElement.put("element4", Integer.parseInt(s[3]));
            model.setBanana(allElement.get("element1"));
            model.setApple(allElement.get("element2"));
            model.setOrange(allElement.get("element3"));
            model.setMelon(allElement.get("element4"));
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveElement() {
        try {
            fw = new FileWriter("GameProject//res//Element.txt");
            allElement.put("element1", model.getBanana());
            allElement.put("element2", model.getApple());
            allElement.put("element3", model.getOrange());
            allElement.put("element4", model.getMelon());
            fw.write(allElement.get("element1") + "," + allElement.get("element2") + "," + allElement.get("element3")
                    + "," + allElement.get("element4"));
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readStone() {
        try {
            reader = new BufferedReader(new FileReader("GameProject//res//Stone.txt"));
            temp = reader.readLine();
            tempStone = model.getStone();
            tempStone = Integer.parseInt(temp);
            logger.info("Read stone : " + String.valueOf(tempStone));
            model.setStone(tempStone);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveStone() {
        try {
            fw = new FileWriter("GameProject//res//Stone.txt");
            tempStone = model.getStone();
            fw.write(String.valueOf(tempStone));
            logger.info("Save stone : " + String.valueOf(tempStone));
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
