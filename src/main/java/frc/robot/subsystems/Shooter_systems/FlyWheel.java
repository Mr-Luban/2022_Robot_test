// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Shooter_systems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FlyWheel extends SubsystemBase {
  /** Creates a new FlyWheel. */
  public FlyWheel() {}

  private TalonFX RS = new TalonFX(Constants.R_SHOOTER);
  private TalonFX LS = new TalonFX(Constants.L_SHOOTER);

  private TalonFX KM = new TalonFX(Constants.SHOOTER_KICKER);

  public void setShootMotors (ControlMode CM, double speed) {
    RS.set(CM, speed);
    LS.follow(RS);
  }

  public void setKickerMotor (ControlMode CM, double speed) {
    KM.set(CM, speed);
  }

  public double getVolocity () {
    return RS.getSelectedSensorVelocity();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
