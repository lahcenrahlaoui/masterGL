import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            IRemote objet = (IRemote) registry.lookup("objet-calculatrice");
            Scanner scanner = new Scanner(System.in);
            System.out.print("donner equation:" );
            String equation = scanner.next();
            System.out.println("Resultat : "+objet.Calculatrice(equation));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
