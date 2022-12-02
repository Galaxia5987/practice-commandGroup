package frc.robot;


import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;

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

    public static final class SwerveConstants {
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

    public static final class HelicopterConstants {
        public static final double GEAR_RATIO = 292.1;
        public static final double TICKS_PER_RAD = 2048 * GEAR_RATIO / (2 * Math.PI);
        public static final double TICKS_PER_RAD_ABSOLUTE = 1 / (2 * Math.PI);
        public static final TalonFXInvertType CLOCK_WISE = TalonFXInvertType.Clockwise;
        public static final TalonFXInvertType COUNTER_CLOCK_WISE = TalonFXInvertType.CounterClockwise;
        public static final double CRUISE_VELOCITY = 0; // [ticks/100ms]
        public static final double MAXIMAL_ACCELERATION = 0; // [ticks/100ms*sec]
        public static final double DEAD_BEND = 0.05;
    }

    public static final class VisionConstants {
        public static final double CAMERA_PITCH = 34.67; //[deg]
        public static final double TARGET_HEIGHT = 2.64; //[m]
        public static final double CAMERA_HEIGHT = 0.79; //[m]
    }
}
