package MATE;

import com.ward.Console;
import robot.devices.*;
import robot.util.Log;

public class MATE {
    public static void main(String[] args) {
        Console console = new Console();
        console.setTitle("MATE Control");
        console.setSize(400, 500);
        console.build();
        
        Log log = new Log("MATE-Control-2", true);
        
        //joystick
        log.write("Adding joystick");
        Joystick logitech = new Joystick("Logitech Extreme 3D");
        logitech.connect();
        log.write("Connected to joystick " + logitech.getName());
        
        //arduino
        log.write("Adding arduino");
        Arduino uno = new Arduino("Uno", 115200);
        uno.connect();
        log.write("Added arduino " + uno.getName());
        
        //Motors
        log.write("Adding motors");
        
    }

}
