package frc.robot.subsystems.swerve;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;
import frc.robot.subsystems.UnitModel;

public class SwerveModule extends SubsystemBase {
    private static final UnitModel unitModel = new UnitModel(Constants.SwerveConstants.TICKS_PER_ROTATION);
    private final WPI_TalonFX driveMotor = new WPI_TalonFX(Ports.SwervePorts.DRIVE_MOTOR);
    private static final WPI_TalonSRX angleMotor = new WPI_TalonSRX(Ports.SwervePorts.ANGLE_MOTOR);

    public SwerveModule(){
        driveMotor.enableVoltageCompensation(Constants.SwerveConstants.ENABLE_VOLT_COMP);
        driveMotor.configVoltageCompSaturation(Constants.SwerveConstants.CONFIG_VOLT_COMP);
        driveMotor.setInverted(Ports.SwervePorts.FALCON_INVERTED_DRIVE);
        driveMotor.config_kP(0, Constants.SwerveConstants.FALCON_P, Constants.SwerveConstants.TALON_TIMEOUT);
        driveMotor.config_kI(0, Constants.SwerveConstants.FALCON_I, Constants.SwerveConstants.TALON_TIMEOUT);
        driveMotor.config_kI(0, Constants.SwerveConstants.FALCON_D, Constants.SwerveConstants.TALON_TIMEOUT);
        angleMotor.config_kP(0, Constants.SwerveConstants.TALON_P, Constants.SwerveConstants.TALON_TIMEOUT);
        angleMotor.config_kP(0, Constants.SwerveConstants.TALON_I, Constants.SwerveConstants.TALON_TIMEOUT);
        angleMotor.config_kP(0, Constants.SwerveConstants.TALON_D, Constants.SwerveConstants.TALON_TIMEOUT);
        angleMotor.enableVoltageCompensation(Constants.SwerveConstants.ENABLE_VOLT_COMP);
        angleMotor.configVoltageCompSaturation(Constants.SwerveConstants.CONFIG_VOLT_COMP);
        angleMotor.setInverted(Ports.SwervePorts.RED_LINE_INVERTED_ANGLE);
    }
    public static double getAngle(){
        return Math.toRadians(unitModel.toUnits(angleMotor.getSelectedSensorPosition()))/1024;
    }
    

    public static void setAngle(double angle){
        Rotation2d desiredAngle = Rotation2d.fromDegrees(angle);
        SwerveModuleState desiredState = new SwerveModuleState(0, desiredAngle);
        Rotation2d currentAngle = new Rotation2d(SwerveModule.getAngle());
        SwerveModuleState optimizedSwerveModuleState= SwerveModuleState.optimize(desiredState, currentAngle);
        angleMotor.set();
    }
}
