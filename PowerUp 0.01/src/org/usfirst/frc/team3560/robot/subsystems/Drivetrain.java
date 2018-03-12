package org.usfirst.frc.team3560.robot.subsystems;

import org.usfirst.frc.team3560.robot.ElectricalConstants;
import org.usfirst.frc.team3560.robot.commands.Driving;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Drivetrain extends Subsystem
{

	private WPI_TalonSRX frontLeft, frontRight, backLeft, backRight; // Declare the 4 motors
	private DoubleSolenoid solenoid1; // declare the one solenoid for the gearboxes.
	private Timer time;

	public Drivetrain()
	{
		// Initialise the 4 motors to their Can values on ElectricalConstants
		frontLeft = new WPI_TalonSRX(ElectricalConstants.MOTORT_FRONT_LEFT);
		frontRight = new WPI_TalonSRX(ElectricalConstants.MOTORT_FRONT_RIGHT);
		backLeft = new WPI_TalonSRX(ElectricalConstants.MOTORT_BACK_LEFT);
		backRight = new WPI_TalonSRX(ElectricalConstants.MOTORT_BACK_RIGHT);

		// Add the 4 motors to the drive station
		LiveWindow.addActuator("Drivetrain", "Front Left CIM", (WPI_TalonSRX) frontLeft);
		LiveWindow.addActuator("Drivetrain", "Front Right CIM", (WPI_TalonSRX) frontRight);
		LiveWindow.addActuator("Drivetrain", "Back Left CIM", (WPI_TalonSRX) backLeft);
		LiveWindow.addActuator("Drivetrain", "Back Right CIM", (WPI_TalonSRX) backRight);

		// Initialise the claw solenoid
		solenoid1 = new DoubleSolenoid(ElectricalConstants.DSOLENOID_GEARBOX_0, ElectricalConstants.DSOLENOID_GEARBOX_1);

		// Add the solenoid to the drive station
		LiveWindow.addActuator("Drivetrain", "Gearbox Solenoids", (DoubleSolenoid) solenoid1);

		time = new Timer();

	}

	public void initDefaultCommand()
	{

		setDefaultCommand(new Driving());
	}

	// Controls the left side of the Drivetrain
	public void driveleft(double speed)
	{
		frontLeft.set(-speed);
		backLeft.set(-speed);
	}

	// Controls the right side of the Drivetrain
	public void driveright(double speed)
	{
		frontRight.set(speed);
		backRight.set(speed);
	}

	// Controls both side but can only go forward
	public void drive(double speed)
	{
		driveleft(speed);
		driveright(speed);
	}

	// Stops the Robot
	public void fullstop()
	{
		drive(0);
	}

	// Controls the solenoid for the Gearbox
	public void changeGearRatio(Value direction)
	{
		solenoid1.set(direction);
	}

	public void startTimer()
	{
		time.reset();
		time.start();
	}

	public double getTime()
	{
		return time.get();
	}

	public boolean timeDone(double finishedTime)
	{
		return time.get() > finishedTime;
	}
}
