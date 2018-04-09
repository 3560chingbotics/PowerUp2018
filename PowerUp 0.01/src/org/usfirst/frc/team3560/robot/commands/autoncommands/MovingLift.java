package org.usfirst.frc.team3560.robot.commands.autoncommands;

import org.usfirst.frc.team3560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MovingLift extends Command
{

	double speed, timeOut;
	int desiredPosition;

	public MovingLift(double speed, double timeOut)
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.rLift);
		this.speed = speed;
		this.timeOut = timeOut;
		// this.desiredPosition = desiredPosition
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		setTimeout(timeOut);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		Robot.rLift.spinLiftMotor(.9);
		// Robot.rLift.driveLift(Lift.topLiftSwitch);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}
}
