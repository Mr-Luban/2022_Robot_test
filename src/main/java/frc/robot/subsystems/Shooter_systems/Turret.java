// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Shooter_systems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Turret extends SubsystemBase {
  /** Creates a new Turret. */
  public Turret() {}

  private TalonFX TM = new TalonFX(Constants.TURRET_MOTOR);

  private CANSparkMax TMSM = new CANSparkMax(Constants.ELLI_ANGLE_MOTOR, MotorType.kBrushless);

  double kp = 0.5, ki = 0.0, kd = 0.0;
  private PIDController pid = new PIDController(kp, ki, kd);

  public double getTurretPOS() {
    return TMSM.getEncoder().getPosition();
  }

  public void setLiftAngle(double pos) {
    TMSM.set(pid.calculate(getTurretPOS(), pos));
  }

  public void setTurret (ControlMode CM, double speed) {
    TM.set(CM, speed);
  }

  public double getTurretPos () {
    return TM.getSelectedSensorPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
