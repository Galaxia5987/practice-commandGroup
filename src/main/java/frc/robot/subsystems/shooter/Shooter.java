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
    private final UnitModel unitModel = new UnitModel(Constants.shooterConstants.TICKS_PER_ROTATION);
    private static Shooter INSTANCE;
    public static int indexRpm;
    public static int indexAngle;
    static double[] rpmDistanceList = new double[]{
            -99999.0, 1.67, 1.96, 2.4, 2.83, 3.19, 3.6, 3.69, 4.01, 4.36, 4.8, 99999.0
    };
    static double[] rpmList = new double[]{
            2610.975, 2610.975, 2610.975, 2610.975, 2702.439, 2793.902, 2885.365, 2976.829, 3007.317, 3159.756, 3281.707, 3281.707
    };
    static double[] angleDistanceList = new double[]{
            -99999.0, 1.7, 1.9, 1.95, 2.12, 2.43, 2.74, 3.02, 3.3, 3.62, 3.89, 4.08, 4.36, 4.4, 4.66, 4.78, 4.83, 4.91, 5.26, 5.46, 5.73, 99999.0
    };
    static double[] angleList = new double[]{
            12.7, 12.7, 14.2, 14.3, 15.5, 16.5, 17.5, 17.7, 18.5, 19.3, 20.5, 21.5, 20.5, 21.0, 22.0, 22.5, 23.5, 23.7, 24.0, 24.0, 24.7, 24.7
    };

    private Shooter(){
        leftMotor.configVoltageCompSaturation(Constants.CONFIG_VOLT_COMP);
        leftMotor.enableVoltageCompensation(Constants.ENABLE_VOLT_COMP);
        leftMotor.setInverted(Constants.shooterConstants.CLOCKWISE);
        leftMotor.setNeutralMode(NeutralMode.Coast);
        leftMotor.config_kP(0, Constants.shooterConstants.kP, Constants.shooterConstants.TALON_TIMEOUT);
        leftMotor.config_kP(0, Constants.shooterConstants.kI, Constants.shooterConstants.TALON_TIMEOUT);
        leftMotor.config_kP(0, Constants.shooterConstants.kD, Constants.shooterConstants.TALON_TIMEOUT);
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
