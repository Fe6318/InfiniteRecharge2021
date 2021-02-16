// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  public static Victor shooterMotorRight;
  public static Victor shooterMotorLeft;
  /** Creates a new Shooter. */
  public Shooter() {
    shooterMotorRight = new Victor(Constants.ShooterMotorRight);
    shooterMotorLeft = new Victor(Constants.ShooterMotorLeft);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
