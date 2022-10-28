package frc.robot.subsystems.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Conveyor;

public class StartConveyor extends CommandBase {
    private final Conveyor conveyor;
    private final double power;

    public StartConveyor(Conveyor conveyor, double power) {
        this.conveyor = conveyor;
        this.power = power;
        addRequirements(conveyor);
    }

    @Override
    public void initialize() {
        conveyor.setPower(power);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        conveyor.setPower(0);
    }
}
