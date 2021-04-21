package Facade_Pattern;

public class Motorcycle {
    Ignite ignite;
    Brake brake;
    Accelerator accelerator;
    Clutch clutch;
    Gear gear;
    
    public Motorcycle(Ignite ignite, 
                    Brake brake,
                    Accelerator accelerator,
                    Clutch clutch,
                    Gear gear){
        this.ignite = ignite;
        this.brake = brake;
        this.accelerator = accelerator;
        this.clutch = clutch;
        this.gear = gear;
    }

    public void startup(){
        brake.pullBrake();
        ignite.start();
        System.out.println("現在檔位:"+ Gear.defaultgear);
    }
    public void SpeedUp(){
        accelerator.accelerate_off();
        clutch.Clutch_pull();
        gear.shiftgearUp();
        clutch.Clutch_release();
        accelerator.accelerate_throttle();
    }
    public void SlowDown(){
        accelerator.accelerate_off();
        clutch.Clutch_pull();
        gear.shiftgearDown();
        clutch.Clutch_release();
        accelerator.accelerate_little();
    }

}
