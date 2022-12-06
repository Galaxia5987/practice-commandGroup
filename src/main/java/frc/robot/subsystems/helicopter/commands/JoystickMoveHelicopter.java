package frc.robot.subsystems.helicopter.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.helicopter.Helicopter;

import java.util.function.DoubleSupplier;

public class JoystickMoveHelicopter extends CommandBase {
    private final Helicopter helicopter;
    private final DoubleSupplier joystickValue;

    public JoystickMoveHelicopter(DoubleSupplier joystickValue) {
        this.helicopter = Helicopter.getInstance();
        this.joystickValue = joystickValue;
        addRequirements(helicopter);
    }


    @Override
    public void execute() {
        helicopter.setPower(helicopter.deadBend(joystickValue.getAsDouble()));
    }

    @Override
    public void end(boolean interrupted) {
        helicopter.stop();
    }
}
