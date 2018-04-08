package org.usfirst.frc.team3560.robot.commands.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OnLeftGoForSwitch extends CommandGroup
{

	public OnLeftGoForSwitch()
	{
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
		/*
				addParallel(new MoveClawWheels(-.5));
				//addSequential(new MoveClawSolenoid(Value.kForward));
				addSequential(new MovingInAuton(3.28, 'x', .2, .2));
				// addParallel(new MovingLift(.5,));
				addSequential(new MovingInAuton(.3, 'x', .2, .2));
				addSequential(new MoveClawSolenoid(Value.kReverse));
				*/
	}
}
