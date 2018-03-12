package org.usfirst.frc.team3560.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class NavX extends Subsystem
{

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public AHRS ahrs; // declare the NavX

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void NavX()
	{
		// Initialise the NavX but if their is an error Report it to the Drivestation
		try {
			/* Communicate w/navX-MXP via the MXP SPI Bus.                                     */
			/* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
			/* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
			ahrs = new AHRS(SerialPort.Port.kMXP);
			// ahrs = new AHRS(I2C.Port.kMXP);
		} catch (RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX-MXP:" + ex.getMessage(), true);
		}
	}

	public void displayNavXData()
	{
		if (ahrs != null) {
			SmartDashboard.putBoolean("IMU_Connected", ahrs.isConnected());
			SmartDashboard.putBoolean("IMU_IsCalibrating", ahrs.isCalibrating());
			SmartDashboard.putNumber("IMU_Yaw", ahrs.getYaw());
			SmartDashboard.putNumber("IMU_Pitch", ahrs.getPitch());
			SmartDashboard.putNumber("IMU_Roll", ahrs.getRoll());
		}
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
		if (Math.abs(ahrs.getDisplacementX()) >= kTargetDisplacement) {
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
		if (Math.abs(ahrs.getDisplacementY()) >= kTargetDisplacement) {
			gyroDisplacementReached = true;
		} else {
			gyroDisplacementReached = false;
		}
		ahrs.resetDisplacement(); // Resets the distance travelled to 0
		return gyroDisplacementReached;
	}

	public boolean checkDisplacementZ(double kTargetDisplacement)
	{
		boolean gyroDisplacementReached = false;
		// If the displacement of the robot has reached the desired distance,
		// the boolean will turn true, if not it will be false
		if (Math.abs(ahrs.getDisplacementZ()) >= kTargetDisplacement) {
			gyroDisplacementReached = true;
		} else {
			gyroDisplacementReached = false;
		}
		// ahrs.resetDisplacement(); // Resets the distance travelled to 0
		return gyroDisplacementReached;
	}

}
