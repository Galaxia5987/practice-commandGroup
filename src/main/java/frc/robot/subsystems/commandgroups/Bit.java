package frc.robot.subsystems.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.conveyor.Conveyor;
import frc.robot.subsystems.conveyor.commands.Convey;
import frc.robot.subsystems.intake.Intake;
import frc.robot.subsystems.intake.commands.PickCargo;

public class Bit extends SequentialCommandGroup {
    public Bit(Intake PickCargo, Conveyor Convey){
        addCommands(
                new PickCargo(Constants.INTAKE_POWER).withTimeout(5),
                new PickCargo(-Constants.INTAKE_POWER).withTimeout(5),
                new Convey(Constants.CONVEYOR_POWER).withTimeout(5),
                new Convey(-Constants.CONVEYOR_POWER).withTimeout(5)
        );
    }
}
