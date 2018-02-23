package org.usfirst.frc.team3560.robot.commands;

import org.usfirst.frc.team3560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveLift extends Command
{

	public MoveLift()
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.rLift);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.rLift.spinLiftMotor(0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		if (Robot.rToolStick.getToolYButton()) {
			Robot.rLift.spinLiftMotor(0.65);
		} else if (Robot.rToolStick.getToolAButton()) {
			Robot.rLift.spinLiftMotor(-0.65);
		} else if (Robot.rToolStick.getToolXButton()) {
			Robot.rLift.spinLiftMotor(0.3);
		} else if (Robot.rToolStick.getToolBButton()) {
			Robot.rLift.spinLiftMotor(-0.3);
		} else {
			Robot.rLift.spinLiftMotor(0);
		}

		if (Robot.rToolStick.getToolYButton()) {
			Robot.rLift.spinLiftMotor(0.65);
		} else if (Robot.rToolStick.getToolAButton()) {
			Robot.rLift.spinLiftMotor(-0.65);
		} else if (Robot.rToolStick.getToolXButton()) {
			Robot.rLift.spinLiftMotor(0.3);
		} else if (Robot.rToolStick.getToolBButton()) {
			Robot.rLift.spinLiftMotor(-0.3);
		} else {
			Robot.rLift.spinLiftMotor(0);
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
		Robot.rLift.spinLiftMotor(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		Robot.rLift.spinLiftMotor(0);
	}
}
