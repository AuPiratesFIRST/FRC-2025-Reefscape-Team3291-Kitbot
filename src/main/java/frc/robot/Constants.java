// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */

public final class Constants {
  private Constants() {
    // Prevent instantiationvv    
  }

  public static final class OperatorConstants {
    public OperatorConstants() {
      // Prevent instantiation
    }

    public static final int kDriverControllerPort = 0;
  }

  public static final class DriveConstants {
    public DriveConstants() {
      // Prevent instantiation
    }

    public static final int kLeftFrontMotorPort = 25;
    public static final int kLeftBackMotorPort = 18;
    public static final int kRightFrontMotorPort = 19;
    public static final int kRightBackMotorPort = 21;

    public static final boolean leftInverted = false;
    public static final boolean rightInverted = true;

    public static final double maxSpeed = 1.0; // Maximum speed of the robot

    public static final double brakeSpeed = 0.0; // Speed to apply when brake is engaged
  }

  // Add your constants here
  public static final class IntakeConstants {
    public IntakeConstants() {
      // Prevent instantiation
    }
    public static final int kIntakeMotorPort = 28; // Replace with the actual CAN ID of your motor
    public static final double kIntakeSpeed = 0.5; // Speed to run the intake motor
    public static final double kIntakeReverseSpeed = -0.5; // Speed to run the intake motor in reverse
    public static final double kIntakeStopSpeed = 0.0; // Speed to stop the intake motor
    public static final boolean kIntakeInverted = false; // Whether the intake motor is inverted

  }

  public static final class CANrangeConstants {
    public static final int kCANrangeId = 0;
    public static final String kCANrangeCANbus = "canivore";
      
    
  }
}
