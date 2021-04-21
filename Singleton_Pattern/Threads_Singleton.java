package Singleton_Pattern;

public class Threads_Singleton {
    private static Threads_Singleton obj = null;

    private Threads_Singleton(){

    }

    public static Threads_Singleton getobj(){
        if (obj == null){
            synchronized(Threads_Singleton.class){
                if (obj == null){
                    obj = new Threads_Singleton();
                    System.out.println("多執行緒..初始化物件...");
                }               
            }    
        }
        else{
            System.out.println("多執行緒...已經有此物件");
        }
        return obj;
    }
        
}
