// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Intakesystem extends SubsystemBase { 
  /** Creates a new EmptySubsystem. */
  
  // Declare the CAN motor controller
  private TalonSRX motor1;

  public Intakesystem() {
    // Initialize the motor with the CAN ID (replace 8 with the actual CAN ID of your motor)
    motor1 = new TalonSRX(8);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
