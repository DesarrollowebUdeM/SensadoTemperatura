package principal;

import com.sun.nio.sctp.Association;
import com.sun.nio.sctp.Notification;


public class Principal implements Notification{
    public static void main(String[] args) {
        InterfazAr inter=new InterfazAr();//instancia de la clase interfaz encargada del arduino
        
    }

    @Override
    public Association association() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
