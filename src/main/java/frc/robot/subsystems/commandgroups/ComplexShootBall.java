package frc.robot.subsystems.commandgroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.commands.AdjustHood;
import frc.robot.subsystems.commands.RotateRobot;
import frc.robot.subsystems.commands.Warmup;

public class ComplexShootBall extends SequentialCommandGroup {
    public ComplexShootBall(Conveyor conveyor) {
        addCommands(
                new ParallelCommandGroup(
                        new RotateRobot(),
                        new AdjustHood(),
                        new Warmup()
                ),
                new SimpleShootball(conveyor)
        );
    }

}
