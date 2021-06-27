// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveContinuous extends CommandBase {
  /** Creates a new DriveContinouts. */
  private DriveTrain dTrain;
  private double zAxis, xAxis, yAxis;
  private Joystick driverJoystick;

  public DriveContinuous(DriveTrain dTrain, Joystick driverJoystick) {
    this.dTrain = dTrain;
    this.driverJoystick = driverJoystick;
    this.zAxis = 0;
    this.yAxis = 0;
    this.xAxis = 0;
    addRequirements(dTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    xAxis = driverJoystick.getRawAxis(0);
    zAxis = driverJoystick.getRawAxis(0);
    yAxis = driverJoystick.getRawAxis(3);
    double axis3 = driverJoystick.getRawAxis(3);
    double axis1 = driverJoystick.getRawAxis(2);
    if(axis3 > 0){
     yAxis = axis3; 
    }
    else{
      yAxis = axis1 * -1;
    }
    dTrain.drive(xAxis, zAxis, yAxis);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
