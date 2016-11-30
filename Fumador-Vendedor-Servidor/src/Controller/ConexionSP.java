
package Controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ConexionSP extends Thread {
    
    protected ServerSocket socketServidor; //Socket del servidor
    protected Socket socketCliente; //Socket del cliente
    protected String mensajeEntrante; //Mensajes entrantes (recibidos) en el servidor
    protected DataOutputStream salidaServidor, salidaCliente;
    protected DataInputStream Entrando = null;//Flujo de datos de salida
    protected DataOutputStream Saliendo = null;//Flujo de datos de salida
    protected int PuertoServidor = 8082; //Puerto para la conexión
    protected String IpServidor = "127.0.0.1"; //Host para la conexión

}
