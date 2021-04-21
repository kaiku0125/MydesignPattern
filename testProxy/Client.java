
package testProxy;
import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;
import java.io.*;
import java.rmi.Naming;

// public class Client {
//     public static void main(String[] args) {
//         try {  
//             // Getting the registry 
//             Registry registry = LocateRegistry.getRegistry(null); 

//             // Looking up the registry for the remote object 
//             MyRemote stub = (MyRemote) registry.lookup("Hello"); 

//             // Calling the remote method using the obtained object 
//             stub.printMsg(); 

//             System.out.println("Remote method invoked"); 
//          } catch (Exception e) {
//             System.err.println("Client exception: " + e.toString()); 
//             e.printStackTrace(); 
//          } 
//     }

// }

public class Client {
    public static void main(String[] args) throws IOException {
        
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("remote to server get data?");
        String input = bReader.readLine();
        if(input.equals("y")){
            new Client().go();
        }
        else{
            System.out.println("do nothing");
        }     
    }
    public void go(){
        try {
            MyRemote service = (MyRemote) Naming.lookup("RemoteHello");
                                    //    Naming.looup("rmi://ip_address/RemoteHello")
             System.out.println(service.printMsg());             

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
