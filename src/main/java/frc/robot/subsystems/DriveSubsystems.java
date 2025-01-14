package frc.main.subsystems 




  public calss DriveSubsystems extends(subsystems){
    // Declare motor controllers
  private final PWMSparkMax leftMotor1 = new PWMSparkMax(0);  // PWM port 0 for left motor
  private final PWMSparkMax leftMotor2 = new PWMSparkMax(1);  // PWM port 1 for left motor
  private final PWMSparkMax rightMotor1 = new PWMSparkMax(2); // PWM port 2 for right motor
  private final PWMSparkMax rightMotor2 = new PWMSparkMax(3); // PWM port 3 for right motor

  // SpeedControllerGroups to group left and right motors
  private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftMotor1, leftMotor2);
  private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightMotor1, rightMotor2);

     private final DifferentialDrive m_drive = new DifferentialDrive(m_leftLeader::set, m_rightLeader::set);

    // The left-side drive encoder
  private final Encoder m_leftEncoder =
      new Encoder(
          DriveConstants.kLeftEncoderPorts[0],
          DriveConstants.kLeftEncoderPorts[1],
          DriveConstants.kLeftEncoderReversed);

  // The right-side drive encoder
  private final Encoder m_rightEncoder =
      new Encoder(
          DriveConstants.kRightEncoderPorts[0],
          DriveConstants.kRightEncoderPorts[1],
          DriveConstants.kRightEncoderReversed);


    public DriveSubsystems() {
private final SpeedcontrollerGroup rightspeedcontroller = new SpeedcontrollerGroup(rightMotor1, rigthMotor2);
private final SpeedcontrollerGroup leftspeedcontroller = new SpeedcontrollerGroup(lefttMotor1, leftMotor2);
    }

  }
