/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import frc.robot.OI;
import frc.robot.subsystems.DriveSystem;

/*
  Allows us to use the joysticks to drive the robot
*/
public class DriveWithJoystick extends Command {

  private double speed_y_left;
  private double speed_y_right;
  private static final double DEADZONE = 0.2;

  private OI oi;
  private DriveSystem drive;

  public DriveWithJoystick() {
    requires(Robot.m_subsystem);

    oi = OI.getInstance();
    drive = DriveSystem.getInstance();
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {

    speed_y_left = oi.JoystickYAxis();
    speed_y_right = oi.JoystickYAxis();

    if (Math.abs(speed_y_left) > DEADZONE || Math.abs(speed_y_right) > DEADZONE) {
      drive.drive(speed_y_left, speed_y_right);
    } else {
      drive.drive(0.0, 0.0);
    }

  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    drive.stopDrive();
  }

  @Override
  protected void interrupted() {
  }
}
