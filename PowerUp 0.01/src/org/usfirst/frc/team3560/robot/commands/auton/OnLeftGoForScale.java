package org.usfirst.frc.team3560.robot.commands.auton;

import org.usfirst.frc.team3560.robot.commands.autoncommands.MoveClawSolenoid;
import org.usfirst.frc.team3560.robot.commands.autoncommands.MoveClawWheels;
import org.usfirst.frc.team3560.robot.commands.autoncommands.MovingInAuton;
import org.usfirst.frc.team3560.robot.commands.autoncommands.MovingLift;
import org.usfirst.frc.team3560.robot.commands.autoncommands.TurnToAngle;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OnLeftGoForScale extends CommandGroup
{

	public OnLeftGoForScale()
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
		addSequential(new MoveClawSolenoid(Value.kForward));
		addParallel(new MovingLift(.368));
		addSequential(new MovingInAuton(8.12, 'y', .2, .2));
		addSequential(new TurnToAngle(90));
		addSequential(new MovingInAuton(0.863, 'y', .2, .2));
		addSequential(new MoveClawWheels(-.5));

	}
}
