// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoControlMethods;
import frc.robot.subsystems.Cameras.TurretLimeLight;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class TurretAutoAim extends CommandBase {
  /** Creates a new TurretAutoAim. */
  public TurretAutoAim() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_turret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    TurretLimeLight.setPipeline(2);
    TurretLimeLight.setLEDMode(3);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    if (TurretLimeLight.hasTarget()) {
      //final stage
      while (TurretLimeLight.getHorizontalOffset() < -1 && TurretLimeLight.getHorizontalOffset() < -7){
        RobotContainer.m_turret.setTurret(ControlMode.PercentOutput, 0.1);
      }
      while (TurretLimeLight.getHorizontalOffset() > 1 && TurretLimeLight.getHorizontalOffset() < 7){
        RobotContainer.m_turret.setTurret(ControlMode.PercentOutput, -0.1);
      }
      //stop
      if (TurretLimeLight.getHorizontalOffset() > -1 && TurretLimeLight.getHorizontalOffset() < 1){
        RobotContainer.m_turret.setTurret(ControlMode.PercentOutput, 0);
      }
    } else {
      RobotContainer.m_turret.setTurret(ControlMode.PercentOutput, 0);
      System.out.println("No Target Found");
    }
    

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
