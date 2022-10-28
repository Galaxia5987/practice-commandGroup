package frc.robot.subsystems.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Helicopter;

public class MoveClimber extends CommandBase {
    private final XboxController xboxController;
    private Helicopter helicopter;
    public MoveClimber (XboxController xboxController){
        this.xboxController = xboxController;
        addRequirements(Helicopter);
    }
    @Override
    public void execute() {
        helicopter.setpow(xboxController.getLeftY());
    }


}
