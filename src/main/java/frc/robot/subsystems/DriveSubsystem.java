package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;  // Import CAN TalonSRX
import edu.wpi.first.wpilibj.Encoder;

import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.ADXRS450_Gyro; // Import the Gyro class

public class DriveSubsystem extends SubsystemBase {
  
  // Declare motor controllers for left and right sides of the drive using CAN
  private final TalonSRX leftMotor1 = new TalonSRX(1);  // CAN ID 1 for left motor
  private final TalonSRX leftMotor2 = new TalonSRX(2);  // CAN ID 2 for left motor
  private final TalonSRX rightMotor1 = new TalonSRX(3); // CAN ID 3 for right motor
  private final TalonSRX rightMotor2 = new TalonSRX(4); // CAN ID 4 for right motor
  
  // Group the left and right motors 
  private final MotorControllerGroup leftMotors = new MotorControllerGroup(leftMotor1, leftMotor2);
  private final MotorControllerGroup rightMotors = new MotorControllerGroup(rightMotor1, rightMotor2);

  // DifferentialDrive for controlling the robot (we're using it for tank drive, not arcade)
  private final DifferentialDrive drivetrain = new DifferentialDrive(leftMotors, rightMotors);

  // The left and right encoders
  private final Encoder leftEncoder = new Encoder(0, 1);  
  private final Encoder rightEncoder = new Encoder(2, 3); 

  // Odometry to track robot position
  private final DifferentialDriveOdometry odometry;

  // Gyroscope (assuming you are using the ADXRS450_Gyro)
  private final ADXRS450_Gyro gyro = new ADXRS450_Gyro(); // Declare and instantiate the Gyro

  // Speed value for control (typically between 0.0 and 1.0)
  private double speed = 0.8; 

  public DriveSubsystem() {
    leftMotor1.setInverted(false);
    leftMotor2.setInverted(false);
    rightMotor1.setInverted(true);  // Right motors usually need to be inverted
    rightMotor2.setInverted(true);
    
    leftEncoder.setDistancePerPulse(0.05); // Adjust as needed for your robot's encoder
    rightEncoder.setDistancePerPulse(0.05);
    
    odometry = new DifferentialDriveOdometry(gyro.getRotation2d());
  }

  // Method to drive using tank drive (left and right joystick values)
  public void tankDrive(double leftSpeed, double rightSpeed) {
    drivetrain.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void periodic() {
    // Update odometry every period
    odometry.update(gyro.getRotation2d(), leftEncoder.getDistance(), rightEncoder.getDistance());
  }
}
