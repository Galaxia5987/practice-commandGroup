package frc.robot.subsystems.commandgroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.conveyor.Conveyor;
import frc.robot.subsystems.conveyor.commands.Convey;
import frc.robot.subsystems.intake.Intake;
import frc.robot.subsystems.intake.commands.PickCargo;

public class Outtake extends ParallelCommandGroup {
    public Outtake(Intake PickCargo, Conveyor Convey){
        addCommands(
                new PickCargo(-Constants.INTAKE_POWER),
                new Convey(-Constants.CONVEYOR_POWER)
        );
    }
}
