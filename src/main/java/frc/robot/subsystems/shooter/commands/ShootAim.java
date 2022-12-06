package frc.robot.subsystems.shooter.commands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.Shooter;
import frc.robot.subsystems.vision.Vision;

public class ShootAim extends CommandBase {
    private final Shooter shooter;
    private final Vision vision;
    private final double distance;

    public ShootAim(double distance) {
        this.shooter = Shooter.getInstance();
        this.vision = Vision.getInstance();
        this.distance = distance;
    }

    @Override
    public void execute() {
        shooter.setAngle(new Rotation2d(shooter.angleFinder(vision.getDistance().getAsDouble())));
        shooter.setVelocity(shooter.rpmFinder(vision.getDistance().getAsDouble()));
    }

    @Override
    public void end(boolean interrupted) {
        shooter.terminate();
    }
}
