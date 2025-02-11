package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  // Declare motor controllers for left and right sides of the drive using CAN
  private final SparkMax leftFrontMotor = new SparkMax(Constants.DriveConstants.kLeftFrontMotorPort, MotorType.kBrushless); // CAN ID 1 for left motor
  private final SparkMax leftBackMotor = new SparkMax(Constants.DriveConstants.kLeftBackMotorPort, MotorType.kBrushless); // CAN ID 2 for left motor
  private final SparkMax rightFrontMotor = new SparkMax(Constants.DriveConstants.kRightFrontMotorPort, MotorType.kBrushless); // CAN ID 3 for right motor
  private final SparkMax rightBackMotor = new SparkMax(Constants.DriveConstants.kRightBackMotorPort, MotorType.kBrushless); // CAN ID 4 for right motor

  public DriveSubsystem() {
    // Set the motor inversion based on the constants
    leftFrontMotor.setInverted(Constants.DriveConstants.leftInverted);
    leftBackMotor.setInverted(Constants.DriveConstants.leftInverted);
    rightFrontMotor.setInverted(Constants.DriveConstants.rightInverted);
    rightBackMotor.setInverted(Constants.DriveConstants.rightInverted);

  // leftBackMotor. addFollower(leftFrontMotor);  
  leftBackMotor.isFollower();
  rightBackMotor.isFollower(); 

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
