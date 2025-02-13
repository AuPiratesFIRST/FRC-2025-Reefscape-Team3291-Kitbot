// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RangeSubsystem;

public class CheckCoralCommand extends CommandBase {
  private final RangeSubsystem rangeSubsystem;
  private final double detectionThreshold;

  /**
   * Creates a new CheckCoralCommand.
   * @param rangeSubsystem The subsystem that provides CANrange data.
   * @param detectionThreshold The distance threshold below which the coral is considered “detected.”
   */
  public CheckCoralCommand(RangeSubsystem rangeSubsystem, double detectionThreshold) {
    this.rangeSubsystem = rangeSubsystem;
    this.detectionThreshold = detectionThreshold;
    addRequirements(rangeSubsystem);
  }

  @Override
  public void initialize() {
    System.out.println("Initializing coral detection...");
  }

  @Override
  public void execute() {
    boolean detected = rangeSubsystem.isObjectDetected();
    double distance = rangeSubsystem.getDistance();

    // If an object is detected and it is within the threshold distance, assume it is coral.
    if (detected && distance < detectionThreshold) {
      System.out.println("Coral detected! Distance: " + distance);
    } else {
      System.out.println("No coral detected. Distance: " + distance);
    }
  }

  @Override
  public boolean isFinished() {
    // This command runs continuously.
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    System.out.println("Coral detection command ended.");
  }
}
