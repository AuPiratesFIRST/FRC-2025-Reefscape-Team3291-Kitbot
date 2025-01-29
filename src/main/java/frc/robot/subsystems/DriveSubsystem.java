package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj.Encoder;

import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.ADXRS450_Gyro; // Import the Gyro class

public class DriveSubsystem extends SubsystemBase {
  
  // Declare motor controllers for left and right sides of the drive
  private final PWMTalonSRX leftMotor1 = new PWMTalonSRX(0);  // PWM port 0 for left motor
  private final PWMTalonSRX leftMotor2 = new PWMTalonSRX(1);  // PWM port 1 for left motor
  private final PWMTalonSRX rightMotor1 = new PWMTalonSRX(2); // PWM port 2 for right motor
  private final PWMTalonSRX rightMotor2 = new PWMTalonSRX(3); // PWM port 3 for right motor
  
  // Group the left and rith motors 
  @SuppressWarnings("removal")
  private final MotorControllerGroup leftMotors = new MotorControllerGroup(leftMotor1, leftMotor2);
  @SuppressWarnings("removal")
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
    leftMotor1.addFollower(leftMotor2);
    rightMotor1.addFollower(leftMotor2);
    // Initialize odometry with gyro and encoder data
    odometry = new DifferentialDriveOdometry(gyro.getRotation2d(), leftEncoder.getDistance(), rightEncoder.getDistance());
  }

  @Override
  public void periodic() {
    // Update odometry periodically using gyro and encoder data
    odometry.update(gyro.getRotation2d(), leftEncoder.getDistance(), rightEncoder.getDistance());
  }

  // Tank drive method: takes separate inputs for left and right motors
  public void tankDrive(double leftSpeed, double rightSpeed) {
    drivetrain.tankDrive(leftSpeed * speed, rightSpeed * speed);
  }
}
