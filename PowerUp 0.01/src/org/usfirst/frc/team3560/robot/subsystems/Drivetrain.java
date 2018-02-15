package org.usfirst.frc.team3560.robot.subsystems;

import org.usfirst.frc.team3560.robot.ElectricalConstants;
import org.usfirst.frc.team3560.robot.commands.Driving;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Drivetrain extends Subsystem
{

	private WPI_TalonSRX frontLeft, frontRight, backLeft, backRight;
	private DoubleSolenoid solenoid1;
	public AHRS ahrs;

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

		solenoid1 = new DoubleSolenoid(ElectricalConstants.DSOLENOID_GEARBOX_0, ElectricalConstants.DSOLENOID_GEARBOX_1);

		try {
			/* Communicate w/navX-MXP via the MXP SPI Bus.                                     */
			/* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
			/* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
			ahrs = new AHRS(SerialPort.Port.kMXP);
		} catch (RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX-MXP:" + ex.getMessage(), true);
		}

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

	public void changeGearRatio(Value direction)
	{
		solenoid1.set(direction);
	}

	public boolean checkRotationAngle(double kTargetAngleDegrees)
	{
		boolean gyroAngleReached = false;
		if (ahrs.getAngle() == kTargetAngleDegrees) {
			gyroAngleReached = true;
		} else {
			gyroAngleReached = false;
		}
		ahrs.reset();
		return gyroAngleReached;
	}

	public boolean checkDisplacementX(double kTargetDisplacement)
	{
		boolean gyroDisplacementReached = false;
		if (ahrs.getDisplacementX() == kTargetDisplacement) {
			gyroDisplacementReached = true;
		} else {
			gyroDisplacementReached = false;
		}
		ahrs.resetDisplacement();
		return gyroDisplacementReached;
	}

	public boolean checkDisplacementY(double kTargetDisplacement)
	{
		boolean gyroDisplacementReached = false;
		if (ahrs.getDisplacementY() == kTargetDisplacement) {
			gyroDisplacementReached = true;
		} else {
			gyroDisplacementReached = false;
		}
		ahrs.resetDisplacement();
		return gyroDisplacementReached;
	}
}
