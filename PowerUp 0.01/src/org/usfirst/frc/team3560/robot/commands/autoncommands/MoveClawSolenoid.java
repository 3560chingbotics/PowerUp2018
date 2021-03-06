package org.usfirst.frc.team3560.robot.commands.autoncommands;

import org.usfirst.frc.team3560.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveClawSolenoid extends Command
{

	Value direction;
	double timeOut;

	public MoveClawSolenoid(Value direction, double timeOut)
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.rClaw);
		this.direction = direction;
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
		Robot.rClaw.moveSolenoid(direction);
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
