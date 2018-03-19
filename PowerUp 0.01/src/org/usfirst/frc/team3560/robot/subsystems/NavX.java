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
	/*
	public PIDController turnController, moveController;
	public double rotationRate, moveRate;
	
	static final double turnP = 0.03;
	static final double turnI = 0.00;
	static final double turnD = 0.00;
	static final double turnF = 0.00;
	static final double turnToleranceDegrees = 2.0f;
	
	static final double moveP = 0.03;
	static final double moveI = 0.00;
	static final double moveD = 0.00;
	static final double moveF = 0.00;
	static final double moveToleranceMetres = 0.1f;
	*/

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

		/*
		turnController = new PIDController(turnP, turnI, turnD, turnF, ahrs, );
		turnController.setInputRange(-180.0f, 180.0f);
		turnController.setOutputRange(-1.0, 1.0);
		turnController.setAbsoluteTolerance(turnToleranceDegrees);
		turnController.setContinuous(true);
		LiveWindow.addActuator("NavX", "RotateController", turnController);
		
		moveController = new PIDController(moveP, moveI, moveD, moveF, ahrs, this);
		moveController.setInputRange(-20, 20);
		moveController.setOutputRange(-1.0, 1.0);
		moveController.setAbsoluteTolerance(moveToleranceMetres);
		moveController.setContinuous(false);
		LiveWindow.addActuator("NavX", "MoveController", moveController);
		*/
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
		ahrs.zeroYaw();
	}

	public void resetDisplacement()
	{
		ahrs.resetDisplacement();
	}

	public double getYaw()
	{
		return ahrs.pidGet();
	}

	public double getDisplacementX()
	{
		return ahrs.getDisplacementX();
	}
	/*
		public double turnController()
		{
			return turnController.get();
		}
		*/

	/*
	public void rotateToAngle(double targetAngleDegrees)
	{
		turnController.setSetpoint(targetAngleDegrees);
		double currentRotationRate = rotationRate;
		Robot.rDrivetrain.driveleft(-currentRotationRate);
		Robot.rDrivetrain.driveright(currentRotationRate);
	}
	*/

	// Used to check if an distance in the X axis has been reached
	public boolean moveDisplacementX(double TargetDisplacement)
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
	public boolean moveDisplacementY(double TargetDisplacement)
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

	public boolean moveDisplacementZ(double TargetDisplacement)
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
}
