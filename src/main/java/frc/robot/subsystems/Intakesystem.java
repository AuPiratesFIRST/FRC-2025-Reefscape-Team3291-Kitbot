// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intakesystem extends SubsystemBase {
  /** Creates a new Intakesystem. */

  private CANSparkMax intakeMotor;

  public Intakesystem() {
    // Initialize the motor with the CAN ID (replace 8 with the actual CAN ID of
    // your motor)
    intakeMotor = new CANSparkMax(Constants.IntakeConstants.kIntakeMotorPort, MotorType.kBrushless); // Replace with the actual CAN ID of your motor
    intakeMotor.setInverted(Constants.IntakeConstants.kIntakeInverted); // Set motor inversion
    intakeMotor.set(0); // Set initial speed to 0
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setIntakeSpeed() {
    intakeMotor.set(Constants.IntakeConstants.kIntakeSpeed); // Set motor speed to intake speed
  }

  public void setIntakeReverseSpeed() {
    intakeMotor.set(Constants.IntakeConstants.kIntakeReverseSpeed); // Set motor speed to reverse intake speed
  }
}
