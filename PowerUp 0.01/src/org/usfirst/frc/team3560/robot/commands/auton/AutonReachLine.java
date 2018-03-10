package org.usfirst.frc.team3560.robot.commands.auton;

import org.usfirst.frc.team3560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonReachLine extends Command
{
	double timeOut;

	public AutonReachLine()
	{
		this.timeOut = timeOut;
		requires(Robot.rDrivetrain);
		requires(Robot.rClaw);
		requires(Robot.rLift);

	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		this.setTimeout(timeOut);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		// Robot.rClaw.moveSolenoid(Value.kReverse);
		while (!Robot.rDrivetrain.checkDisplacementY(1)) {
			Robot.rDrivetrain.drive(0.2);
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
