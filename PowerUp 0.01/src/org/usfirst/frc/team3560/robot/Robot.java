package org.usfirst.frc.team3560.robot;

import org.usfirst.frc.team3560.robot.commands.AutonReachLine;
import org.usfirst.frc.team3560.robot.subsystems.Claw;
import org.usfirst.frc.team3560.robot.subsystems.Drivetrain;
import org.usfirst.frc.team3560.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot
{
	public static final Drivetrain rDrivetrain = new Drivetrain();
	public static final Claw rClaw = new Claw();
	public static final Lift rLift = new Lift();
	public static DriveStick rDriveStick;
	public static ToolStick rToolStick;
	public String FMSReading;
	Command rAutonomousCommand;
	SendableChooser<Command> rAutoChooser;

	@Override
	public void robotInit()
	{
		rDriveStick = new DriveStick();
		rToolStick = new ToolStick();
		FMSReading = DriverStation.getInstance().getGameSpecificMessage();
		// System.out.println("Game Data from FMS" + FMSReading);
		rAutoChooser = new SendableChooser<Command>();
		rAutoChooser.addDefault("AutonReachLine", new AutonReachLine());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", rAutoChooser);

	}

	@Override
	public void disabledInit()
	{

	}

	@Override
	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit()
	{
		rAutonomousCommand = (Command) rAutoChooser.getSelected();

		// schedule the autonomous command (example)
		if (rAutonomousCommand != null) {
			rAutonomousCommand.start();
		}
	}

	@Override
	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit()
	{
		if (rAutonomousCommand != null) {
			rAutonomousCommand.cancel();
		}
	}

	@Override
	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();

		SmartDashboard.putBoolean("IMU_Connected", Robot.rDrivetrain.ahrs.isConnected());
		SmartDashboard.putBoolean("IMU_IsCalibrating", Robot.rDrivetrain.ahrs.isCalibrating());
		SmartDashboard.putNumber("IMU_Yaw", Robot.rDrivetrain.ahrs.getYaw());
		SmartDashboard.putNumber("IMU_Pitch", Robot.rDrivetrain.ahrs.getPitch());
		SmartDashboard.putNumber("IMU_Roll", Robot.rDrivetrain.ahrs.getRoll());
	}

	@Override
	public void testPeriodic()
	{
	}
}
