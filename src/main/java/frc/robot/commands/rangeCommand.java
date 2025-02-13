// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.range;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class rangeCommand extends Command {
  /** Creates a new EmptyCommand. */
  public rangeCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    m_bRange1 = m_range1.getIsDetected().getValue();
    m_GE_bRange1.setBoolean(m_bRange1);
    if (m_bRange1) {
        m_GE_distRange1.setDouble(m_range1.getDistance().getValueAsDouble());
    } else {
        m_GE_distRange1.setDouble(0.0);
    }}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
