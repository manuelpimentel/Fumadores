/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class VendedorCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            new Controller.ConexionV().run();
        } catch (IOException ex) {
            Logger.getLogger(VendedorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
