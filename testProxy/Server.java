package testProxy;

import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject;
import java.io.*;

// public class Server implements MyRemote {

//     @Override
//     public void printMsg() throws RemoteException {
//         System.out.println("RMI 測試");
//     }

//     public static void main(String[] args) {
//         try {
//             // Instantiating the implementation class 
//          MyRemote service = new Server(); 

         

        
//          MyRemote stub = (MyRemote) UnicastRemoteObject.exportObject(service, 0);  

      
//          Registry registry = LocateRegistry.getRegistry(); 

//          registry.bind("Hello", stub);  
//          System.err.println("Server ready"); 
//         } catch (Exception e) {
//             e.printStackTrace(); 
//         }
//     }
    
// }
public class Server extends UnicastRemoteObject implements MyRemote {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String message = "RMI testing";
    @Override
    public String printMsg() throws RemoteException {
        System.out.print("Clinet call printMSg()");
        return message;
    }

    public Server() throws RemoteException {};

    public static void main(String[] args) {
        try {
            MyRemote service = new Server();
            Naming.bind("RemoteHello", service);
            System.out.println("Server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

