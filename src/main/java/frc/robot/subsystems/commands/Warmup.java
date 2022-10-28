package frc.robot.subsystems.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class Warmup extends CommandBase {
    private Shooter shooter1 = new Shooter();
    @Override
    public void execute() {
        shooter1.setVelocity(4);
    }
}
