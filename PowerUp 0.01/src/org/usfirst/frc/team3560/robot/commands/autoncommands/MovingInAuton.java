package org.usfirst.frc.team3560.robot.commands.autoncommands;

import org.usfirst.frc.team3560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MovingInAuton extends Command
{

	private double desiredPosition;
	private char direction;
	private double leftSpeed, rightSpeed;

	public MovingInAuton(double desiredPosition, char direction, double leftSpeed, double rightSpeed)
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.rDrivetrain);

		this.desiredPosition = desiredPosition;
		this.direction = direction;
		this.leftSpeed = leftSpeed;
		this.rightSpeed = rightSpeed;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{

		if (direction == 'x') {
			while (!Robot.rNavX.checkDisplacementX(desiredPosition)) {
				Robot.rDrivetrain.driveleft(leftSpeed);
				Robot.rDrivetrain.driveright(rightSpeed);
			}
			while (Robot.rNavX.checkDisplacementX(desiredPosition)) {
				Robot.rDrivetrain.driveleft(0);
				Robot.rDrivetrain.driveright(0);
			}
		} else if (direction == 'y') {
			while (!Robot.rNavX.checkDisplacementY(desiredPosition)) {
				Robot.rDrivetrain.driveleft(leftSpeed);
				Robot.rDrivetrain.driveright(rightSpeed);
			}
			while (Robot.rNavX.checkDisplacementY(desiredPosition)) {
				Robot.rDrivetrain.driveleft(0);
				Robot.rDrivetrain.driveright(0);
			}
		} else if (direction == 'z') {
			while (!Robot.rNavX.checkDisplacementZ(desiredPosition)) {
				Robot.rDrivetrain.driveleft(leftSpeed);
				Robot.rDrivetrain.driveright(rightSpeed);
			}
			while (Robot.rNavX.checkDisplacementZ(desiredPosition)) {
				Robot.rDrivetrain.driveleft(0);
				Robot.rDrivetrain.driveright(0);
			}
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
