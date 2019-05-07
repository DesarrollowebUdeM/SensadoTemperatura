/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author Pablo
 */

//esta clase guarda objetos en firebase, dado el objeto se guarda en la referenica sensor:{ ["Objeto.nombre" : "valor" ,"objeto.datos2":"valor2"]}
public class conexionFB {

    private static final String DATABASE_URL = "https://sensor-6288b.firebaseio.com/";//enlace de la base de datos https://NOMBRE_DE_MIBD.firebaseio.com/
    private FirebaseDatabase firebaseDatabase;

    public conexionFB() {//establecer la conexion con la Firebase por medio del url y el archivo de authenticacion que se obtiene mediante firebase 
        try {
            FileInputStream serviceAccount = new FileInputStream("sensor-6288b-firebase-adminsdk-10egd-968e32f03f.json");//ARCHIVO DE AUTENTICACION en ruta relativa
            FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).setDatabaseUrl("https://sensor-6288b.firebaseio.com/").build();
            FirebaseApp.initializeApp(options);
            firebaseDatabase = FirebaseDatabase.getInstance(DATABASE_URL);//se genera la instancia de la BD
        } catch (IOException ioe) {
            System.out.println("Error:");
            System.out.println(ioe.getMessage());
        }
    }

    public void update(Object value, String key) {//aqui se guarda el dato, el metodo setValue se encarga de hacer le push en la firebase 
        try {
            DatabaseReference ref = firebaseDatabase.getReference(key);
            final CountDownLatch latch = new CountDownLatch(1);//hace gestion de los threads para las actividades asincronas
            ref.setValue(value, new DatabaseReference.CompletionListener() {//hace el push o guarda en firebase un objeto
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if (databaseError != null) {
                        System.out.println("Data could not be saved(ERROR)(ERROR)" + databaseError.getMessage());
                        latch.countDown();//manejo de los threads
                    } else {
                        System.out.println("Data saved successfully(OK)(OK)");
                        latch.countDown();//manejo de los threads
                    }
                }
            });
            latch.await();
        } catch (InterruptedException e) {
            System.out.println("Error2:");
            e.printStackTrace();
        }
    }
   
}