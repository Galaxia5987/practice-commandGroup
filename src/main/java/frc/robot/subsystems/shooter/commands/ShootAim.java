package frc.robot.subsystems.shooter.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.Shooter;
import frc.robot.subsystems.vision.Vision;

public class ShootAim extends CommandBase {
    private final Shooter shooter;
    private final Vision vision;

    public ShootAim(Shooter shooter, Vision vision) {
        this.shooter = shooter.getInstance();
        this.vision = vision.getInstance();
        addRequirements(shooter, vision);
    }

    @Override
    public void execute() {
        shooter.rangeFinderRpm(vision.getDistance().getAsDouble());
        shooter.rangeFinderAngle(vision.getDistance().getAsDouble());
        shooter.setVelocity(shooter.rpmFinder(vision.getDistance().getAsDouble()));
    }
}
