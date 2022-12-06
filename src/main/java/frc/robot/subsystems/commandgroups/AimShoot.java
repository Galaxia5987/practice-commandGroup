package frc.robot.subsystems.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.conveyor.Conveyor;
import frc.robot.subsystems.conveyor.commands.ConveyUpper;
import frc.robot.subsystems.shooter.Shooter;
import frc.robot.subsystems.shooter.commands.Shoot;
import frc.robot.subsystems.shooter.commands.ShootAim;
import frc.robot.subsystems.vision.Vision;

public class AimShoot extends SequentialCommandGroup {
    public AimShoot(Conveyor ConveyUpper, Shooter ShootAim, Vision vision){
        addCommands(
                new ShootAim(vision.getDistance().getAsDouble()).andThen(
                        new ConveyUpper(Constants.conveyorConstants.CONVEYOR_POWER)
                )
        );
    }
}
