package frc.robot.subsystems.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.commands.AdjustHood;
import frc.robot.subsystems.commands.FollowPath;
import frc.robot.subsystems.commands.Warmup;

public class Autonomous extends SequentialCommandGroup {
    public Autonomous(Drivetrain drivetrain, Shooter shooter, Conveyor conveyor) {
        addCommands(
                new FollowPath(),
                new Warmup(),
                new AdjustHood(),
                new SimpleShootball(conveyor)

        );
    }
    }
