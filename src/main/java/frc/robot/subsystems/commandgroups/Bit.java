package frc.robot.subsystems.commandgroups;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.conveyor.Conveyor;
import frc.robot.subsystems.conveyor.commands.ConveyUpper;
import frc.robot.subsystems.intake.Intake;
import frc.robot.subsystems.intake.commands.PickCargo;
import frc.robot.subsystems.shooter.Shooter;
import frc.robot.subsystems.shooter.commands.Shoot;
import frc.robot.subsystems.swerve.SwerveDrive;
import frc.robot.subsystems.swerve.commands.SetAnglePower;
import frc.robot.subsystems.swerve.commands.SetDrivePower;

public class Bit extends SequentialCommandGroup {
    public Bit(Intake PickCargo, Conveyor Convey, Shooter Shoot, SwerveDrive SetDrivePower, SwerveDrive SetAnglePower){
        addCommands(
                new PickCargo(Constants.intakeConstants.INTAKE_POWER).withTimeout(5),
                new PickCargo(-Constants.intakeConstants.INTAKE_POWER).withTimeout(5),
                new ConveyUpper(Constants.conveyorConstants.CONVEYOR_POWER).withTimeout(5),
                new ConveyUpper(-Constants.conveyorConstants.CONVEYOR_POWER).withTimeout(5),
                new Shoot(2500, new Rotation2d(0)).withTimeout(5),
                new SetDrivePower(50).withTimeout(5),
                new SetAnglePower(50).withTimeout(5)
        );
    }
}
