package frc.robot.subsystems.shooter.commands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.Shooter;

public class Shoot extends CommandBase {
        private final Shooter shooter;
        private final double velocity;
        private final Rotation2d angle;

    public Shoot(double velocity, Rotation2d angle) {
        this.shooter = Shooter.getInstance();
        this.velocity=velocity;
        this.angle=angle;
        addRequirements(shooter);
    }

    @Override
    public void execute() {
        shooter.setVelocity(velocity);
        shooter.setAngle(angle);
    }

    @Override
    public void end(boolean interrupted) {
        shooter.setVelocity(0);
        shooter.setAngle(new Rotation2d(0));
    }
}
