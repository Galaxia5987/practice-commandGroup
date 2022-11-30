package frc.robot.subsystems.helicopter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;
import frc.robot.subsystems.UnitModel;

public class Helicopter extends SubsystemBase {
    private static Helicopter INSTANCE = null;
    private static final WPI_TalonFX mainMotor = new WPI_TalonFX(Ports.HelicopterPorts.MAIN_MOTOR);
    private static final WPI_TalonFX auxMotor = new WPI_TalonFX(Ports.HelicopterPorts.AUX_MOTOR);
    private static final UnitModel unitModel = new UnitModel(Constants.HelicopterConstants.TICKS_PER_RAD);

    private Helicopter(){
        mainMotor.setSensorPhase(Ports.HelicopterPorts.SENSOR_PHASE);
        mainMotor.setNeutralMode(NeutralMode.Brake);
        auxMotor.setNeutralMode(NeutralMode.Brake);
        auxMotor.follow(mainMotor);
        mainMotor.setInverted(Constants.HelicopterConstants.CLOCK_WISE);
        auxMotor.setInverted(Constants.HelicopterConstants.COUNTER_CLOCK_WISE);
        mainMotor.configVoltageCompSaturation(Constants.CONFIG_VOLT_COMP);
        mainMotor.enableVoltageCompensation(Constants.ENABLE_VOLT_COMP);
        auxMotor.configVoltageCompSaturation(Constants.CONFIG_VOLT_COMP);
        mainMotor.enableVoltageCompensation(Constants.ENABLE_VOLT_COMP);
        mainMotor.configMotionCruiseVelocity(Constants.HelicopterConstants.CRUISE_VELOCITY);
        mainMotor.configMotionAcceleration(Constants.HelicopterConstants.MAXIMAL_ACCELERATION);
    }

    public static Helicopter getInstance(){
        if (INSTANCE==null){
            INSTANCE = new Helicopter();
        }
        return INSTANCE;
    }

    public static double getPower(){
        return mainMotor.getMotorOutputPercent();
    }

    public static void setPower(double power){
        mainMotor.set(ControlMode.PercentOutput, power);
    }

    public static Rotation2d getPosition(){
        return new Rotation2d(Math.IEEEremainder(unitModel.toUnits(mainMotor.getSelectedSensorPosition()), Math.PI*2));
    }

    public static void setPosition(Rotation2d position){
        mainMotor.set(ControlMode.Position, position.getRadians());
    }
}
