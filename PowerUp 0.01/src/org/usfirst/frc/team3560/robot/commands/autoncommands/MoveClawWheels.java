package org.usfirst.frc.team3560.robot.commands.autoncommands;

import org.usfirst.frc.team3560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveClawWheels extends Command
{

	double speed, timeOut;

	public MoveClawWheels(double speed, double timeOut)
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.rClaw);
		this.speed = speed;
		this.timeOut = timeOut;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		this.setTimeout(timeOut);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		Robot.rClaw.rotateWheels(speed);
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
