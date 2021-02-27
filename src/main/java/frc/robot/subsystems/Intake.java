// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  private Victor intakeMotor;
  /** Creates a new Intake. */
  public Intake() {
    intakeMotor = new Victor(Constants.RAMP_MOTOR_CONTROLLER);

    }

  public void moveIntakeUp(){
    intakeMotor.set(0.5);
  }

  public void moveIntakeDown(){
    intakeMotor.set(-0.5);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
