package frc.robot;


import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import frc.robot.valuetuner.WebConstant;

public final class Constants {
    public static final int CONFIG_VOLT_COMP = 10;
    public static final boolean ENABLE_VOLT_COMP = true;
    public static final InvertType CLOCKWISE = InvertType.InvertMotorOutput;

    public static final class shooterConstants {
        public static final TalonFXInvertType CLOCKWISE = TalonFXInvertType.Clockwise;
        public static final TalonFXInvertType COUNTER_CLOCKWISE = TalonFXInvertType.CounterClockwise;
        public static final int TALON_TIMEOUT = 10;//[ms]
        public static final double kP = 0;
        public static final double kI = 0;
        public static final double kD = 0;
        public static final double TICKS_PER_ROTATION = 2048;
        public static final double SHOOTER_VELOCITY = 0;
    }

    public static final class intakeConstants {
        public static final double INTAKE_POWER = 0.5;
        public static final boolean PISTON_CLOSE = false;
        public static final boolean PISTON_OPEN = true;
    }

    public static final class conveyorConstants {
        public static final double CONVEYOR_POWER = 0.5;
    }

    public static final class SwerveConstants{
        public static final int CONFIG_VOLT_COMP = 10;
        public static final boolean ENABLE_VOLT_COMP = true;
        public static final int TALON_TIMEOUT = 10;//[ms]
        public static final double FALCON_P = 0;
        public static final double FALCON_I = 0;
        public static final double FALCON_D = 0;
        public static final double TALON_P = 0;
        public static final double TALON_I = 0;
        public static final double TALON_D = 0;
        public static final double ANGLE_MOTOR_TICKS_PER_ROTATION = 1024;


    }
}
