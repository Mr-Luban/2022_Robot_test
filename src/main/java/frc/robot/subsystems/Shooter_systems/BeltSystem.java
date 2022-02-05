// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Shooter_systems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BeltSystem extends SubsystemBase {
  /** Creates a new BeltSystem. */
  public BeltSystem() {}

  private CANSparkMax InBelt = new CANSparkMax(Constants.IN_BELT, null);
  private CANSparkMax UpBelt = new CANSparkMax(Constants.UP_BELT, null);

  public void setInBelt (Double speed) {
    InBelt.set(speed);
  }

  public void setUpBelt (Double speed) {
    UpBelt.set(speed);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
