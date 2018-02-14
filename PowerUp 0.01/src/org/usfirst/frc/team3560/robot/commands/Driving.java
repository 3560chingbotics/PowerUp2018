package org.usfirst.frc.team3560.robot.commands;

import org.usfirst.frc.team3560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Driving extends Command
{
	private double driveSpeed;
	public double accelX, accelY, accelZ;

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
		/*
				if (Robot.rDriveStick.getJoyTrigger()) {
					Robot.rDrivetrain.lowGearRatio();
				} else {
					Robot.rDrivetrain.highGearRatio();
				}
		*/
		driveSpeed = (Robot.rDriveStick.getSlider());
		if (Robot.rDriveStick.getSlider() > 0.8) {
			driveSpeed = 0.8;
		} else if (Robot.rDriveStick.getSlider() < .1) {
			driveSpeed = .1;
		} else {
			driveSpeed = driveSpeed;
		}

		SmartDashboard.putNumber("Drive Speed", driveSpeed);

		// Tank Drive
		// Robot.rDrivetrain.driveleft((driveSpeed) *
		// Robot.rDriveStick.getDriveLeftY());
		// Robot.rDrivetrain.driveright((driveSpeed) *
		// Robot.rDriveStick.getDriveRightY());

		// Arcade JoyStick Drive Single Stick
		Robot.rDrivetrain.driveleft(driveSpeed * (Robot.rDriveStick.getJoyY() + Robot.rDriveStick.getJoyZ()));
		Robot.rDrivetrain.driveright(driveSpeed * (Robot.rDriveStick.getJoyY() - Robot.rDriveStick.getJoyZ()));

		// Arcade Stick Dual Stick
		// Robot.rDrivetrain.driveleft(driveSpeed * (Robot.rDriveStick.getDriveLeftY() +
		// Robot.rDriveStick.getDriveRightX()));
		// Robot.rDrivetrain.driveright(driveSpeed * (Robot.rDriveStick.getDriveLeftY()
		// - Robot.rDriveStick.getDriveRightX()));

		/*accelX = Robot.rDrivetrain.accel.getX(); // These functions return the acceleration in g forces
		accelY = Robot.rDrivetrain.accel.getY();
		accelZ = Robot.rDrivetrain.accel.getZ();
		
		accelX = accelX * 9.81; // Convert G forces to metres per second per second
		accelY = accelY * 9.81;
		accelZ = accelZ * 9.81;
		
		SmartDashboard.putNumber("Acceleration in X", accelX);
		SmartDashboard.putNumber("Acceleration in Y", accelY);
		SmartDashboard.putNumber("Acceleration in Z", accelZ); */

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
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