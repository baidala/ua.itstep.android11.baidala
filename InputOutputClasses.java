/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.itstep.android11.baidala;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author student
 */
public class InputOutputClasses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        FileClass fc = new FileClass("D:\\workspace\\out.jpg", "John", "ppasd");
        
        //String urlFrom = "http://cityfinder.esy.es/getuser.php";
        //String urlFrom = "http://cityfinder.esy.es/getwithget.php?name=Max";
        String urlFrom = "http://cityfinder.esy.es/img/2.jpg";
        
        //fc.readFile(urlFrom, Definitions.READ_HTTP_CASE);
        FileClass.getImage(urlFrom, "D:\\workspace\\out.jpg");
        
        } catch (NullPointerException ex) {
            System.out.println("ERROR: Invalid user/password.");
        }
        

    }
    
}
