// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Intakesystem;
import com.revrobotics.spark.SparkMax;


public class IntakeCommand extends Command {
  private final Intakesystem intakeSystem; // Reference to the intake system
  private final SparkMax intakeMotor; // CAN motor controller
  private double speed; // Variable to control speed and direction

  /** Creates a new IntakeCommand. */
  public IntakeCommand(Intakesystem intakeSystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.intakeSystem = intakeSystem;
  intakeMotor = new SparkMax(Constants.IntakeConstants.kIntakeMotorPort, MotorType.kBrushed);// new SparkMax(28, MotorType.kBrushed); // Replace 8 with your actual CAN ID for the motor

    addRequirements(intakeSystem); // Make sure the command requires the intake subsystem
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Initialize with forward speed
    speed = 0.5; // Positive speed for forward direction
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Here you can control the motor with CAN commands, setting speed and direction
    intakeMotor.set(speed); // Control motor speed and direction (no need for ControlMode)
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stop the motor when the command ends or is interrupted
    intakeMotor.set(0); // Stop the motor
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false; // Keeps the command running until manually interrupted
  }

  // Method to reverse the direction of the motor
  public void reverseDirection() {
    speed = -speed; // Reverse the direction by negating the speed
  }
}
