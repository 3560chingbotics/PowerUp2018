package org.usfirst.frc.team3560.robot.subsystems;

import org.usfirst.frc.team3560.robot.ElectricalConstants;
import org.usfirst.frc.team3560.robot.commands.MoveClaw;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem
{
	private VictorSP motor1, motor2;
	private DoubleSolenoid solenoid1;
	public Compressor compressor;

	public Claw()
	{
		motor1 = new VictorSP(ElectricalConstants.MOTORV_LEFT_CLAW);
		motor2 = new VictorSP(ElectricalConstants.MOTORV_RIGHT_CLAW);

		solenoid1 = new DoubleSolenoid(ElectricalConstants.DSOLENOID_CLAW_0, ElectricalConstants.DSOLENOID_CLAW_1);
		compressor = new Compressor();
		compressor.setClosedLoopControl(true);
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new MoveClaw());
	}

	public void rotateWheels(double speed)
	{
		motor1.set(speed);
		motor2.set(speed);
	}

	public void moveSolenoid(Value direction)
	{
		solenoid1.set(direction);
	}

}
