import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        BufferedReader ain;
        Socket socketClient;
        try {
            socketClient = new Socket("41.102.48.242",81);
            ain = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            String a = null;
            while(a == null){
                a = ain.readLine();
                System.out.println(a);
            }
        }catch (Exception e){
            System.out.println("Impossible de se connecter a l'hote");
            System.exit(1);

        }
        System.out.println("FIN");
    }

}