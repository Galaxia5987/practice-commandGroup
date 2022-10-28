package frc.robot.subsystems.commandgroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Takeball;
import frc.robot.subsystems.commands.StartConveyor;

public class Feed extends ParallelCommandGroup {
    public Feed(Intake intake, Conveyor conveyor) {
        addCommands(
                new StartConveyor(conveyor, 1),
                new Takeball(intake)
        );
    }
}
