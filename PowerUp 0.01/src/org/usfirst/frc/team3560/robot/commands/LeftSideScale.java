package org.usfirst.frc.team3560.robot.commands;

import org.usfirst.frc.team3560.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LeftSideScale extends Command
{

	public LeftSideScale()
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
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
		if (Robot.rDrivetrain.checkDisplacementX(3.8)) {
			Robot.rDrivetrain.drive(0);
		} else {
			Robot.rDrivetrain.drive(.2);
		}

		if (Robot.rDrivetrain.checkRotationAngle(90)) {
			Robot.rDrivetrain.driveleft(0);
		} else {
			Robot.rDrivetrain.driveleft(.2);
		}

		if (Robot.rDrivetrain.checkDisplacementY(1.1)) {
			Robot.rDrivetrain.drive(0);
		} else {
			Robot.rDrivetrain.drive(.2);
		}

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
