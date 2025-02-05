// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Intakesystem;  // Import the intake subsystem
import frc.robot.commands.IntakeCommand;  // Import the command controlling the intake
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private Intakesystem m_intakeSystem = new Intakesystem();  // Declare intake subsystem

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandJoystick m_driverController =
      new CommandJoystick(OperatorConstants.kDriverControllerPort);

  private final SendableChooser<Command> m_chooser = new SendableChooser<>();
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_chooser.setDefaultOption("Default Auto", new Command() {
      @Override
      public void execute() {
        // Do nothing
      }
    });

    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // For tank drive (left and right joystick control)
    m_driveSubsystem.setDefaultCommand(
      new RunCommand(
        () -> m_driveSubsystem.tankDrive(
          m_driverController.getRawAxis(1), // Left joystick Y axis
          m_driverController.getRawAxis(5)), // Right joystick Y axis
        m_driveSubsystem
      )
    );

    // Set up the intake controls:
    // Assuming you want to control the intake with buttons:
    
    // Example button bindings for controlling the intake:
    // (Replace with the button numbers you want to use for your intake)
    
    // Forward intake control (button "a" on the joystick in this case)
    new Trigger(() -> m_driverController.getRawButton(1)) // Button A
        .whileActiveOnce(new IntakeCommand(m_intakeSystem));  // Run the intake forward

    // Reverse intake control (button "b" on the joystick in this case)
    new Trigger(() -> m_driverController.getRawButton(2)) // Button B
        .whileActiveOnce(new IntakeCommand(m_intakeSystem).reverseDirection());  // Run the intake in reverse
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return m_chooser.getSelected();
  }
}
