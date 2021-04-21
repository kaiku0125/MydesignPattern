package Singleton_Pattern;

public class Singleton_Pattern {
    public static void main(String[] args) {
        Lazy_Singleton lazy_Singleton = Lazy_Singleton.getobj();
        Lazy_Singleton ly = Lazy_Singleton.getobj();
        Threads_Singleton thread = Threads_Singleton.getobj();
        Threads_Singleton thread2 = Threads_Singleton.getobj();
        Static_Singleton stat1 = Static_Singleton.getobj();
        Static_Singleton stat2 = Static_Singleton.getobj();
    }
    
}
