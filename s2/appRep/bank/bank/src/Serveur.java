import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.rmi.server.UnicastRemoteObject;

public class Serveur {

    public static void main(String[] args) {
        try {
            RemoteImpl remoteImpl = new RemoteImpl();
            IRemote objet = (IRemote) UnicastRemoteObject.exportObject(remoteImpl, 0);
            Registry registry = LocateRegistry.createRegistry(9024);
            System.out.println(InetAddress.getLocalHost().getHostAddress() );
            String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + ":9024/IRemote";
            Naming.rebind(url, remoteImpl);

            while (true) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}