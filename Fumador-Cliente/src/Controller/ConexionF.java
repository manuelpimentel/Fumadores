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
    public int Tabaco = 1;
    public static int Papel = 0;
    public static int Fosforo = 0;
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
            //Fumar(Papel,Fosforo);
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
        int Papels = Integer.parseInt(Paper);
        
        DataInputStream Entrada3 = new DataInputStream(socket.getInputStream());
        String Fosfo = Entrada3.readUTF();
        int Fosforos = Integer.parseInt(Fosfo);
        
        System.out.println("Papel Disponible: "+Papels);
        System.out.println("Fosforo Disponible: "+Fosforos);
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
        //falta decirle al servidor descontar este ingredientes
        if (Protocolo.equals("2"))
        {
          Papel = Papel+1; 
          //System.out.println(Papel);
        }
         //falta decirle al servidor descontar este ingredientes       
        if (Protocolo.equals("3"))
        {
           Fosforo = Fosforo+1; 
           //System.out.println(Fosforo);
        }
        Fumar(Papel,Fosforo);
    }
    
    public void Fumar(int papel, int fosforo)
    {
        if ((papel==1) && (fosforo==1))
        {
            System.out.println("Fumando Cigarros...");
        }
        else
        {
            System.out.println("Ingredientes Aun No Completos Para Fumar...");
        }
    }
}
