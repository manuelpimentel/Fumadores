/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author David
 */
public class ConexionV extends Thread 
{
    private Socket Servidor;
    private DataOutputStream Salida;
    private DataOutputStream SaleIngrediente, SaleIngredientes;
    private DataInputStream Entrada;
    public static ServerSocket Servicio = null;
    public static ServerSocket ss;
    public static String IpCliente = null;
    public static int PuertoCliente = 0;
    
    public ConexionV() throws IOException
    {
          // Creamos socket servidor escuchando en el mismo puerto donde se comunica el cliente
          // en este caso el puerto es el 1234
          System.out.println( "Esperando por el Banco..." ); 
    }
    @Override
    public void run()
    {
        try
        {
               Servicio = new ServerSocket(8082);
               Servidor = Servicio.accept();
               System.out.println("El Banco se ha conectado...");            
               // Creamos flujo de entrada para leer los datos que envia el cliente 
               Entrada = new DataInputStream( Servidor.getInputStream() );
               String Protocolo = Entrada.readUTF();
               System.out.println("Peticion del Banco: "+Protocolo);
               
               if (Protocolo.equals("Surtir"))
               {//Nota: aun no he podido decirle al servidor que reciba estos integrediente
                    System.out.println("Surtiendo el Banco");
                    Random ingrediente = new Random();
                    int Numero = 1+ingrediente.nextInt(3);
                    System.out.println(Numero);
                    SaleIngrediente = new DataOutputStream(Servidor.getOutputStream());
                    SaleIngrediente.writeUTF(String.valueOf(Numero));
                    
                    Random ingredientes = new Random();
                    int Numero1 = 1+ingredientes.nextInt(3);
                    System.out.println(Numero1);
                    SaleIngredientes = new DataOutputStream(Servidor.getOutputStream());
                    SaleIngredientes.writeUTF(String.valueOf(Numero1));
               }
        }
        catch(Exception e)
        {
          System.out.println( e.toString() );  
        }       
    }
}

