package org.usfirst.frc.team3560.robot.subsystems;

import org.usfirst.frc.team3560.robot.ElectricalConstants;
import org.usfirst.frc.team3560.robot.commands.MoveLift;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem
{

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	VictorSP motor1, motor2;

	public Lift()
	{
		motor1 = new VictorSP(ElectricalConstants.MOTORV_LEFT_LIFT);
		motor2 = new VictorSP(ElectricalConstants.MOTORV_RIGHT_LIFT);
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new MoveLift());
	}

	public void spinLiftMotor(double speed)
	{
		motor1.set(speed);
		motor2.set(-speed);
	}
}
