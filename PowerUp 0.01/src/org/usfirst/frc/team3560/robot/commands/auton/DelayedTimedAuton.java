package org.usfirst.frc.team3560.robot.commands.auton;

import org.usfirst.frc.team3560.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DelayedTimedAuton extends Command
{

	public DelayedTimedAuton()
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.rDrivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.rDrivetrain.fullstop();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		Timer.delay(4);
		Robot.rDrivetrain.driveleft(-.325);
		Robot.rDrivetrain.driveright(-.35);
		Timer.delay(3.5);
		Robot.rDrivetrain.fullstop();

		/*if (Robot.rDrivetrain.getTime() <= 9 && Robot.rDrivetrain.getTime() >= 12) {
			Robot.rDrivetrain.drive(0);
		} else {
			Robot.rDrivetrain.drive(-.25);
		}*/
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return true;
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
		Robot.rDrivetrain.drive(0);
	}
}
