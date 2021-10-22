import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemote extends Remote {
    double verser(double solde) throws RemoteException;
    double retirer(double solde) throws RemoteException;
    double avoire() throws RemoteException;}