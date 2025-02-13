// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.CANrange;
import com.ctre.phoenix6.configs.CANrangeConfiguration;

public class RangeSubsystem extends SubsystemBase {
  private final CANrange canRange;

  /** Creates a new RangeSubsystem and configures the CANrange sensor. */
  public RangeSubsystem() {
    // Constants used in CANrange construction.
    final int kCANrangeId = 0;
    final String kCANrangeCANbus = "canivore";

    // Instantiate the CANrange sensor.
    canRange = new CANrange(kCANrangeId, kCANrangeCANbus);

    // Configure the CANrange for basic use.
    CANrangeConfiguration configs = new CANrangeConfiguration();
    canRange.getConfigurator().apply(configs);
  }

  /**
   * Returns whether an object is detected.
   * @return true if an object is detected, false otherwise.
   */
  public boolean isObjectDetected() {
    // getIsDetected() returns a signal whose getValue() method provides a boolean.
    return canRange.getIsDetected().getValue();
  }

  /**
   * Returns the measured distance to the object.
   * @return The distance measurement as a double.
   */
  public double getDistance() {
    // getDistance() returns a signal; its getValueAsDouble() method returns the measurement.
    return canRange.getDistance().getValueAsDouble();
  }

  @Override
  public void periodic() {
    // Optionally, update SmartDashboard or log sensor data here.
    // For example:
    // SmartDashboard.putBoolean("Object Detected", isObjectDetected());
    // SmartDashboard.putNumber("Distance", getDistance());
  }
}
