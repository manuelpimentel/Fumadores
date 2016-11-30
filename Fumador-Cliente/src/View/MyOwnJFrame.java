/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JFrame;


/**
 * Class that contains the methods to move in windows
 * @author Ronald Navas
 * @author William Lopez
 * @version 0.0.0
 * @since jMessage 0.0.0
 */
public class MyOwnJFrame extends JFrame{
    
    
    private JFrame  fatherWindow;
    private boolean isFatherWindowHide;
    private boolean isFatherWindowDisable;
    
/**
    * Method that return tu the father window
    * @return fatherWindow
    * @since jMessage 0.0.0
    */
    public JFrame getFatherWindow()
    {
        return fatherWindow;
    }

    /**
    * Method that disables or hides the father window
     * @param fatherWindow
     * @param hideFatherWindow
    * @since jMessage 0.0.0
    */
    public void setFatherWindow(JFrame fatherWindow, boolean hideFatherWindow)
    {
        this.fatherWindow = fatherWindow;
        
        if (hideFatherWindow)
        {
            this.fatherWindow.setVisible(false); 
            this.isFatherWindowHide = true;
            this.isFatherWindowDisable = false;
        }
        else
        {
            this.fatherWindow.setEnabled(false);
            this.setAlwaysOnTop(true);
            this.isFatherWindowHide = false;
            this.isFatherWindowDisable = true;
        }
    }
    
    /**
    * Method that enables or visibles the father window
    * @since jMessage 0.0.0
    */
    public void restoreFatherWindow()
    {
        if (this.isFatherWindowHide)
            this.fatherWindow.setVisible(true);
        
        if (this.isFatherWindowDisable)
            this.fatherWindow.setEnabled(true);
        
        this.dispose();
    }
    
    /**
    * Method that enables the father window
     * @param setEnable
    * @since jMessage 0.0.0
    */
    public void setEnableWindow(boolean setEnable)
    {
        this.setEnabled(setEnable);
        this.setAlwaysOnTop(true);       
    }
    
}
