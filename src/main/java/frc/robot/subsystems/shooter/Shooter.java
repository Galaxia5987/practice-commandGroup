package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;
import frc.robot.subsystems.UnitModel;

public class Shooter extends SubsystemBase {
    private final WPI_TalonFX leftMotor = new WPI_TalonFX(Ports.ShooterPorts.LEFT_MOTOR);
    private final WPI_TalonFX rightMotor = new WPI_TalonFX(Ports.ShooterPorts.RIGHT_MOTOR);
    private final UnitModel unitModel = new UnitModel(Constants.TICKS_PER_ROTATION);
    private static Shooter INSTANCE;

    private Shooter(){
        leftMotor.configVoltageCompSaturation(Constants.CONFIG_VOLT_COMP);
        leftMotor.enableVoltageCompensation(Constants.ENABLE_VOLT_COMP);
        leftMotor.setInverted(Constants.CLOCKWISE);
        leftMotor.setNeutralMode(NeutralMode.Coast);
        leftMotor.config_kP(0, Constants.kP, Constants.TALON_TIMEOUT);
        leftMotor.config_kP(0, Constants.kI, Constants.TALON_TIMEOUT);
        leftMotor.config_kP(0, Constants.kD, Constants.TALON_TIMEOUT);
        rightMotor.follow(leftMotor);
        rightMotor.setInverted(TalonFXInvertType.OpposeMaster);
    }

    public static Shooter getInstance(){
        if (INSTANCE==null){
            INSTANCE=new Shooter();
        }
        return INSTANCE;
    }
    public void setVelocity(double velocity){
        leftMotor.set(unitModel.toTicks100ms(velocity/60));
    }
    public double getVelocity(){
        return unitModel.toUnits(leftMotor.get());
    }
}
