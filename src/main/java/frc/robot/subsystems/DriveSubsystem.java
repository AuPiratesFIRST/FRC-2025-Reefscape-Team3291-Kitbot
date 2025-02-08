package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  // Declare motor controllers for left and right sides of the drive using CAN
  private final VictorSPX leftFrontMotor = new VictorSPX(Constants.DriveConstants.kLeftFrontMotorPort); // CAN ID 1 for
                                                                                                        // left motor
  private final VictorSPX leftBackMotor = new VictorSPX(Constants.DriveConstants.kLeftBackMotorPort); // CAN ID 2 for
                                                                                                      // left motor
  private final VictorSPX rightFrontMotor = new VictorSPX(Constants.DriveConstants.kRightFrontMotorPort); // CAN ID 3
                                                                                                          // for right
                                                                                                          // motor
  private final VictorSPX rightBackMotor = new VictorSPX(Constants.DriveConstants.kRightBackMotorPort); // CAN ID 4 for
                                                                                                        // right motor

  public DriveSubsystem() {
    // Set the motor inversion based on the constants
    leftFrontMotor.setInverted(Constants.DriveConstants.leftInverted);
    leftBackMotor.setInverted(Constants.DriveConstants.leftInverted);
    rightFrontMotor.setInverted(Constants.DriveConstants.rightInverted);
    rightBackMotor.setInverted(Constants.DriveConstants.rightInverted);

    leftBackMotor.follow(leftFrontMotor); // Set left back motor to follow left front motor
    rightBackMotor.follow(rightFrontMotor); // Set right back motor to follow right front motor

    // Set the motor speed to 0 initially
    leftFrontMotor.set(VictorSPXControlMode.PercentOutput, Constants.DriveConstants.brakeSpeed);
    rightFrontMotor.set(VictorSPXControlMode.PercentOutput, Constants.DriveConstants.brakeSpeed);
  }

  // Method to drive using tank drive (left and right joystick values)
  public void tankDrive(double leftSpeed, double rightSpeed) {
    // Set the motor speeds based on joystick input
    leftFrontMotor.set(VictorSPXControlMode.PercentOutput, leftSpeed * Constants.DriveConstants.maxSpeed);
    rightFrontMotor.set(VictorSPXControlMode.PercentOutput, rightSpeed * Constants.DriveConstants.maxSpeed);
  }

  @Override
  public void periodic() {
  }
}
