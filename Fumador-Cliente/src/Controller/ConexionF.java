/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import com.sun.org.apache.bcel.internal.util.ByteSequence;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author David
 */
public class ConexionF extends Thread {
    
    public static int PuertoServidor = 0; //Puerto para la conexión
    public static String IpServidor = ""; //Host para la conexión
    public static int PuertoCliente = 2000; //Puerto para la conexión
    public static String IpCliente = "192.168.0.102"; //Host para la conexión
    public static Socket socket;
    public static ServerSocket servidor = null;
    public static ServerSocket servidord = null;
    public static int Tabaco = 1;
    public static int Papel;
    public static int Fosforo;
    protected Socket sc;
    protected DataOutputStream Salida, Salida2;
    protected DataInputStream Entrada;
    
    public ConexionF (String IpServidor, int PuertoServidor)throws IOException
    {
       this.IpServidor = IpServidor;
       this.PuertoServidor = PuertoServidor;               
    }
    @Override
    public void run()
    {        
        try
        {
            System.out.println("Fumador");
            // Creamos el Socket con la direccion y elpuerto de comunicacion
            socket = new Socket( IpServidor, PuertoServidor );
            Salida = new DataOutputStream(socket.getOutputStream());
            Salida.writeUTF("Señor Fumador 1");
            Ingredientes();
          }
          catch( Exception e )
          {
            System.out.println( e.toString() );
          }             
    }
    
    public void Ingredientes() throws IOException
    {
        DataInputStream Entrada1 = new DataInputStream(socket.getInputStream());
        String Paper = Entrada1.readUTF();
        Papel = Integer.parseInt(Paper);
        
        DataInputStream Entrada3 = new DataInputStream(socket.getInputStream());
        String Fosfo = Entrada3.readUTF();
        Fosforo = Integer.parseInt(Fosfo);
        
        System.out.println("Papel Disponible: "+Papel);
        System.out.println("Fosforo Disponible: "+Fosforo);
    }
    
    public void PedirIngredientes(String Protocolo) throws IOException
    {  
        System.out.println("Agarrando Ingrediente...");
        
        if (Protocolo.equals("0"))
        {
        Salida2 = new DataOutputStream(socket.getOutputStream());
        Salida2.writeUTF(Protocolo);

//        Entrada = new DataInputStream(socket.getInputStream());
//        String Cantidad = Entrada.readUTF();
//
//        System.out.println("Tabaco Disponible: "+Cantidad);
        }
    }
}
