package MATEControl;

import static MATEControl.MATE.joystick;

public class Math {
    
    public static float x, y, e, r, s;
    
    public static void math(){
        x = joystick.getX();
        y = joystick.getY();
        r = joystick.getRotation();
        s = joystick.getSlider();
        
        //turn te joystick square into a diamond
        if(((x + y > 1)||(x + y < -1))||((x - y < -1)||(-x + y < -1))){
            if(y > 0){
                if(x > 0)
                    y = 1 - x;
                if(x < 0)
                    y = x + 1;
            } else if(y < 0){
                if(x > 0)
                    y = -1 + x;
                if(x < 0)
                    y = -1 + -x;
            }
        }
        
        x *= s;
        y *= s;
        
        //horizontal
        MATE.motorHorizontal.setValueAxisValue(x);
        
        //tank drive
        MATE.motorLeft.setValueAxisValue(x + r);
        MATE.motorRight.setValueAxisValue(-x + r);
        
        //elevation
        if(MATE.joystick.getButton(3)) //down
            e = -1f;
        else if(MATE.joystick.getButton(2)) //up
            e = 1f;  
        else 
            e = 0;
        
        MATE.motorElevation.setValueAxisValue(e);
        
        //claw
        if(MATE.joystick.getButton(4)){ //left
            MATE.servoClaw.subDegree(2);
        }
        if(MATE.joystick.getButton(5)){ //right
            MATE.servoClaw.addDegree(2);
        }  
    }
}
