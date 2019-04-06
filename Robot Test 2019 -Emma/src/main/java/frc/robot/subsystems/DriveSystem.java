/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.Joystick;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.RobotMap;

/**
Allows us to makle the robot drive
*/

public class DriveSystem extends Subsystem {

  //creating the talon
  private TalonSRX leftMaster;
  private TalonSRX rightMaster; 

  public DriveSystem() {

    //stating the location of the talons and their corresponding names 
    leftMaster = new TalonSRX(RobotMap.LEFTMASTER);
    rightMaster = new TalonSRX(RobotMap.RIGHTMASTER);

    initalizeDriveSystem(); 
  }

  @Override 
  public void initDefaultCommand() {
  }
  
  private void initalizeDriveSystem() {

    //sets the speed to zero when we start the program
    leftMaster.set(ControlMode.PercentOutput, 0.0);
    rightMaster.set(ControlMode.PercentOutput, 0.0); 

  }

  public void drive(Double RightSpeed, Double LeftSpeed){
    //sets the speed of the talons
    rightMaster.set(ControlMode.PercentOutput, RightSpeed);
    leftMaster.set(ControlMode.PercentOutput, LeftSpeed); 

  }

  public void stopDrive() {
    rightMaster.set(ControlMode.PercentOutput, 0.0);
    leftMaster.set(ControlMode.PercentOutput, 0.0); 
  }



}
