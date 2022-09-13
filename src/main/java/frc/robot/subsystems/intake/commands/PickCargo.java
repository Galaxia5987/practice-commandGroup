package frc.robot.subsystems.intake.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake.Intake;



public class PickCargo extends CommandBase {
    private final Intake intake;
    private final double power;
    private final Timer timer = new Timer();

    public PickCargo(double power) {
        this.intake = Intake.getInstance();
        this.power = power;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.openPiston();
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        intake.setPower(power);
    }

    @Override
    public void end(boolean interrupted) {
        intake.setPower(0);
        intake.closePiston();
    }

    @Override
    public boolean isFinished() {
        return timer.get() > 5;
    }
}
