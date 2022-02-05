// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Lift_systems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElliAngle extends SubsystemBase {
  /** Creates a new ElliAngle. */
  public ElliAngle() {}

  private CANSparkMax ANGM = new CANSparkMax(Constants.ELLI_ANGLE_MOTOR, MotorType.kBrushless);

  double kp = 0.5, ki = 0.0, kd = 0.0;
  private PIDController pid = new PIDController(kp, ki, kd);

  public double getLiftAngle() {
    return ANGM.getEncoder().getPosition();
  }

  public void setLiftAngle (double ang) {
    ANGM.set(pid.calculate(getLiftAngle(), ang));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  
  }
}
