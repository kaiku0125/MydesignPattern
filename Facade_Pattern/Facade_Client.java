package Facade_Pattern;

public class Facade_Client {
    

	public static void main(String[] args) {
        
        Ignite ignite = new Ignite();
        Brake brake = new Brake();
        Accelerator accelerator = new Accelerator();
        Clutch clutch = new Clutch();
        Gear gear = new Gear("換檔");

        Motorcycle Scooter = new Motorcycle(ignite,brake,accelerator,clutch,gear);
        System.out.println("kevin想啟動車輛...");
        Scooter.startup();
        System.out.println("---------------------");
        System.out.println("kevin轉動油門加速...");
        Scooter.SpeedUp();
        System.out.println("---------------------");
        System.out.println("kevin想繼續加速...");
        Scooter.SpeedUp();
        System.out.println("---------------------");
        System.out.println("前方入彎,kevin想減速...");
        Scooter.SlowDown();
    }
    
}
