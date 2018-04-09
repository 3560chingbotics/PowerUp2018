package org.usfirst.frc.team3560.robot.commands.auton;

import org.usfirst.frc.team3560.robot.commands.autoncommands.MoveClawSolenoid;
import org.usfirst.frc.team3560.robot.commands.autoncommands.MoveClawWheels;
import org.usfirst.frc.team3560.robot.commands.autoncommands.MovingInAuton;
import org.usfirst.frc.team3560.robot.commands.autoncommands.MovingLift;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class TimedSwitch extends CommandGroup
{

	public TimedSwitch()
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
		addParallel(new MoveClawSolenoid(Value.kReverse, .1));
		addSequential(new WaitCommand(5));
		addSequential(new MovingLift(.7, .05));
		addSequential(new MovingLift(0, .05));
		addSequential(new MovingLift(-.65, .05));
		addSequential(new MovingLift(0, .05));
		addParallel(new MoveClawSolenoid(Value.kForward, .1));
		addSequential(new MovingLift(.9, .25));
		addSequential(new MovingLift(0, .25));
		addSequential(new MovingInAuton(1.75, 't', .3, .3));
		addSequential(new MovingInAuton(0.1, 't', 0, 0));
		addSequential(new MoveClawWheels(0.7, 0.5));
		addSequential(new MoveClawWheels(0, 0.5));
		addSequential(new MoveClawSolenoid(Value.kReverse, .1));

	}
}
