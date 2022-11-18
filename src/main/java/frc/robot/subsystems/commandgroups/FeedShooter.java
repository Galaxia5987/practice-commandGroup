package frc.robot.subsystems.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.conveyor.Conveyor;
import frc.robot.subsystems.conveyor.commands.ConveyUpper;
import frc.robot.subsystems.shooter.Shooter;
import frc.robot.subsystems.shooter.commands.Shoot;

public class FeedShooter extends SequentialCommandGroup {
    public FeedShooter(Conveyor ConveyUpper, Shooter Shoot){
        addCommands(
                new Shoot(Constants.shooterConstants.SHOOTER_VELOCITY).andThen
                        (new ConveyUpper(Constants.conveyorConstants.CONVEYOR_POWER))

        );
    }
}
