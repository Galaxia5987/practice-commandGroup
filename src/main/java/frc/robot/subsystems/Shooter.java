package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private final WPI_TalonFX motor = new WPI_TalonFX(1);

    public boolean atVelocity() {
        return true;
    }
    public void setVelocity(double velocity){
        motor.set(velocity);
    }
}
