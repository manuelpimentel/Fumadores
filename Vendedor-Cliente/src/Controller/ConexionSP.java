
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
    protected DataInputStream entrada = null;//Flujo de datos de salida

}
