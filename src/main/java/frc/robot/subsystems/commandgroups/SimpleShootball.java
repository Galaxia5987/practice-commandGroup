package frc.robot.subsystems.commandgroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.commands.AdjustHood;
import frc.robot.subsystems.commands.RotateRobot;
import frc.robot.subsystems.commands.Shoot;
import frc.robot.subsystems.commands.StartConveyor;

public class SimpleShootball extends ParallelCommandGroup {
    public SimpleShootball(Conveyor conveyor) {
        addCommands(
                new Shoot(),
                new AdjustHood(),
                new RotateRobot(),
                new StartConveyor(conveyor, 1)
        );
    }
}
