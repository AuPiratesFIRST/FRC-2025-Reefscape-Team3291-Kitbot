package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax; // For PWM motor controllers like Spark Max or Victor
import edu.wpi.first.wpilibj.DigitalInput; // For sensors (e.g., limit switches or beam break sensors)
import edu.wpi.first.wpilibj.XboxController; // For operator input
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; // For telemetry

public class Robot extends TimedRobot {
    // Motor controller for intake
    private final PWMSparkMax intakeMotor = new PWMSparkMax(2); // Change port to match your setup

    // Sensor to detect game pieces
   // private final DigitalInput objectSensor = new DigitalInput(0); // DIO port 0 for sensor

    // Xbox controller for operator input
    private final Controller controller = new Controller(0); // USB port 0

    @Override
    public void robotInit() {
        // Optional: Invert motor direction if needed
        intakeMotor.setInverted(false);

        // Display initial telemetry
        SmartDashboard.putBoolean("Object Detected", objectSensor.get());
        SmartDashboard.putNumber("Intake Motor Speed", 0);
    }

    @Override
    public void teleopPeriodic() {
        double intakeSpeed = 0;

        // Operator controls
        if (controller.getAButton()) {
            // Run intake in forward direction
            intakeSpeed = 0.8; // 80% power
        } else if (controller.getBButton()) {
            // Reverse intake to eject
            intakeSpeed = -0.8; // -80% power
       /* } else if (!objectSensor.get()) {
            // Stop motor if game piece is detected
            intakeSpeed = 0;
     */
        }

        // Set motor speed
        intakeMotor.set(intakeSpeed);

        // Update telemetry
        SmartDashboard.putBoolean("Object Detected", objectSensor.get());
        SmartDashboard.putNumber("Intake Motor Speed", intakeSpeed);
    }

    @Override
    public void autonomousPeriodic() {
        // Example: Automatic intake operation in autonomous
        if (!objectSensor.get()) {
            intakeMotor.set(0); // Stop intake if a game piece is detected
        } else {
            intakeMotor.set(0.5); // Run intake at 50% power
        }
    }

    @Override
    public void disabledInit() {
        // Stop motor when robot is disabled
        intakeMotor.stopMotor();
    }
}
