package org.usfirst.frc.team3560.robot.commands;

import org.usfirst.frc.team3560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Driving extends Command
{

	public Driving()
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

		Robot.rDrivetrain.checkDriveSpeed();

		// Tank Drive
		// Robot.rDrivetrain.driveleft((driveSpeed) *
		// Robot.rDriveStick.getDriveLeftY());
		// Robot.rDrivetrain.driveright((driveSpeed) *
		// Robot.rDriveStick.getDriveRightY());

		// Arcade JoyStick Drive Single Stick
		if (!Robot.rDriveStick.getJoyLeftCloseRightButton()) {
			Robot.rDrivetrain.driveleft(Robot.rDrivetrain.driveSpeed * (Robot.rDriveStick.getJoyY() - Robot.rDriveStick.getJoyZ()));
			Robot.rDrivetrain.driveright(Robot.rDrivetrain.driveSpeed * (Robot.rDriveStick.getJoyY() + Robot.rDriveStick.getJoyZ()));
		}

		/*if (Robot.rDriveStick.getJoyLeftCloseRightButton()) {
			if (Robot.rDriveStick.getJoyX() > 0) {
				Robot.rDrivetrain.driveleft(Robot.rDrivetrain.driveSpeed * Robot.rDriveStick.getJoyX());
			}
			if (Robot.rDriveStick.getJoyX() < 0) {
				Robot.rDrivetrain.driveright(Robot.rDrivetrain.driveSpeed * Robot.rDriveStick.getJoyX());
			}*/

		// Arcade Stick Dual Stick
		// Robot.rDrivetrain.driveleft(driveSpeed * (Robot.rDriveStick.getDriveLeftY() +
		// Robot.rDriveStick.getDriveRightX()));
		// Robot.rDrivetrain.driveright(driveSpeed * (Robot.rDriveStick.getDriveLeftY()
		// - Robot.rDriveStick.getDriveRightX()));

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		// Robot.rDrivetrain.driveSpeed = 0;
		// Robot.rDrivetrain.fullstop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		Robot.rDrivetrain.driveSpeed = 0;
		Robot.rDrivetrain.fullstop();
	}
}
