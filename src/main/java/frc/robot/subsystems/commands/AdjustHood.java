package frc.robot.subsystems.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hood;

public class AdjustHood extends CommandBase {
    private Hood hood1 = new Hood();
    @Override
    public void execute() {
        hood1.rotate(8);
    }

    @Override
    public boolean isFinished() {
        return hood1.atSetpoint();
    }

    @Override
    public void end(boolean interrupted) {
        hood1.setPower(0);
    }
}
