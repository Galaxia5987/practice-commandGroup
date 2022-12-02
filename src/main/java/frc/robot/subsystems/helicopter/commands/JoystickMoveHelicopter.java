package frc.robot.subsystems.helicopter.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.helicopter.Helicopter;

import java.util.function.DoubleSupplier;

public class JoystickMoveHelicopter extends CommandBase {
    private final Helicopter helicopter;
    private final DoubleSupplier joystickValue;

    public JoystickMoveHelicopter(Helicopter helicopter, DoubleSupplier joystickValue) {
        this.helicopter = helicopter;
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
