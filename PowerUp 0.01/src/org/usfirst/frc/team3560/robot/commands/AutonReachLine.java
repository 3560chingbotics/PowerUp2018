package org.usfirst.frc.team3560.robot.commands;

import org.usfirst.frc.team3560.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonReachLine extends Command
{

	public AutonReachLine()
	{
		requires(Robot.rDrivetrain);
		requires(Robot.rClaw);
		requires(Robot.rLift);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		Robot.rClaw.moveSolenoid(Value.kReverse);
		/*while(!Robot.rDrivetrain.checkDisplacementX(3.8))
		{
			Robot.rDrivetrain.drive(0.2);
		}
		*/
		if (Robot.rDrivetrain.checkDisplacementX(3.8)) {
			Robot.rDrivetrain.drive(0);
		} else {
			Robot.rDrivetrain.drive(.2);
		}
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
