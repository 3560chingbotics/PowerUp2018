package org.usfirst.frc.team3560.robot.subsystems;

import org.usfirst.frc.team3560.robot.ElectricalConstants;
import org.usfirst.frc.team3560.robot.commands.MoveLift;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Lift extends Subsystem
{

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	static final private int bottomClawSwitch = 0;
	static final private int midClawSwitch = 1;
	static final private int topClawSwitch = 2;
	static final private int midLiftSwitch = 3;
	static final private int topLiftSwitch = 4;
	static private int switchCount = 0;
	VictorSP motor1;
	DigitalInput[] switchs;

	public Lift()
	{
		motor1 = new VictorSP(ElectricalConstants.MOTORV_LEFT_LIFT);
		LiveWindow.addActuator("Lift", "Lift Motor", (VictorSP) motor1);
		switchs = new DigitalInput[5];

		switchs[bottomClawSwitch] = new DigitalInput(ElectricalConstants.DI_BOTTOM_CLAW_SWITCH);
		switchs[midClawSwitch] = new DigitalInput(ElectricalConstants.DI_MID_CLAW_SWITCH);
		switchs[topClawSwitch] = new DigitalInput(ElectricalConstants.DI_TOP_CLAW_SWITCH);
		switchs[midLiftSwitch] = new DigitalInput(ElectricalConstants.DI_MID_LIFT_SWITCH);
		switchs[topLiftSwitch] = new DigitalInput(ElectricalConstants.DI_TOP_LIFT_SWITCH);

		LiveWindow.addSensor("Lift", "Bottom Claw Switch", (DigitalInput) switchs[bottomClawSwitch]);
		LiveWindow.addSensor("Lift", "Mid Claw Switch", (DigitalInput) switchs[midClawSwitch]);
		LiveWindow.addSensor("Lift", "Top Claw Switch", (DigitalInput) switchs[topClawSwitch]);
		LiveWindow.addSensor("Lift", "Mid Lift Switch", (DigitalInput) switchs[midLiftSwitch]);
		LiveWindow.addSensor("Lift", "Top Lift Switch", (DigitalInput) switchs[topLiftSwitch]);

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
	}

	public int switchCount()
	{
		return switchCount;
	}

	public void updateSwitchCount()
	{
		if (switchs[bottomClawSwitch].get()) {
			// If the bottom switch is on then switch count is at the bottom claw
			switchCount = bottomClawSwitch;
		} else if (switchs[midClawSwitch].get()) {
			// If the mid switch is on then switch count is at the mid claw
			switchCount = midClawSwitch;
		} else if (switchs[topClawSwitch].get() && !switchs[midLiftSwitch].get() && !switchs[topLiftSwitch].get()) {
			// If the top switch is on and the middle lift switch if off and the top lift
			// switch is off then switch count is at the top claw
			switchCount = topClawSwitch;
		} else if (switchs[midLiftSwitch].get()) {
			// If the middle lift switch is on then switch count is at the middle lift
			switchCount = midLiftSwitch;
		} else if (switchs[topLiftSwitch].get()) {
			// If the top lift is on then switch count is at the top lift
			switchCount = topLiftSwitch;
		} else {
			switchCount = switchCount;
		}
	}

	public void driveLift(int desiredPosition)
	{
		updateSwitchCount();
		if (desiredPosition < switchCount && 4 != switchCount) {
			switchCount++;
			while (!switchs[switchCount].get()) {
				motor1.set(0.368);
			}
		} else if (desiredPosition > switchCount && 0 != switchCount) {
			switchCount--;
			while (!switchs[switchCount].get()) {
				motor1.set(-0.368);
			}
		}

	}
}
