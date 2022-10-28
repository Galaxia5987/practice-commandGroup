package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.commands.RotateRobot;

public class Hood extends SubsystemBase {
    private final WPI_TalonFX motor = new WPI_TalonFX(1);
    public boolean atSetpoint() {
        return true;
    }
    public void rotate(double angle){
        motor.set(angle);
    }
    public void setPower(double pow){
         motor.set(pow);
    }

}
