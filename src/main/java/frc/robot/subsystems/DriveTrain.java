// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.SPI;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  public static final Double Gro = null;

  /** Creates a new DriveTrain. */
  public DriveTrain() {}

  private TalonFX RM = new TalonFX(Constants.R_MASTER);
  private TalonFX RS = new TalonFX(Constants.R_SLAVE);

  private TalonFX LM = new TalonFX(Constants.L_MASTER);
  private TalonFX LS = new TalonFX(Constants.L_SLAVE);

  public AHRS GRO = new AHRS(SPI.Port.kMXP);

  double kp = 0.5, ki = 0.0, kd = 0.0;
  private PIDController pid = new PIDController(kp, ki, kd);

  public void setRightMotors(ControlMode CM ,double unit) {
    RM.set(CM, unit);
    RS.follow(RM);
  }

  public void setLeftMotors(ControlMode CM ,double unit) {
    LM.set(CM, unit);
    LS.follow(LM);
  }

  public void setDriveTrainAngle (double ang) {
    setLeftMotors(ControlMode.PercentOutput, pid.calculate(GRO.getAngle(), ang));
    setRightMotors(ControlMode.PercentOutput, pid.calculate(GRO.getAngle(), ang));
  }

  public double getRightPos () {
    double RMPOS = RM.getSelectedSensorPosition();
    return RMPOS;
  }
  public double getLeftPos () {
    return LM.getSelectedSensorPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
