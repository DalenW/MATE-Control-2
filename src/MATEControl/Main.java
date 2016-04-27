package MATEControl;

import com.ward.Console;
import robot.*;
import robot.devices.Arduino;
import robot.devices.Joystick;
import robot.write.Motor;

public class Main 
{
    public static Console console;
    
    public static Arduino arduino;
    public static Joystick joystick;
    
    public static Motor motorForwardLeft;
    public static Motor motorForwardRight;
    public static Motor motorHorizontal;
    public static Motor motorVertical;
    
    public static void main(String[] args) 
    {       
        console = new Console();
        
        arduino  = new Arduino("Uno", 115200);
        joystick = new Joystick ("Logitech Extreme 3D");
        
        motorForwardLeft  = new Motor("Left", 2, arduino);
        motorForwardRight = new Motor("Right", 3, arduino);
        motorHorizontal   = new Motor("Crab", 4, arduino);
        motorVertical     = new Motor("Vert", 5, arduino);
        
        console.setTitle("MATE Console");
        console.setSize(400, 500);
        console.build();
        
        arduino.connect();
        joystick.connect();
        
        while(true)
        {
            Math.math();

            {
                float forwardLeft, forwardRight;
                float forward  = joystick.getY();
                float rotation = joystick.getRotation();
                
                float horizontal = joystick.getX();
                boolean[] coolie = joystick.getHatSwitch();

                forwardLeft  = +rotation;
                forwardRight = -rotation;

                forwardLeft  += forward/2;
                forwardRight += forward/2;

                if (forwardLeft > +1) forwardLeft = +1;
                if (forwardLeft < -1) forwardLeft = -1;

                if (forwardRight > +1) forwardRight = +1;
                if (forwardRight < -1) forwardRight = -1;
                
                
                
                motorForwardLeft.setValue((int)((forwardLeft * 100) + 100));
                motorForwardRight.setValue((int)((forwardRight * 100) + 100));
                
                motorHorizontal.setValue((int)((horizontal * 100) + 100));
                motorVertical.setValue((int)(((coolie[1]? 1 : coolie[5]? -1 : 0) * 100) + 100));
            }
            
            try 
            {
                Thread.sleep(10);
            }
            catch (Exception e)
            {
                
            }
            
            System.out.println("Serial Out:" + arduino.getOutput());

        }
        
        
        
    }

}
