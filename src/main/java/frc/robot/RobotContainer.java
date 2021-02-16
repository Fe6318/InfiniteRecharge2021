// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static Shooter shooter; 
  
  public static Joystick driver;
  public static Joystick operator;
  
  public static JoystickButton shootButton;
  public static JoystickButton blueButton;
  public static JoystickButton yellowButton;
  public static JoystickButton greenButton;
 
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    shooter = new Shooter();
    //shooter.setDefaultCommand(new Shoot());
    driver = new Joystick(0);

    shootButton = new JoystickButton(driver, Constants.RED_BUTTON);
    shootButton.whileHeld(new Shoot());
  


    
  }

 
  public static double deadZone(double input)
  {
    if(Math.abs(input) < 0.1)
    {
      return 0;
    }
    return input;
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;

 }
}