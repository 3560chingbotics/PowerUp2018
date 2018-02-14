package org.usfirst.frc.team3560.robot.subsystems;

import org.usfirst.frc.team3560.robot.ElectricalConstants;
import org.usfirst.frc.team3560.robot.commands.Driving;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Drivetrain extends Subsystem
{

	private WPI_TalonSRX frontLeft, frontRight, backLeft, backRight;
	public Accelerometer accel;
	// public Encoder encodL, encodR;
	// private DoubleSolenoid solenoid2;
	// private double countsPerRevolution, wheelDiameter;

	public Drivetrain()
	{
		frontLeft = new WPI_TalonSRX(ElectricalConstants.MOTORT_FRONT_LEFT);
		frontRight = new WPI_TalonSRX(ElectricalConstants.MOTORT_FRONT_RIGHT);
		backLeft = new WPI_TalonSRX(ElectricalConstants.MOTORT_BACK_LEFT);
		backRight = new WPI_TalonSRX(ElectricalConstants.MOTORT_BACK_RIGHT);

		LiveWindow.addActuator("Drivetrain", "Front Left CIM", (WPI_TalonSRX) frontLeft);
		LiveWindow.addActuator("Drivetrain", "Front Right CIM", (WPI_TalonSRX) frontRight);
		LiveWindow.addActuator("Drivetrain", "Back Left CIM", (WPI_TalonSRX) backLeft);
		LiveWindow.addActuator("Drivetrain", "Back Right CIM", (WPI_TalonSRX) backRight);

		accel = new BuiltInAccelerometer(Accelerometer.Range.k4G);
		/*
				countsPerRevolution = 20;
				wheelDiameter = 6;
				encodL = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
				encodR = new Encoder(2, 3, true, Encoder.EncodingType.k4X);
		
				encodL.setDistancePerPulse(countsPerRevolution);
				encodR.setDistancePerPulse(countsPerRevolution);
		
				encodL.setDistancePerPulse(findDistancePerPulse());
				encodL.setDistancePerPulse(findDistancePerPulse());
		*/
		// solenoid2 = new DoubleSolenoid(ElectricalConstants.DSOLENOID_LIFT_0,
		// ElectricalConstants.DSOLENOID_LIFT_0);

	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new Driving());
	}

	public void driveleft(double speed)
	{
		frontLeft.set(speed);
		backLeft.set(speed);
	}

	public void driveright(double speed)
	{
		frontRight.set(-speed);
		backRight.set(-speed);
	}

	public void drive(double speed)
	{
		driveleft(speed);
		driveright(speed);
	}

	public void fullstop()
	{
		drive(0);
	}

	/*public int getCountL()
	{
		return encodL.get();
	}
	
	public int getCountR()
	{
		return encodR.get();
	}
	
	public double getRateL()
	{
		return encodL.getRate();
	}
	
	public double getRateR()
	{
		return encodR.getRate();
	}
	
	private double findDistancePerPulse()
	{
		return 1 / (countsPerRevolution * wheelDiameter * Math.PI);
	}
	*/
	/*
		public void lowGearRatio()
		{
			solenoid2.set(DoubleSolenoid.Value.kReverse);
		}
	
		public void highGearRatio()
		{
			solenoid2.set(DoubleSolenoid.Value.kForward);
		}
		*/

}
