package frc.robot.subsystems.helicopter.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.helicopter.Helicopter;

public class JoystickMoveHelicopter extends CommandBase {
    private final Helicopter helicopter;
    private final double power;

    public JoystickMoveHelicopter(Helicopter helicopter, double power) {
        this.helicopter = helicopter;
        this.power = power;
        addRequirements(helicopter);
    }

    @Override
    public void execute() {
    }
}
