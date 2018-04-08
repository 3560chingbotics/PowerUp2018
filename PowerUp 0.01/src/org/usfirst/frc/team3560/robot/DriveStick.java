package org.usfirst.frc.team3560.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class DriveStick
{
	/**
	 * CREATING BUTTONS One type of button is a joystick button which is any button
	 * on a joystick. You create one by telling it which joystick it's on and which
	 * button number it is. Joystick stick = new Joystick(port); Button button = new
	 * JoystickButton(stick, buttonNumber);
	 * 
	 * There are a few additional built in buttons you can use. Additionally, by
	 * subclassing Button you can create custom triggers and bind those to commands
	 * the same as any other Button.
	 * 
	 * TRIGGERING COMMANDS WITH BUTTONS Once you have a button, it's trivial to bind
	 * it to a button in one of three ways:
	 * 
	 * Start the command when the button is pressed and let it run the command until
	 * it is finished as determined by it's isFinished method.
	 * button.whenPressed(new ExampleCommand());
	 * 
	 * Run the command while the button is being held down and interrupt it once the
	 * button is released. button.whileHeld(new ExampleCommand());
	 * 
	 * Start the command when the button is released and let it run the command
	 * until it is finished as determined by it's isFinished method.
	 * button.whenReleased(new ExampleCommand());
	 * 
	 * @return
	 */
	public Joystick driveStick;

	public DriveStick()
	{
		driveStick = new Joystick(JoyStickConstants.DRIVESTICK);
	}

	//////////////////////////////////////////////////////////////////////////////
	// DriveStick Checks //
	//////////////////////////////////////////////////////////////////////////////

	public double getJoyY()
	{
		double joy = driveStick.getRawAxis(JoyStickConstants.JOY_ANALOG_Y);
		if (Math.abs(joy) < 0.15) {
			return 0.0;
		} else {
			return joy;
		}
	}

	public double getJoyX()
	{
		double joy = driveStick.getRawAxis(JoyStickConstants.JOY_ANALOG_X);
		if (Math.abs(joy) < 0.15) {
			return 0.0;
		} else {
			return joy;
		}
	}

	public double getJoyZ()
	{
		double joy = driveStick.getRawAxis(JoyStickConstants.JOY_ANALOG_Z);
		if (Math.abs(joy) < 0.15)
			return 0.0;
		else
			return joy;
	}

	public double getSlider()
	{
		double joy = driveStick.getRawAxis(JoyStickConstants.JOY_ANALOG_SLIDER);
		return joy;
	}

	public boolean getJoyTrigger()
	{
		return driveStick.getRawButton(JoyStickConstants.JOY_TRIGGER);
	}

	public boolean getJoyLeftButton()
	{
		return driveStick.getRawButton(JoyStickConstants.JOY_LEFT_BUTTON);
	}

	public boolean getJoyMidButton()
	{
		return driveStick.getRawButton(JoyStickConstants.JOY_MIDDLE_BUTTON);
	}

	public boolean getJoyRightButton()
	{
		return driveStick.getRawButton(JoyStickConstants.JOY_RIGHT_BUTTON);
	}

	public boolean getJoyLeftFarLeftButton()
	{
		return driveStick.getRawButton(JoyStickConstants.JOY_LEFT_FAR_LEFT);
	}

	public boolean getJoyLeftFarMidButton()
	{
		return driveStick.getRawButton(JoyStickConstants.JOY_LEFT_FAR_MIDDLE);
	}

	public boolean getJoyLeftFarRightButton()
	{
		return driveStick.getRawButton(JoyStickConstants.JOY_LEFT_FAR_RIGHT);
	}

	public boolean getJoyLeftCloseLeftButton()
	{
		return driveStick.getRawButton(JoyStickConstants.JOY_LEFT_CLOSE_LEFT);
	}

	public boolean getJoyLeftCloseMidButton()
	{
		return driveStick.getRawButton(JoyStickConstants.JOY_LEFT_CLOSE_MID);
	}

	public boolean getJoyLeftCloseRightButton()
	{
		return driveStick.getRawButton(JoyStickConstants.JOY_LEFT_CLOSE_RIGHT);
	}

	public boolean getJoyRightFarLeftButton()
	{
		return driveStick.getRawButton(JoyStickConstants.JOY_LEFT_FAR_LEFT);
	}

	public boolean getJoyRightFarMidButton()
	{
		return driveStick.getRawButton(JoyStickConstants.JOY_LEFT_FAR_MIDDLE);
	}

	public boolean getJoyRightFarRightButton()
	{
		return driveStick.getRawButton(JoyStickConstants.JOY_LEFT_FAR_RIGHT);
	}

	public boolean getJoyRightCloseLeftButton()
	{
		return driveStick.getRawButton(JoyStickConstants.JOY_LEFT_CLOSE_LEFT);
	}

	public boolean getJoyRightCloseMidButton()
	{
		return driveStick.getRawButton(JoyStickConstants.JOY_LEFT_CLOSE_MID);
	}

	public boolean getJoyRightCloseRightButton()
	{
		return driveStick.getRawButton(JoyStickConstants.JOY_LEFT_CLOSE_RIGHT);
	}
}
