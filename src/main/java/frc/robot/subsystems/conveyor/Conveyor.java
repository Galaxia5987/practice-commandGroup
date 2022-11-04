package frc.robot.subsystems.conveyor;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;

public class Conveyor extends SubsystemBase {
    private static Conveyor INSTANCE;
    private final WPI_TalonFX motor = new WPI_TalonFX(Ports.ConveyorPorts.MOTOR);

    private Conveyor() {
        motor.enableVoltageCompensation(Constants.shooterConstants.ENABLE_VOLT_COMP);
        motor.configVoltageCompSaturation(Constants.shooterConstants.CONFIG_VOLT_COMP);
        motor.setInverted(Constants.shooterConstants.CLOCKWISE);
    }

    public static Conveyor getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Conveyor();
        }

        return INSTANCE;
    }

    public double getPower() {
        return motor.get();
    }

    public void setPower(double power) {
        motor.set(power);
    }
}
