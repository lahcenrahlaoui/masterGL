import java.rmi.RemoteException;

public class RemoteImpl implements IRemote {
    private double solde = 0;

    @Override
    public double verser(double solde) throws RemoteException {
        this.solde+= solde;
        return solde;
    }

    @Override
    public double retirer(double solde) throws RemoteException {
        this.solde -= solde;
        return solde;
    }

    @Override
    public double avoire() throws RemoteException {
        return solde;
    }
}