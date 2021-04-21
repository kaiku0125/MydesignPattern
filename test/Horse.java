package test;

public class Horse extends Thread {
    public void run() {
       try {
        System.out.println(getName() + "到達終點");
       } catch (Exception e) {
        System.out.println("被中斷了");
       }
    }
}  