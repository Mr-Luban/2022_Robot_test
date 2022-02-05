// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriverControlMethods.LiftControl;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class setLiftPos extends CommandBase {
  /** Creates a new setLiftPos. */
  public setLiftPos(double POS) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_elli);
    m_pos = POS;
  }

  double m_pos;
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_elli.setElliMotors(m_pos);
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
