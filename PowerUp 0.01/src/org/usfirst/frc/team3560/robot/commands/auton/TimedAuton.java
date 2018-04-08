package org.usfirst.frc.team3560.robot.commands.auton;

import org.usfirst.frc.team3560.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimedAuton extends Command
{

	public TimedAuton()
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.rDrivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.rDrivetrain.startTimer();
		setTimeout(3);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		Robot.rDrivetrain.drive(-.3);
		Timer.delay(2.5);
		Robot.rDrivetrain.fullstop();
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
