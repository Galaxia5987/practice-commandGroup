package frc.robot.subsystems.swerve.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.swerve.SwerveDrive;

public class SetDrivePower extends CommandBase {
    private final SwerveDrive swerveDrive;
    private final double power;

    public SetDrivePower(double power) {
        this.swerveDrive = SwerveDrive.getRobotOrientedDriveInstance();
        this.power = power;
        addRequirements(swerveDrive);
    }

    @Override
    public void execute() {
        swerveDrive.setDrivePower(power);
    }

    @Override
    public void end(boolean interrupted) {
        swerveDrive.terminate();
    }
}
