package org.usfirst.frc.team3560.robot.commands;

import org.usfirst.frc.team3560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonReachLine extends Command
{

	public AutonReachLine()
	{
		requires(Robot.rDrivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		/*
		if (Robot.rDrivetrain.encodL.getDistance() < 36) {
			Robot.rDrivetrain.drive(.1);
		} else {
			Robot.rDrivetrain.fullstop();
		}
		*/
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.rDrivetrain.fullstop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		Robot.rDrivetrain.fullstop();
	}
}