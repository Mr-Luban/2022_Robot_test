// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoControlMethods;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class TurnRobot extends CommandBase {
  /** Creates a new TurnRobot. */
  public TurnRobot(double Turn) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_driveTrain);
    m_turn = Turn;
  }
  double m_turn;
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Double CurrentTurnPos = RobotContainer.m_driveTrain.GRO.getAngle();
    Double error = m_turn - CurrentTurnPos;
    
    //final stage
    while (error < -1){
      RobotContainer.m_driveTrain.setRightMotors(ControlMode.PercentOutput, 0.1);
      RobotContainer.m_driveTrain.setLeftMotors(ControlMode.PercentOutput, 0.1);
    }
    
    while (error > 1){
      RobotContainer.m_driveTrain.setRightMotors(ControlMode.PercentOutput, -0.1);
      RobotContainer.m_driveTrain.setLeftMotors(ControlMode.PercentOutput, -0.1);
    }

    //stop
    if (error > -1 && error < 1){
      RobotContainer.m_driveTrain.setRightMotors(ControlMode.PercentOutput, 0);
      RobotContainer.m_driveTrain.setLeftMotors(ControlMode.PercentOutput, 0);
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
