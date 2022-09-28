package frc.robot.subsystems.conveyor.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.conveyor.Conveyor;


public class Convey extends CommandBase {
    private final Conveyor conveyor;
    private final double power;

    public Convey(double power) {
        this.conveyor = Conveyor.getInstance();
        this.power = power;
        addRequirements(conveyor);
    }


    @Override
    public void execute() {
        conveyor.setPower(power);
    }

    @Override
    public void end(boolean interrupted) {
        conveyor.setPower(0);
    }
}
