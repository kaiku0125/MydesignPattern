package testProxy;

public class ClientMonitor {
    MyRemote myremote;

    public ClientMonitor(MyRemote myRemote){
        this.myremote = myRemote;
    }
    public void report(){
        try {
            System.out.print("test : ");
            myremote.printMsg();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
