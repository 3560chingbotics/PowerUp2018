package org.usfirst.frc.team3560.robot;

import org.usfirst.frc.team3560.robot.commands.auton.AutonReachLine;
import org.usfirst.frc.team3560.robot.commands.auton.AutonTesting;
import org.usfirst.frc.team3560.robot.commands.auton.NoAuton;
import org.usfirst.frc.team3560.robot.commands.auton.OnLeftGoForScale;
import org.usfirst.frc.team3560.robot.commands.auton.OnRightGoForScale;
import org.usfirst.frc.team3560.robot.commands.auton.TimedAuton;
import org.usfirst.frc.team3560.robot.subsystems.Claw;
import org.usfirst.frc.team3560.robot.subsystems.Drivetrain;
import org.usfirst.frc.team3560.robot.subsystems.Lift;
import org.usfirst.frc.team3560.robot.subsystems.NavX;
import org.usfirst.frc.team3560.robot.subsystems.PIDNavXMoving;
import org.usfirst.frc.team3560.robot.subsystems.PIDNavXTurning;

import edu.wpi.first.wpilibj.CameraServer;
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
	public static final NavX rNavX = new NavX();
	public static final PIDNavXTurning rPIDNavXTurning = new PIDNavXTurning();
	public static final PIDNavXMoving rPIDNavXMoving = new PIDNavXMoving();
	public static DriveStick rDriveStick;
	public static ToolStick rToolStick;
	public static String FMSReading;
	public static char firstFMSChar, secondFMSChar, thirdFMSChar;
	Command rAutonomousCommand;
	SendableChooser<Command> rAutoChooser;

	@Override
	public void robotInit()
	{
		rDriveStick = new DriveStick();
		rToolStick = new ToolStick();
		FMSReading = DriverStation.getInstance().getGameSpecificMessage();
		SmartDashboard.putString("Game Data from FMS", FMSReading);
		CameraServer.getInstance().startAutomaticCapture(0); // Camera Enabling
		rAutoChooser = new SendableChooser<Command>();
		rAutoChooser.addDefault("NoAuton", new NoAuton());
		rAutoChooser.addObject("AutonReachLine", new AutonReachLine());
		rAutoChooser.addObject("TimedAuton", new TimedAuton());
		rAutoChooser.addObject("AutonTesting", new AutonTesting());
		rAutoChooser.addObject("OnLeftGoForScale", new OnLeftGoForScale());
		rAutoChooser.addObject("OnRightGoForScale", new OnRightGoForScale());
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
		// Robot.rNavX.turnController.enable();
		Robot.rNavX.resetYaw();
		Robot.rNavX.resetDisplacement();
		Robot.rNavX.displayNavXData();
	}

	@Override
	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();
		Robot.rLift.updateSwitchCount();
		SmartDashboard.updateValues();
	}

	@Override
	public void teleopInit()
	{
		if (rAutonomousCommand != null) {
			rAutonomousCommand.cancel();
		}
		// Robot.rNavX.turnController.disable();
		Robot.rNavX.resetYaw();
		Robot.rNavX.resetDisplacement();
	}

	@Override
	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();
		// Robot.rLift.updateSwitchCount();
		SmartDashboard.updateValues();
	}

	@Override
	public void testPeriodic()
	{
	}

	public char getFirstCharFMS()
	{
		firstFMSChar = FMSReading.charAt(0);
		return firstFMSChar;
	}

	public char getSecondCharFMS()
	{
		secondFMSChar = FMSReading.charAt(1);
		return secondFMSChar;
	}

	public char getThirdCharFMS()
	{
		thirdFMSChar = FMSReading.charAt(2);
		return thirdFMSChar;
	}
}
