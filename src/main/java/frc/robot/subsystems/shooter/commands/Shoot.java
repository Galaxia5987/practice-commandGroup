package frc.robot.subsystems.shooter.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.Shooter;

public class Shoot extends CommandBase {
        private final Shooter shooter;
        private final double velocity;

    public Shoot(double velocity) {
        this.shooter = Shooter.getInstance();
        this.velocity=velocity;
        addRequirements(shooter);
    }

    @Override
    public void execute() {
        shooter.setVelocity(velocity);
    }
}
