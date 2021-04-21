package Singleton_Pattern;

public class Lazy_Singleton {

    private static Lazy_Singleton obj ;

    private Lazy_Singleton(){

    }

    public static Lazy_Singleton getobj(){
        if (obj == null){
            obj = new Lazy_Singleton();
            System.out.println("初始化物件...");
        }
        else{
            System.out.println("已經有此物件");
        }
        return obj;
    }
    
}
