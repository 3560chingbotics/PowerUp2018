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

	private WPI_TalonSRX frontLeft, frontRight, backLeft, backRight; // Declare the 4 motors
	private DoubleSolenoid solenoid1; // declare the one solenoid for the gearboxes.
	public AHRS ahrs; // declare the NavX

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

		// Initialise the NavX but if their is an error Report it to the Drivestation
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

	// Controls the left side of the Drivetrain
	public void driveleft(double speed)
	{
		frontLeft.set(speed);
		backLeft.set(speed);
	}

	// Controls the right side of the Drivetrain
	public void driveright(double speed)
	{
		frontRight.set(-speed);
		backRight.set(-speed);
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

	// Used to check if an angle has been reached
	public boolean checkRotationAngle(double kTargetAngleDegrees)
	{
		boolean gyroAngleReached = false;
		// If the angle of the robot has reached the desired angle,
		// the boolean will turn true, if not it will be false
		if (ahrs.getAngle() >= kTargetAngleDegrees) {
			gyroAngleReached = true;
		} else {
			gyroAngleReached = false;
		}
		ahrs.reset();// Reset the angle that is considered 0
		return gyroAngleReached;
	}

	// Used to check if an distance in the X axis has been reached
	public boolean checkDisplacementX(double kTargetDisplacement)
	{
		boolean gyroDisplacementReached = false;
		// If the displacement of the robot has reached the desired distance,
		// the boolean will turn true, if not it will be false
		if (ahrs.getDisplacementX() >= kTargetDisplacement) {
			gyroDisplacementReached = true;
		} else {
			gyroDisplacementReached = false;
		}
		ahrs.resetDisplacement(); // Resets the distance travelled to 0
		return gyroDisplacementReached;
	}

	// Used to check if an distance in the X axis has been reached
	public boolean checkDisplacementY(double kTargetDisplacement)
	{
		boolean gyroDisplacementReached = false;
		// If the displacement of the robot has reached the desired distance,
		// the boolean will turn true, if not it will be false
		if (ahrs.getDisplacementY() >= kTargetDisplacement) {
			gyroDisplacementReached = true;
		} else {
			gyroDisplacementReached = false;
		}
		ahrs.resetDisplacement(); // Resets the distance travelled to 0
		return gyroDisplacementReached;
	}
}
