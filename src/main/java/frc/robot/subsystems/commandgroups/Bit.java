package frc.robot.subsystems.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.conveyor.Conveyor;
import frc.robot.subsystems.conveyor.commands.ConveyUpper;
import frc.robot.subsystems.intake.Intake;
import frc.robot.subsystems.intake.commands.PickCargo;

public class Bit extends SequentialCommandGroup {
    public Bit(Intake PickCargo, Conveyor Convey){
        addCommands(
                new PickCargo(Constants.intakeConstants.INTAKE_POWER).withTimeout(5),
                new PickCargo(-Constants.intakeConstants.INTAKE_POWER).withTimeout(5),
                new ConveyUpper(Constants.conveyorConstants.CONVEYOR_POWER).withTimeout(5),
                new ConveyUpper(-Constants.conveyorConstants.CONVEYOR_POWER).withTimeout(5)
        );
    }
}
