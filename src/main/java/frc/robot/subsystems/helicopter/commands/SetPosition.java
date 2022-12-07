package frc.robot.subsystems.helicopter.commands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.helicopter.Helicopter;

public class SetPosition extends CommandBase {
    private final Helicopter helicopter;
    private final Rotation2d position;

    public SetPosition(Rotation2d position) {
        this.helicopter = Helicopter.getInstance();
        this.position = position;
        addRequirements(helicopter);
    }

    @Override
    public void execute() {
        helicopter.setPosition(position);
    }

    @Override
    public void end(boolean interrupted) {
        helicopter.stop();
    }
}
