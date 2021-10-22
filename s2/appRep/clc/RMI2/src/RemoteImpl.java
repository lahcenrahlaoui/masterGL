import java.rmi.RemoteException;

public class RemoteImpl implements IRemote {
    @Override
    public String Calculatrice(String s) throws RemoteException {
        float resultat = 0 ;
        float x = 0 ;
        float y = 0 ;
        char m ;
        int i =  0 ;

        String string = s;
        for( i = 0 ; i < string.length() ; i++){
            if((string.charAt(i) == '+')||(string.charAt(i) == '-')||(string.charAt(i) == '*')||(string.charAt(i) == '/')){
                break;
            }
        }
        m = string.charAt(i);

        x = Float.parseFloat(string.substring(0,i));

        y = Float.parseFloat(string.substring(i+1,string.length()));
        if(m == '+'){
            resultat  = x + y ;
        }else if(m == '-'){

            resultat  = x - y ;
        }
        else if(m == '*'){

            resultat  = x * y ;
        }
        else if(m == '/'){

            resultat  = x / y ;
        }
        else{
            resultat = 0;
        }

        return resultat+"";
    }
}