// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;

public class DriveTrain extends SubsystemBase {
  private WPI_VictorSPX rightMotorOne;
  private WPI_VictorSPX rightMotorTwo;

  private WPI_VictorSPX leftMotorOne;
  private WPI_VictorSPX leftMotorTwo;

  private SpeedControllerGroup rightMotorGroup;
  private SpeedControllerGroup leftMotorGroup;
  
  private DifferentialDrive dDrive;

  private static final double cpr = 5; //count per revolution, dictated by manufacturer
  private static final double whd = 0.1524; // for 6 inch wheel (converted to meters)


  private static final AHRS ahrs = new AHRS(SerialPort.Port.kMXP); 

  private static final Encoder encLeft = new Encoder(0, 1);
  private static final Encoder encRight = new Encoder(2, 3);


  /** Creates a new DriveTrain. */
  public DriveTrain() {
    rightMotorOne = new WPI_VictorSPX(Constants.BackDriveMotorRight);
    rightMotorTwo = new WPI_VictorSPX(Constants.FrontDriveMotorRight);

    leftMotorOne = new WPI_VictorSPX(Constants.BackDriveMotorLeft);
    leftMotorTwo = new WPI_VictorSPX(Constants.FrontDriveMotorLeft);
    
    rightMotorGroup = new SpeedControllerGroup(rightMotorOne, rightMotorTwo);
    leftMotorGroup = new SpeedControllerGroup(leftMotorOne, leftMotorTwo);

    dDrive = new DifferentialDrive(rightMotorGroup, leftMotorGroup);

    encLeft.setDistancePerPulse(Math.PI*whd/cpr); //distance per pulse is pi* (wheel diameter in M / counts per revolution)
    encRight.setDistancePerPulse(Math.PI*whd/cpr); //distance per pulse is pi* (wheel diameter in M / counts per revolution)
  }

  public void drive(double xSpeed, double zRotation, double ySpeed){
    double turnCalc;
    double turnSum = zRotation;
    int factor = 1;

    if(ySpeed < 0){
      factor = -1;
    }

    double curvedSpeed = Math.pow(Math.abs(ySpeed), 1.5) * factor;

    SmartDashboard.putNumber("speed", curvedSpeed);
    if(turnSum > 1){
      turnCalc = 1;
    }else if(turnSum < -1){
      turnCalc = -1;
    }
    else{
      turnCalc = turnSum;
    }

    dDrive.arcadeDrive(curvedSpeed, turnCalc);
  }


  public void autoArcade(double power, double angle){
    dDrive.arcadeDrive(power, angle);
  }

  //TODO add heading angle in degrees
  public double getHeadingAngle(){
    return (double)ahrs.getCompassHeading();
  }

    //TODO add heading distance in meters
    public double getHeadingMeters(){
      return 1;
    }
  
  public Encoder getRightEncoder(){
    return encRight;
  }

  public Encoder getLeftEncoder(){
    return encLeft;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
