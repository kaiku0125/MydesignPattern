package Singleton_Pattern;

public class Static_Singleton {
    private static Static_Singleton obj = new Static_Singleton();

    private Static_Singleton(){

    }

    public static Static_Singleton getobj(){
        System.out.println("物件已建立，可直接使用");
        return obj;
    }
    
}
