/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author David
 */
public class Servidor extends ConexionSP {
    
    private Socket socket;
    private Socket Cliente;
    private DataOutputStream Salida;
    private DataInputStream Entrada;
    public static ServerSocket servidor = null;
    public static ServerSocket ss;
    public static String IpCliente = null;
    public static int PuertoCliente = 0;
    public static int puerto = 1234;
    public static int Papel = 2;
    public static int Tabaco = 2;
    public static int Fosforo = 2;
    
    public Servidor() throws IOException
    {
          // Creamos socket servidor escuchando en el mismo puerto donde se comunica el cliente
          // en este caso el puerto es el 1234
          System.out.println( "Esperando Fumadores..." ); 
    }

    @Override
    public void run()
    {      
            try
            {
               servidor = new ServerSocket(8081);
               Cliente = servidor.accept();
               System.out.println("Un Fumador se ha conectado...");            
               // Creamos flujo de entrada para leer los datos que envia el cliente 
               Entrada = new DataInputStream( Cliente.getInputStream() );
               String Protocolo = Entrada.readUTF();
               System.out.println("Bienvenido Fumar: "+Protocolo);
               //Ingredientes();
               int Operacion = Integer.parseInt(Protocolo);
               switch (Operacion)
               {
                   case 0: //Llenar Banco                          
                       socket = new Socket( IpServidor, PuertoServidor );
                       System.out.println(socket);
                       Saliendo = new DataOutputStream(socket.getOutputStream());
                       Saliendo.writeUTF("Surtir");
                       
                   break;
                   case 1:
                       DataOutputStream Salida1 = new DataOutputStream(Cliente.getOutputStream());
                       Salida1.writeUTF(String.valueOf(Papel));
                       
                       DataOutputStream Salida2 = new DataOutputStream(Cliente.getOutputStream());
                       Salida2.writeUTF(String.valueOf(Tabaco));
                       
                       DataOutputStream Salida3 = new DataOutputStream(Cliente.getOutputStream());
                       Salida3.writeUTF(String.valueOf(Fosforo));                      
                   break;
                       
               }
            }
            catch(Exception e)
            {
               System.out.println( e.toString() );  
            }
    }
    
    public static void Ingredientes()
    {
        
        
    }
}
