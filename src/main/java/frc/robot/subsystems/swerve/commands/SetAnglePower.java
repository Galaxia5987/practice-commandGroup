package frc.robot.subsystems.swerve.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.swerve.SwerveDrive;

public class SetAnglePower extends CommandBase {
    private final SwerveDrive swerveDrive;
    private final double power;

    public SetAnglePower(double power) {
        this.swerveDrive = SwerveDrive.getRobotOrientedDriveInstance();
        this.power = power;
        addRequirements(swerveDrive);
    }

    @Override
    public void execute() {
        swerveDrive.setAnglePower(power);
    }

    @Override
    public void end(boolean interrupted) {
        swerveDrive.terminate();
    }
}
