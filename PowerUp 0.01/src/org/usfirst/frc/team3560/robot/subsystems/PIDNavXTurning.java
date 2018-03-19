package org.usfirst.frc.team3560.robot.subsystems;

import org.usfirst.frc.team3560.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class PIDNavXTurning extends PIDSubsystem
{

	public PIDController turnController;
	public double rotationRate;

	static final double turnP = 0.03;
	static final double turnI = 0.00;
	static final double turnD = 0.00;
	static final double turnF = 0.00;
	static final double turnToleranceDegrees = 2.0f;

	// Initialize your subsystem here
	public PIDNavXTurning()
	{
		super("NavX TurnController", turnP, turnI, turnD, turnF);
		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		// to
		// enable() - Enables the PID controller.
		setInputRange(-180.0f, 180.0f);
		setOutputRange(-1.0, 1.0);
		setAbsoluteTolerance(turnToleranceDegrees);
		enable();
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	protected double returnPIDInput()
	{
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;
		double yaw = Robot.rNavX.getYaw();
		return yaw;
	}

	protected void usePIDOutput(double output)
	{
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);
		rotationRate = output;
	}

	public void rotateToAngle(double targetAngleDegrees)
	{
		turnController.setSetpoint(targetAngleDegrees);
		double currentRotationRate = rotationRate;
		Robot.rDrivetrain.driveleft(currentRotationRate);
		Robot.rDrivetrain.driveright(-currentRotationRate);
	}
}
