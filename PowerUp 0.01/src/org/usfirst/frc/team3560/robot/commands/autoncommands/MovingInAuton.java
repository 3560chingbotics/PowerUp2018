package org.usfirst.frc.team3560.robot.commands.autoncommands;

import org.usfirst.frc.team3560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MovingInAuton extends Command
{

	private double timeOut;
	private char direction;
	private double leftSpeed, rightSpeed;

	public MovingInAuton(double timeOut, char direction, double leftSpeed, double rightSpeed)
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.rDrivetrain);
		this.timeOut = timeOut;
		this.direction = direction;
		this.leftSpeed = leftSpeed;
		this.rightSpeed = rightSpeed;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		this.setTimeout(timeOut);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		if (direction == 't') {
			Robot.rDrivetrain.driveleft(leftSpeed);
			Robot.rDrivetrain.driveright(rightSpeed);
		}
		// Robot.rPIDNavXMoving.moveDisplacementX(desiredPosition);
		/*
		if (direction == 'x') {
			if (!Robot.rNavX.moveDisplacementX(desiredPosition)) {
				Robot.rDrivetrain.driveleft(leftSpeed);
				Robot.rDrivetrain.driveright(rightSpeed);
			} else {
				Robot.rDrivetrain.driveleft(0);
				Robot.rDrivetrain.driveright(0);
			}
		}
		} else if (direction == 'y') {
		if (!Robot.rNavX.checkDisplacementY(desiredPosition)) {
			Robot.rDrivetrain.driveleft(leftSpeed);
			Robot.rDrivetrain.driveright(rightSpeed);
		} else {
			Robot.rDrivetrain.driveleft(0);
			Robot.rDrivetrain.driveright(0);
		}
		} else if (direction == 'z') {
		if (!Robot.rNavX.checkDisplacementZ(desiredPosition)) {
			Robot.rDrivetrain.driveleft(leftSpeed);
			Robot.rDrivetrain.driveright(rightSpeed);
		} else {
			Robot.rDrivetrain.driveleft(0);
			Robot.rDrivetrain.driveright(0);
		}
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
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}
}
