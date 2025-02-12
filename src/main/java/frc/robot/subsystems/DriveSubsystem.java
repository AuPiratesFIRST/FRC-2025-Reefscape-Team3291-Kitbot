package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkBaseConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  SparkMax leftLeader;
  SparkMax leftfollower;
  SparkMax rightLeader;
  SparkMax rigthfollower;

  // Declare motor controllers for left and right sides of the drive using CAN
  private final SparkMax leftFrontMotor = new SparkMax(Constants.DriveConstants.kLeftFrontMotorPort,
      MotorType.kBrushless); // CAN ID 1 for left motor
  private final SparkMax leftBackMotor = new SparkMax(Constants.DriveConstants.kLeftBackMotorPort,
      MotorType.kBrushless); // CAN ID 2 for left motor
  private final SparkMax rightFrontMotor = new SparkMax(Constants.DriveConstants.kRightFrontMotorPort,
      MotorType.kBrushless); // CAN ID 3 for right motor
  private final SparkMax rightBackMotor = new SparkMax(Constants.DriveConstants.kRightBackMotorPort,
      MotorType.kBrushless); // CAN ID 4 for right motor

  private SparkMaxConfig globalConfig = new SparkMaxConfig();
  SparkMaxConfig leftBackMotorConfig = new SparkMaxConfig();
  SparkMaxConfig rightFrontMotorConfig = new SparkMaxConfig();
  SparkMaxConfig rightBackMotorConfig = new SparkMaxConfig();

  @SuppressWarnings("deprecation")
  public DriveSubsystem() {
    

    leftLeader = leftFrontMotor;
    rightLeader = rightFrontMotor;

    globalConfig
        .smartCurrentLimit(50)
        .idleMode(IdleMode.kBrake);

    leftBackMotorConfig
        .apply(globalConfig)
        .inverted(true);

    rightFrontMotorConfig
        .apply(globalConfig)
        .inverted(true);

    rightBackMotorConfig
        .apply(globalConfig)
        .inverted(true);

    // Set the motor inversion based on the constants
    leftLeader.configure(globalConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    leftBackMotor.configure(leftBackMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    rightFrontMotor.configure(rightFrontMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    rightBackMotor.configure(rightBackMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    // Set the motor speed to 0 initially (this can be considered as brake mode for
    // SparkMax)
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
