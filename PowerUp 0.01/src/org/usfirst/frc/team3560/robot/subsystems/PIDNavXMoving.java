package org.usfirst.frc.team3560.robot.subsystems;

import org.usfirst.frc.team3560.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class PIDNavXMoving extends PIDSubsystem
{

	public double moveRate;
	static final double moveP = 0.03;
	static final double moveI = 0.00;
	static final double moveD = 0.00;
	static final double moveF = 0.00;
	static final double moveToleranceMetres = 0.1f;

	// Initialize your subsystem here
	public PIDNavXMoving()
	{
		super("NavX MoveController", moveP, moveI, moveD, moveF);
		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		// to
		// enable() - Enables the PID controller.
		setInputRange(-20, 20);
		setOutputRange(-1.0, 1.0);
		setAbsoluteTolerance(moveToleranceMetres);
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
		double displacement = Robot.rNavX.getDisplacementX();
		return displacement;
	}

	protected void usePIDOutput(double output)
	{
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);
		moveRate = output;
	}

	public void moveDisplacementX(double desiredPosition)
	{
		setSetpoint(desiredPosition);
		Robot.rDrivetrain.driveleft(moveRate);
		Robot.rDrivetrain.driveright(moveRate);
		System.out.println(moveRate);
	}
}
