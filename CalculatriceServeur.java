import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatriceServeur extends UnicastRemoteObject implements CalculatriceInterface {

    protected CalculatriceServeur() throws RemoteException {
        super();
    }

    @Override
    public double addition(double a, double b) throws RemoteException {
        return a + b;
    }

    @Override
    public double soustraction(double a, double b) throws RemoteException {
        return a - b;
    }

    @Override
    public double multiplication(double a, double b) throws RemoteException {
        return a * b;
    }

    @Override
    public double division(double a, double b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("Division par zéro !");
        }
        return a / b;
    }

    public static void main(String[] args) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            System.out.println("Serveur démarré...");
            CalculatriceServeur serveur = new CalculatriceServeur();
            java.rmi.Naming.rebind("//localhost/Calculatrice", serveur);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
