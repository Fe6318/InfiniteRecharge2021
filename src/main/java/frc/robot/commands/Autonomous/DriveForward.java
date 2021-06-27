// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveForward extends CommandBase {

  private DriveTrain dTrain;
  private Timer timer;

  /** Creates a new DriveForward. */
  public DriveForward(DriveTrain dTrain) {
    this.dTrain = dTrain;
    timer = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(dTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    dTrain.autoArcade(.5, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    timer.stop();
    dTrain.autoArcade(0, 0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(timer.get() > 4.0){
      return true;
    }
    return false;
  }
}
