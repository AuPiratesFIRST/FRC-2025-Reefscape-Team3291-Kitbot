package frc.main.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  
  // Declare motor controllers for left and right sides of the drive
  private final PWMSparkMax leftMotor1 = new PWMSparkMax(0);  // PWM port 0 for left motor
  private final PWMSparkMax leftMotor2 = new PWMSparkMax(1);  // PWM port 1 for left motor
  private final PWMSparkMax rightMotor1 = new PWMSparkMax(2); // PWM port 2 for right motor
  private final PWMSparkMax rightMotor2 = new PWMSparkMax(3); // PWM port 3 for right motor

  // SpeedControllerGroups to group left and right motors
  private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftMotor1, leftMotor2);
  private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightMotor1, rightMotor2);

  // DifferentialDrive for controlling the robot
  private final DifferentialDrive drivetrain = new DifferentialDrive(leftMotors, rightMotors);

  // The left and right encoders
  private final Encoder leftEncoder = new Encoder(0, 1);  
  private final Encoder rightEncoder = new Encoder(2, 3); 

  // Odometry to track robot position
  private final DifferentialDriveOdometry odometry;

  // Joystick for controlling the robot
  private final Joystick joystick = new Joystick(0);

  public  Double speed;

  public DriveSubsystem() {

    speed= 0.8;
    
    // Initialize odometry with gyro and encoder data (assuming you have a gyro)
    odometry = new DifferentialDriveOdometry(gyro.getRotation2d(), leftEncoder.getDistance(), rightEncoder.getDistance());
  }

  @Override
  public void periodic() {
    // Update odometry periodically
    odometry.update(gyro.getRotation2d(), leftEncoder.getDistance(), rightEncoder.getDistance());
  }

  
  }

}
