package frc.robot.subsystems.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase {
   private Shooter shooter = new Shooter();
    @Override
    public void execute() {
        shooter.setVelocity(4);
    }
}
