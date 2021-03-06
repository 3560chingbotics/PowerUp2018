package org.usfirst.frc.team3560.robot.subsystems;

import org.usfirst.frc.team3560.robot.ElectricalConstants;
import org.usfirst.frc.team3560.robot.commands.MoveClaw;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

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

		LiveWindow.addActuator("Claw", "Left 775", (VictorSP) motor1);
		LiveWindow.addActuator("Claw", "Right 775", (VictorSP) motor2);

		solenoid1 = new DoubleSolenoid(ElectricalConstants.DSOLENOID_CLAW_0, ElectricalConstants.DSOLENOID_CLAW_1);

		LiveWindow.addActuator("Claw", "Claw Solenoid", (DoubleSolenoid) solenoid1);

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
		motor2.set(-speed);
	}

	public void moveSolenoid(Value direction)
	{
		solenoid1.set(direction);
	}

	/*
	public void openSolenoid()
	{
		solenoid1.set(DoubleSolenoid.Value.kForward);
	}
	
	public void closeSolenoid()
	{
		solenoid1.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void offSolenoid()
	{
		solenoid1.set(DoubleSolenoid.Value.kOff);
	}
	*/

}
