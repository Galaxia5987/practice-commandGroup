package frc.robot.subsystems.conveyor;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;

public class Conveyor extends SubsystemBase {
    private static Conveyor INSTANCE;
    private final TalonSRX bottomMotor = new TalonSRX(Ports.ConveyorPorts.BOTTOM_MOTOR);
    private final TalonSRX upperMotor = new TalonSRX(Ports.ConveyorPorts.UPPER_MOTOR);

    private Conveyor() {
        bottomMotor.enableVoltageCompensation(Constants.ENABLE_VOLT_COMP);
        bottomMotor.configVoltageCompSaturation(Constants.CONFIG_VOLT_COMP);
        bottomMotor.setInverted(Constants.CLOCKWISE);//check this
    }

    public static Conveyor getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Conveyor();
        }

        return INSTANCE;
    }

    public double getBottomPower() {
        return bottomMotor.getMotorOutputPercent();
    }

    public void setBottomPower(double power) {
        bottomMotor.set(TalonSRXControlMode.PercentOutput, power);
    }

    public double getUpperPower() {
        return upperMotor.getMotorOutputPercent();
    }

    public void setUpperPower(double power){
        upperMotor.set(TalonSRXControlMode.PercentOutput, power);
    }
}
