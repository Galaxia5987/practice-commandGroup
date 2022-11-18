package frc.robot.subsystems.conveyor.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.conveyor.Conveyor;

public class ConveyBottom extends CommandBase {
    private final Conveyor conveyor;
    private final double power;

    public ConveyBottom(double power) {
        this.conveyor = Conveyor.getInstance();
        this.power = power;
        addRequirements(conveyor);
    }

    @Override
    public void execute() {
        conveyor.setBottomPower(power);
    }

    @Override
    public void end(boolean interrupted) {
        conveyor.setBottomPower(0);
    }
}
