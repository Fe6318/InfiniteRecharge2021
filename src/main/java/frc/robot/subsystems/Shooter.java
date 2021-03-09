// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private static WPI_VictorSPX shooterMotorRight;
  private static WPI_VictorSPX shooterMotorLeft;
  /** Creates a new Shooter. */
  public Shooter() {
    shooterMotorRight = new WPI_VictorSPX(Constants.ShooterMotorRight);
    shooterMotorLeft = new WPI_VictorSPX(Constants.ShooterMotorLeft);
  }

  public void shootManual(double speed){
    shooterMotorLeft.set(speed);
    shooterMotorRight.set(speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
