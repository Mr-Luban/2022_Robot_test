// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Shooter_systems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  public Intake() {}

  private CANSparkMax ITM = new CANSparkMax(Constants.INTAKE_MOTOR, MotorType.kBrushless);

  private Relay deploy = new Relay(Constants.DEPLOY_RELAY);
  private Relay retract = new Relay(Constants.RETRACT_RELAY);
  


  public boolean isDeployed() {
    return false;
  }

  public void deployIntake (Boolean DEPLOY) {
    if (DEPLOY = true) {
      deploy.set(Value.kOn);
      retract.set(Value.kOff);
    } else {
      deploy.set(Value.kOff);
      retract.set(Value.kOn);
    }
  }
  
  public void setIntakeMotor(double speed) {
    ITM.set(speed);
  }

  public double getIntakeCurrent () {
    return ITM.getOutputCurrent();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
