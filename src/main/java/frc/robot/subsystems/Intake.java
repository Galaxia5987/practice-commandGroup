package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports;


public class Intake extends SubsystemBase {
    private final WPI_TalonFX motor;
    private final Solenoid piston;

    public Intake(){
        motor = new WPI_TalonFX(0);
        motor.setInverted(true);
        piston = new Solenoid(PneumaticsModuleType.CTREPCM, 1);
    }


    public void setPower(double power) {
        motor.set(power);
    }

    public void setPiston(boolean pistonMode) {
        piston.set(pistonMode);
    }
}
