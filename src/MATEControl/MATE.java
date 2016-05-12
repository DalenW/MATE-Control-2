 package MATEControl;

import com.ward.Console;
import robot.devices.Arduino;
import robot.devices.Joystick;
import robot.util.Log;
import robot.write.Motor;
import robot.write.Servo;

public class MATE 
{
    public static Console console;
    public static Log log;
    
    public static Arduino arduino;
    public static Joystick joystick;
    
    public static Motor motorLeft;
    public static Motor motorRight;
    public static Motor motorHorizontal;
    public static Motor motorElevation;
    
    public static Servo servoClaw;
    
    public static void main(String[] args) 
    {       
        console = new Console();
        console.setTitle("MATE Console");
        console.setSize(400, 500);
        console.build();
        
        log = new Log("MATE", true);
        log.write("Starting");
        log.write("Setting up");
        
        //arduino
        arduino  = new Arduino("Uno", 115200);
        arduino.connect();
        
        //joystick
        joystick = new Joystick ("Logitech Extreme 3D");
        log.write("Joystick and Arduino done");
        
        //motors
        log.write("Creating Motors and Servos");
        
        double scale = .95;
        
        motorLeft  = new Motor("Left", 2, arduino);
        motorLeft.scaleValue(scale);
        
        motorRight = new Motor("Right", 3, arduino);
        motorRight.scaleValue(scale);
        
        motorHorizontal = new Motor("Horizontal", 5, arduino);
        motorHorizontal.scaleValue(scale);
        
        motorElevation = new Motor("Elevation", 4, arduino);
        motorElevation.scaleValue(scale);
        
        servoClaw = new Servo("Claw", 6, arduino);
         
        log.write("Setup complete");
        
        log.write("Starting loop");
        Loop.main();
    }
}
