package org.usfirst.frc.team3560.robot.commands.autoncommands;

import org.usfirst.frc.team3560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnToAngle extends Command
{

	double desiredAngle;

	public TurnToAngle(double desiredAngle)
	{
		requires(Robot.rDrivetrain);

		this.desiredAngle = desiredAngle;

	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		// Robot.rNavX.rotateToAngle(desiredAngle);
		Robot.rPIDNavXTurning.rotateToAngle(desiredAngle);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
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
