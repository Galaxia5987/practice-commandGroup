package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.commandgroups.Feed;
import frc.robot.subsystems.commandgroups.Outtake;
import frc.robot.subsystems.conveyor.Conveyor;
import frc.robot.subsystems.intake.Intake;
import frc.robot.valuetuner.ValueTuner;
import webapp.Webserver;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
    private final Conveyor conveyor = Conveyor.getInstance();
    private final Intake intake = Intake.getInstance();
    private final XboxController xbox = new XboxController(0);
    private final JoystickButton a = new JoystickButton(xbox, XboxController.Button.kA.value);
    private final JoystickButton b = new JoystickButton(xbox, XboxController.Button.kB.value);


    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // Configure the button bindings and default commands
        configureDefaultCommands();

        if (Robot.debug) {
            startValueTuner();
            startFireLog();
        }

        configureButtonBindings();
    }

    private void configureDefaultCommands() {


    }

    private void configureButtonBindings() {
        a.whileHeld(new Feed(intake ,conveyor));
        b.whileHeld(new Outtake(intake, conveyor));
    }


    /**
    * Use this to pass the autonomous command to the main {@link Robot} class.
    *
    * @return the command to run in autonomous
    */
    public Command getAutonomousCommand() {
      return null;
    }

    /**
     * Initiates the value tuner.
     */
    private void startValueTuner() {
        new ValueTuner().start();
    }

    /**
     * Initiates the port of team 225s Fire-Logger.
     */
    private void startFireLog() {

        try {
            new Webserver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
