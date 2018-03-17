package org.usfirst.frc.team3560.robot.subsystems;

import org.usfirst.frc.team3560.robot.Robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class NavX extends Subsystem implements PIDOutput
{

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public AHRS ahrs; // declare the NavX
	public PIDController turnController;
	private double rotationRate;

	static final double P = 0.03;
	static final double I = 0.00;
	static final double D = 0.00;
	static final double F = 0.00;
	static final double toleranceDegrees = 2.0f;

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public NavX()
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

		turnController = new PIDController(P, I, D, F, ahrs, this);
		turnController.setInputRange(-180.0f, 180.0f);
		turnController.setOutputRange(-1.0, 1.0);
		turnController.setAbsoluteTolerance(toleranceDegrees);
		turnController.setContinuous(true);
		LiveWindow.addActuator("DriveSystem", "RotateController", turnController);

	}

	public void displayNavXData()
	{
		if (ahrs != null) {
			SmartDashboard.putBoolean("Connected", ahrs.isConnected());
			SmartDashboard.putBoolean("IsCalibrating", ahrs.isCalibrating());
			SmartDashboard.putNumber("Yaw", ahrs.getYaw());
			SmartDashboard.putNumber("Pitch", ahrs.getPitch());
			SmartDashboard.putNumber("Roll", ahrs.getRoll());
			SmartDashboard.putNumber("DisplacementX", ahrs.getDisplacementX());
			SmartDashboard.putNumber("DisplacementY", ahrs.getDisplacementY());
			SmartDashboard.putNumber("DisplacementZ", ahrs.getDisplacementZ());
		}
	}

	public void resetYaw()
	{
		ahrs.reset();
	}

	public void resetDisplacement()
	{
		ahrs.resetDisplacement();
	}

	public double turnController()
	{
		return turnController.get();
	}

	// Used to check if an angle has been reached
	/*public boolean checkRotationAngle(double TargetAngleDegrees)
	{
		boolean gyroAngleReached = false;
		turnController.setSetpoint(TargetAngleDegrees);
		// If the angle of the robot has reached the desired angle,
		// the boolean will turn true, if not it will be false
		if (ahrs.getYaw() >= 0 && ahrs.getYaw() >= TargetAngleDegrees || ahrs.getYaw() <= 0 && ahrs.getYaw() <= TargetAngleDegrees) {
			gyroAngleReached = true;
		} else {
			gyroAngleReached = false;
		}
		return gyroAngleReached;
	} */

	public void rotateToAngle(double targetAngleDegrees)
	{
		turnController.setSetpoint(targetAngleDegrees);
		double currentRotationRate = rotationRate;
		Robot.rDrivetrain.driveleft(-currentRotationRate);
		Robot.rDrivetrain.driveright(currentRotationRate);
	}

	// Used to check if an distance in the X axis has been reached
	public boolean checkDisplacementX(double TargetDisplacement)
	{
		boolean gyroDisplacementReached = false;
		// If the displacement of the robot has reached the desired distance,
		// the boolean will turn true, if not it will be false
		if (Math.abs(ahrs.getDisplacementX()) >= TargetDisplacement) {
			gyroDisplacementReached = true;
		} else {
			gyroDisplacementReached = false;
		}
		// ahrs.resetDisplacement(); // Resets the distance travelled to 0
		return gyroDisplacementReached;
	}

	// Used to check if an distance in the X axis has been reached
	public boolean checkDisplacementY(double TargetDisplacement)
	{
		boolean gyroDisplacementReached = false;
		// If the displacement of the robot has reached the desired distance,
		// the boolean will turn true, if not it will be false
		if (Math.abs(ahrs.getDisplacementY()) >= TargetDisplacement) {
			gyroDisplacementReached = true;
		} else {
			gyroDisplacementReached = false;
		}
		// ahrs.resetDisplacement(); // Resets the distance travelled to 0
		return gyroDisplacementReached;
	}

	public boolean checkDisplacementZ(double TargetDisplacement)
	{
		boolean gyroDisplacementReached = false;
		// If the displacement of the robot has reached the desired distance,
		// the boolean will turn true, if not it will be false
		if (Math.abs(ahrs.getDisplacementZ()) >= TargetDisplacement) {
			gyroDisplacementReached = true;
		} else {
			gyroDisplacementReached = false;
		}
		// ahrs.resetDisplacement(); // Resets the distance travelled to 0
		return gyroDisplacementReached;
	}

	@Override
	public void pidWrite(double output)
	{
		// TODO Auto-generated method stub
		rotationRate = output;
	}

}
