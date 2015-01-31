// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc811.RobotCode2015.subsystems;

import org.usfirst.frc811.RobotCode2015.RobotMap;
import org.usfirst.frc811.RobotCode2015.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType; import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.can.*;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Lift extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DigitalInput limit_TopRight = RobotMap.liftLimit_TopRight;
    DigitalInput limit_BottomRight = RobotMap.liftLimit_BottomRight;
    DigitalInput limit_TopLeft = RobotMap.liftLimit_TopLeft;
    DigitalInput limit_BottomLeft = RobotMap.liftLimit_BottomLeft;
    Encoder encoder_Left = RobotMap.liftEncoder_Left;
    Encoder encoder_Right = RobotMap.liftEncoder_Right;
    CANTalon talon_Left = RobotMap.liftTalon_Left;
    CANTalon talon_Right = RobotMap.liftTalon_Right;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void Lift_w_joy() {
    	if ((joystick2.getRawAxis(1) < 0 && limit_BottomRight.get()) || (joystick2.getRawAxis(1) > 0 && limit_TopRight.get())) {
    		talon_Right.set(0);
    	} else if ((joystick2.getRawAxis(1) < 0 && limit_BottomLeft.get()) || (joystick2.getRawAxis(1) > 0 && limit_TopLeft.get())) {
    		talon_Left.set(0);
    	} else {
    		talon_Left.set(joystick2.getRawAxis(1));
    		talon_Right.set(joystick2.getRawAxis(1));
    	}
    }
    public void LiftUp() {
    	double countL = encoder_Left.get();
    	double countR = encoder_Right.get();
    	if (countL >= 50 || (limit_TopLeft.get() && limit_TopRight())) {
    		talon_Left.set(0);
    	} else {
    		talon_Left.set(1);
    	}
    	if (countR >= 50) {
    		talon_Right.set(0);
    	} else {
    		talon_Right.set(1);
    	}
    }
    public void LiftDown() {
    	double countL = encoder_Left.get();
    	double countR = encoder_Right.get();
    	if (countL <= 10 || (limit_BottomLeft.get() && limit_BottomRight())) {
    		talon_Left.set(0);
    	} else {
    		talon_Left.set(-1);
    	}
    	if (countR <= 10) {
    		talon_Right.set(0);
    	} else {
    		talon_Right.set(-1);
    	}
    }
}