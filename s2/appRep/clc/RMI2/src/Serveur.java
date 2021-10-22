import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Serveur {

    public static void main(String[] args) {
        try {
            RemoteImpl remoteImpl = new RemoteImpl();
            IRemote objet = (IRemote) UnicastRemoteObject.exportObject(remoteImpl, 1099);
            LocateRegistry.createRegistry(1099).bind("objet-calculatrice", objet);
            while (true) { }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}