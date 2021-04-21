package Observer_Pattern;

public class Oberver_Pattern {

    private static int HP = 100;
    private static int MP = 100;

    public static void main(String[] args) {

        PlayerData pd = new PlayerData();
        Player1 kevin = new Player1(pd);

        System.out.println("原本血量：" + HP + "  原本魔力:" + MP);
        System.out.println("-----------");
        pd.setMeasurement(50, 50);
        System.out.println("當前血量："+pd.getHP()+"  當前魔力:"+pd.getMP());

        System.out.println("-----------");
        pd.setMeasurement(50, 10);
        System.out.println("當前血量："+pd.getHP()+"  當前魔力:"+pd.getMP());
    
        System.out.println("-----------");
        pd.setMeasurement(10, 50);
        System.out.println("當前血量："+pd.getHP()+"  當前魔力:"+pd.getMP());
        
        System.out.println("-----------");
        pd.setMeasurement(10, 10);
        System.out.println("當前血量："+pd.getHP()+"  當前魔力:"+pd.getMP());
    

    }

    
    
}
