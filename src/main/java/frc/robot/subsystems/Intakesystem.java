// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Joystick;


public class Intakesystem extends SubsystemBase {
  /** Creates a new EmptySubsystem. */
  public Intakesystem() {
    TalonSRX motor1 = new TalonSRX(8);
    Joystick exampleJoystick = new Joystick(0);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
