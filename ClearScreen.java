package utilityPkg;

import java.awt.Robot;
import java.awt.AWTException;
import java.util.Scanner;

public class ClearScreen {

    
    public static void clearScreen(){
        try {
            Robot pressbot = new Robot();
            pressbot.keyPress(17); // Holds CTRL key.
            pressbot.keyPress(76); // Holds L key.
            pressbot.keyRelease(17); // Releases CTRL key.
            pressbot.keyRelease(76); // Releases L key.
          //  System.out.println("hello");
        } catch (AWTException ex) {
            // Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
