package frc.robot.subsystems.commandgroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.conveyor.Conveyor;
import frc.robot.subsystems.conveyor.commands.ConveyBottom;
import frc.robot.subsystems.conveyor.commands.ConveyUpper;
import frc.robot.subsystems.intake.Intake;
import frc.robot.subsystems.intake.commands.PickCargo;

public class Feed extends ParallelCommandGroup {
    public Feed(Intake PickCargo, Conveyor ConveyBottom){
        addCommands(
                new PickCargo(Constants.intakeConstants.INTAKE_POWER),
                new ConveyBottom(Constants.conveyorConstants.CONVEYOR_POWER)

        );
    }

}
