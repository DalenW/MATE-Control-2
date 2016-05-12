package MATEControl;

import static MATEControl.MATE.joystick;

public class Math {
    
    public static float x, y, e, r, s;
    public static int clawValue = 90;
    
    public static void math(){
        x = joystick.getX();
        y = joystick.getY();
        r = joystick.getRotation();
        s = joystick.getSlider();
        
        //turn te joystick square into a diamond
        /*
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
        */
        x *= s;
        y *= s;
        r *= s;
        
        //horizontal
        MATE.motorHorizontal.setValueAxisValue(x);
        
        //tank drive
        MATE.motorLeft.setValueAxisValue((r + y)/2f);
        MATE.motorRight.setValueAxisValue((-r + y)/2f);
        
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
            addClaw(-4);
        }
        if(MATE.joystick.getButton(5)){ //right
            addClaw(4);
        }
        double claw = clawValue;
       
        claw /= 180;
        
        claw *= 140;
        claw += 20;
        if(claw == 160) claw--;
        MATE.servoClaw.setValue((int) claw);

        //MATE.servoClaw.setValue(20);
    }
    
    private static void addClaw(int i){
        clawValue += i;
        if(clawValue > 180) clawValue = 180;
        if(clawValue < 0) clawValue = 0;
    }
}
