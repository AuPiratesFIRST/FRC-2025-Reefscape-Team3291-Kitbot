// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.configs.CANrangeConfiguration;
import com.ctre.phoenix6.hardware.*;

public class range extends SubsystemBase {
  /** Creates a new EmptySubsystem. */
  public range () {
    
    // Constants used in CANrange construction
 final int kCANrangeId = 0;
 final String kCANrangeCANbus = "canivore";
 
 // Construct the CANrange
 CANrange CANrange = new CANrange(kCANrangeId, kCANrangeCANbus);
 
 // Configure the CANrange for basic use
 CANrangeConfiguration configs = new CANrangeConfiguration();
 
 // Write these configs to the CANrange
 CANrange.getConfigurator().apply(configs);
 
 // Get Distance
 var distance = CANrange.getDistance();
 
 // Refresh and print these values
 System.out.println("Distance is " + distance.refresh().toString());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
