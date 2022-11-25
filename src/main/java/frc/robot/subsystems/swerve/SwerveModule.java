package frc.robot.subsystems.swerve;

import com.ctre.phoenix.motorcontrol.ControlMode;
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
    private static final UnitModel angleUnitModel = new UnitModel(Constants.SwerveConstants.ANGLE_MOTOR_TICKS_PER_ROTATION);
    private static final WPI_TalonFX driveMotor = new WPI_TalonFX(Ports.SwervePorts.DRIVE_MOTOR);
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
        return Math.toRadians(angleUnitModel.toUnits(angleMotor.getSelectedSensorPosition()))/1024;
    }

    public static void setAngle(Rotation2d angle){
        Rotation2d error = angle.minus(Rotation2d.fromDegrees(getAngle()));
        angleMotor.set(ControlMode.MotionMagic, angleMotor.getSelectedSensorPosition()+angleUnitModel.toTicks(error.getRadians()));
    }

    public static void setVelocity(double velocity){
        driveMotor.set(velocity);
    }

    public static double getVelocity(){
        return driveMotor.get();
    }

    public static void setState(SwerveModuleState state){
        Rotation2d currentAngle = Rotation2d.fromDegrees(SwerveModule.getAngle());
        SwerveModuleState.optimize(state, currentAngle);
    }

    public static SwerveModuleState getState(){
        return new SwerveModuleState(getVelocity(), Rotation2d.fromDegrees(getAngle()));
    }

    public static void stopAngleMotor(){
        angleMotor.stopMotor();
    }

    public static void stopDriveMotor(){
        driveMotor.stopMotor();
    }
}
