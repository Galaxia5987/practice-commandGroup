package frc.robot.subsystems.intake.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake.Intake;

public class TestPiston extends CommandBase {
    private final Intake intake;
    private final Timer timer = new Timer();

    public TestPiston() {
        this.intake = Intake.getInstance();
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        if (timer.get() > 2) {
            if (!intake.getPistonPosition()) {
                intake.openPiston();
            } else {
                intake.closePiston();
            }
        }
    }
}
