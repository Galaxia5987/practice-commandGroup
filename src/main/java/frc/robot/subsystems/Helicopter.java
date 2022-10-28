package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Helicopter extends SubsystemBase {
    private final WPI_TalonFX motor = new WPI_TalonFX(0);
    public void setpow(double power){
        motor.set(power);
    }

}
