package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;
import frc.robot.subsystems.UnitModel;

public class Shooter extends SubsystemBase {
    private final WPI_TalonFX velocityMotor = new WPI_TalonFX(Ports.ShooterPorts.VELOCITY_MOTOR);
    private final WPI_TalonFX angleMotor = new WPI_TalonFX(Ports.ShooterPorts.ANGLE_MOTOR);
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
        velocityMotor.configVoltageCompSaturation(Constants.CONFIG_VOLT_COMP);
        velocityMotor.enableVoltageCompensation(Constants.ENABLE_VOLT_COMP);
        velocityMotor.setInverted(Constants.shooterConstants.CLOCKWISE);
        velocityMotor.setNeutralMode(NeutralMode.Coast);
        velocityMotor.config_kP(0, Constants.shooterConstants.kP, Constants.shooterConstants.TALON_TIMEOUT);
        velocityMotor.config_kP(0, Constants.shooterConstants.kI, Constants.shooterConstants.TALON_TIMEOUT);
        velocityMotor.config_kP(0, Constants.shooterConstants.kD, Constants.shooterConstants.TALON_TIMEOUT);
        angleMotor.follow(velocityMotor);
        velocityMotor.setInverted(TalonFXInvertType.OpposeMaster);
    }

    public static Shooter getInstance(){
        if (INSTANCE==null){
            INSTANCE=new Shooter();
        }
        return INSTANCE;
    }

    /**
     * finds the correct rpm for a certain distance
     * @param distance
     * @return
     */
    public static double rpmFinder(double distance){
        double rpm;

        int i =0;
        while ( rpmDistanceList.length>i){
            if (distance<rpmDistanceList[i]){
                indexRpm = i;
            }
            else if (distance==rpmDistanceList[i]){
                indexRpm = i;
            }
            i++;
        }

        if (distance<2.4){
            return rpmList[0];
        }
        else if(distance>4.8){
            return rpmList[11];
        }
        else if(distance==rpmDistanceList[indexRpm]){
            return rpmList[indexRpm];
        }
        else if (distance<rpmDistanceList[indexRpm]&&distance>rpmDistanceList[indexRpm-1]){
            rpm = ((rpmList[indexRpm]-rpmList[indexRpm-1])/(rpmDistanceList[indexRpm]-rpmDistanceList[indexRpm-1])*(distance-rpmDistanceList[indexRpm])+rpmList[indexRpm]);
            return rpm;
        }
        else{
            return -1;
        }
    }

    /**
     * finds the correct angle for a certain distance
     * @param distance
     * @return
     */
    public static double angleFinder(double distance){
        double angle;

        int i =0;
        while (angleDistanceList.length>i){
            if (distance<angleDistanceList[i]){
                indexAngle = i;
            }
            else if (distance==angleDistanceList[i]){
                indexAngle = i;
            }
            i++;
        }

        if (distance<1.7){
            return angleList[0];
        }
        else if(distance>5.73){
            return angleList[21];
        }
        else if(distance==angleDistanceList[indexAngle]){
            return angleList[indexAngle];
        }
        else if (distance<angleDistanceList[indexAngle]&&distance>angleDistanceList[indexAngle-1]){
            angle = ((angleList[indexAngle]-angleList[indexAngle-1])/(angleDistanceList[indexAngle]-angleDistanceList[indexAngle-1])*(distance-angleDistanceList[indexAngle])+angleList[indexAngle]);
            return angle;
        }
        else{
            return -1;
        }
    }

    public void setVelocity(double velocity){
        velocityMotor.set(unitModel.toTicks100ms(velocity/60));
    }

    public double getVelocity(){
        return unitModel.toUnits(velocityMotor.get());
    }

    public double getAngle(){
        return angleMotor.getSelectedSensorPosition();
    }

    public void setAngle(Rotation2d angle) {
        Rotation2d error = angle.minus(Rotation2d.fromDegrees(getAngle()));
        angleMotor.set(ControlMode.MotionMagic, angleMotor.getSelectedSensorPosition() + unitModel.toTicks(error.getRadians()));
    }

    public void terminate(){
        angleMotor.stopMotor();
        velocityMotor.stopMotor();
    }


}
