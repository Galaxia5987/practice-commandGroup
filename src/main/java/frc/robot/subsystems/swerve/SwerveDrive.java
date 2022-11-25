package frc.robot.subsystems.swerve;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports;

public class SwerveDrive extends SubsystemBase {
    private static SwerveDrive ROBOT_ORIENTED_DRIVE = null;
    private static SwerveDrive FIELD_ORIENTED_DRIVE = null;
    private static final SwerveModule[] modules = new SwerveModule[4];
    private static final SwerveDriveKinematics kinematics = new SwerveDriveKinematics();
    private static final SwerveDriveOdometry odometry = new SwerveDriveOdometry(kinematics, new Rotation2d());
    private static final SwerveDriveOdometry odometryForDistance = new SwerveDriveOdometry(kinematics, new Rotation2d());
    private static SwerveModule frontLeft = modules[0];
    private static SwerveModule frontRight = modules[1];
    private static SwerveModule rearLeft = modules[2];
    private static SwerveModule rearRight = modules[3];
    private static final WPI_TalonFX FR_DRIVE_MOTOR = new WPI_TalonFX(Ports.SwervePorts.FL_DRIVE_MOTOR);
    private static final WPI_TalonSRX FR_ANGLE_MOTOR = new WPI_TalonSRX(Ports.SwervePorts.FL_ANGLE_MOTOR);
    private static final WPI_TalonFX FL_DRIVE_MOTOR = new WPI_TalonFX(Ports.SwervePorts.FR_DRIVE_MOTOR);
    private static final WPI_TalonSRX FL_ANGLE_MOTOR = new WPI_TalonSRX(Ports.SwervePorts.FR_ANGLE_MOTOR);
    private static final WPI_TalonFX RL_DRIVE_MOTOR = new WPI_TalonFX(Ports.SwervePorts.RL_DRIVE_MOTOR);
    private static final WPI_TalonSRX RL_ANGLE_MOTOR = new WPI_TalonSRX(Ports.SwervePorts.RL_ANGLE_MOTOR);
    private static final WPI_TalonFX RR_DRIVE_MOTOR = new WPI_TalonFX(Ports.SwervePorts.RR_DRIVE_MOTOR);
    private static final WPI_TalonSRX RR_ANGLE_MOTOR = new WPI_TalonSRX(Ports.SwervePorts.RR_ANGLE_MOTOR);

    public static SwerveDrive getRobotOrientedDriveInstance(){
        if (ROBOT_ORIENTED_DRIVE==null){
            ROBOT_ORIENTED_DRIVE=new SwerveDrive();
        }
        return ROBOT_ORIENTED_DRIVE;
    }

    public static SwerveDrive getFieldOrientedDriveInstance(){
        if (FIELD_ORIENTED_DRIVE==null){
            FIELD_ORIENTED_DRIVE=new SwerveDrive();
        }
        return FIELD_ORIENTED_DRIVE;
    }

    public static Pose2d getPose(){
        return odometry.getPoseMeters();
    }

    public static void resetOdometry(){
        odometry.resetPosition(new Pose2d(), new Rotation2d());
    }

    public static void setPower(double power){
        FL_DRIVE_MOTOR.set(power);
        FR_DRIVE_MOTOR.set(power);
        RL_DRIVE_MOTOR.set(power);
        RR_DRIVE_MOTOR.set(power);
    }

    public static void terminate(){
        FL_DRIVE_MOTOR.set(0);
        FR_DRIVE_MOTOR.set(0);
        RL_DRIVE_MOTOR.set(0);
        RR_DRIVE_MOTOR.set(0);
        FL_ANGLE_MOTOR.set(0);
        FR_ANGLE_MOTOR.set(0);
        RL_ANGLE_MOTOR.set(0);
        RR_ANGLE_MOTOR.set(0);

    }
}
