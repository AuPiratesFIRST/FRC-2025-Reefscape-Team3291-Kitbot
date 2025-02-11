package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  // Declare motor controllers for left and right sides of the drive using CAN
  private final CANSparkMax leftFrontMotor = new CANSparkMax(Constants.DriveConstants.kLeftFrontMotorPort, MotorType.kBrushless); // CAN ID 1 for left motor
  private final CANSparkMax leftBackMotor = new CANSparkMax(Constants.DriveConstants.kLeftBackMotorPort, MotorType.kBrushless); // CAN ID 2 for left motor
  private final CANSparkMax rightFrontMotor = new CANSparkMax(Constants.DriveConstants.kRightFrontMotorPort, MotorType.kBrushless); // CAN ID 3 for right motor
  private final CANSparkMax rightBackMotor = new CANSparkMax(Constants.DriveConstants.kRightBackMotorPort, MotorType.kBrushless); // CAN ID 4 for right motor

  public DriveSubsystem() {
    // Set the motor inversion based on the constants
    leftFrontMotor.setInverted(Constants.DriveConstants.leftInverted);
    leftBackMotor.setInverted(Constants.DriveConstants.leftInverted);
    rightFrontMotor.setInverted(Constants.DriveConstants.rightInverted);
    rightBackMotor.setInverted(Constants.DriveConstants.rightInverted);

    leftBackMotor.follow(leftFrontMotor); // Set left back motor to follow left front motor
    rightBackMotor.follow(rightFrontMotor); // Set right back motor to follow right front motor

    // Set the motor speed to 0 initially (this can be considered as brake mode for SparkMax)
    leftFrontMotor.set(0);
    rightFrontMotor.set(0);
  }

  // Method to drive using tank drive (left and right joystick values)
  public void tankDrive(double leftSpeed, double rightSpeed) {
    // Set the motor speeds based on joystick input
    leftFrontMotor.set(leftSpeed * Constants.DriveConstants.maxSpeed);
    rightFrontMotor.set(rightSpeed * Constants.DriveConstants.maxSpeed);
  }

  @Override
  public void periodic() {
    // Optional: Add any periodic code that needs to run
  }
}
