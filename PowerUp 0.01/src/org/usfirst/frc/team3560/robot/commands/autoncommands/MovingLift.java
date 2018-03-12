package org.usfirst.frc.team3560.robot.commands.autoncommands;

import org.usfirst.frc.team3560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MovingLift extends Command
{

	double speed;
	int desiredPosition;

	public MovingLift(double speed/*,double desiredPosition*/)
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.rLift);
		this.speed = speed;
		// this.desiredPosition = desiredPosition
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.rDrivetrain.startTimer();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		while (!Robot.rDrivetrain.timeDone(5)) {
			Robot.rLift.spinLiftMotor(.368);
		}
		// Robot.rLift.driveLift(Lift.topLiftSwitch);
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
