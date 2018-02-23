package org.usfirst.frc.team3560.robot.commands;

import org.usfirst.frc.team3560.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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

		if (Robot.rToolStick.getToolLeftTrigger()) {
			Robot.rClaw.moveSolenoid(Value.kForward);
		} else if (Robot.rToolStick.getToolRightTrigger()) {
			Robot.rClaw.moveSolenoid(Value.kReverse);
		} else if (Robot.rToolStick.getToolLeftBumper()) {
			Robot.rClaw.moveSolenoid(Value.kOff);
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
		Robot.rClaw.moveSolenoid(Value.kOff);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		Robot.rClaw.rotateWheels(0);
		Robot.rClaw.moveSolenoid(Value.kOff);
	}
}
