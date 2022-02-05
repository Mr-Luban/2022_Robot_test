// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoControlMethods.TurretAutoAim;
import frc.robot.subsystems.Shooter_systems.FlyWheel;
import frc.robot.subsystems.Shooter_systems.Intake;
import frc.robot.subsystems.Shooter_systems.Turret;
import frc.robot.subsystems.Shooter_systems.BeltSystem;

import frc.robot.subsystems.Lift_systems.ElliAngle;
import frc.robot.subsystems.Lift_systems.Elli;

import frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  public final static DriveTrain m_driveTrain = new DriveTrain();

  public final static Elli m_elli = new Elli();
  public final static ElliAngle m_elli_angle = new ElliAngle();

  public final static FlyWheel m_flyWheel = new FlyWheel();
  public final static Turret m_turret = new Turret();
  public final static BeltSystem m_belt_System = new BeltSystem();
  public final static Intake m_intake = new Intake();

  private final TurretAutoAim m_turretAutoAim = new TurretAutoAim();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}
  public static Joystick XboxC = new Joystick(Constants.JOYSTICK_PORT);

  public JoystickButton AB = new JoystickButton(XboxC, 1);
  public JoystickButton BB = new JoystickButton(XboxC, 2);
  public JoystickButton XB = new JoystickButton(XboxC, 3);
  public JoystickButton YB = new JoystickButton(XboxC, 4);
  public JoystickButton LB = new JoystickButton(XboxC, 5);
  public JoystickButton RB = new JoystickButton(XboxC, 6);
  public JoystickButton HB = new JoystickButton(XboxC, 7);
  public JoystickButton ZB = new JoystickButton(XboxC, 8);
  public JoystickButton LJB = new JoystickButton(XboxC, 9);
  public JoystickButton RJB = new JoystickButton(XboxC, 10);

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_turretAutoAim;
  }
}
