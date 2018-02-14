package org.usfirst.frc.team3560.robot.commands;

import org.usfirst.frc.team3560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveClaw extends Command
{

	double spinSpeed = 0.5;

	public MoveClaw()
	{
		requires(Robot.rClaw);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		System.out.println("C Current" + Robot.rClaw.compressor.getCompressorCurrent());
		System.out.println("Pressure Switch" + Robot.rClaw.compressor.getPressureSwitchValue());

		Robot.rClaw.rotateWheels(Robot.rToolStick.getToolLeftY() * spinSpeed);

		if (Robot.rToolStick.getToolAButton()) {
			Robot.rClaw.openSolenoid();
		} else if (Robot.rToolStick.getToolBButton()) {
			Robot.rClaw.closeSolenoid();
		} else if (Robot.rToolStick.getToolYButton()) {
			Robot.rClaw.offSolenoid();
		} else {
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
		Robot.rClaw.rotateWheels(0);
		Robot.rClaw.offSolenoid();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		Robot.rClaw.rotateWheels(0);
		Robot.rClaw.offSolenoid();
	}
}
