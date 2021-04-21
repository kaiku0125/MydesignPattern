package Facade_Pattern;

public class Gear {
    public final static String defaultgear = "N";
    public static int gear = 0;
    String description;

    public Gear(String description){
        this.description = description;
    }

    public void shiftgearUp(){
        gear = gear + 1;
        System.out.println( description + "現在檔位:" + gear);
        
    }
    public void shiftgearDown(){
        gear = gear - 1;
        if(gear == 0){
            System.out.println(description + "現在檔位:" + defaultgear);
        }
        else{
            System.out.println(description +"現在檔位:" + gear);
        }
    }
    public String toString(){
        return description;
    }
}
