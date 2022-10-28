package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.CommandBase;

public class Takeball extends CommandBase {
    private final Intake intake;

    public Takeball(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.setPower(1);
        intake.setPiston(true);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        intake.setPower(0);
    }
}
