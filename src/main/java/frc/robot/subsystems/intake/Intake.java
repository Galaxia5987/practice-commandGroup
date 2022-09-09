package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;

public class Intake extends SubsystemBase {
    private static Intake INSTANCE;
    private final WPI_TalonFX motor = new WPI_TalonFX(Ports.IntakePorts.MOTOR);
    private final Solenoid piston = new Solenoid(PneumaticsModuleType.CTREPCM, Ports.IntakePorts.PISTON);

    private Intake() {
        motor.configVoltageCompSaturation(Constants.CONFIG_VOLT_COMP);
        motor.enableVoltageCompensation(Constants.ENABLE_VOLT_COMP);
        motor.setInverted(Constants.CLOCKWISE);
    }

    public static Intake getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Intake();
        }

        return INSTANCE;
    }

    public double getPower(){
        return motor.get();
    }

    public void setPower(double value){
        motor.set(value);
    }

    public void closePiston(){
        piston.set(Constants.PISTON_CLOSE);
    }

    public void openPiston(){
        piston.set(Constants.PISTON_OPEN);
    }
}
