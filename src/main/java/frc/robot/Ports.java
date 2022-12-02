package frc.robot;

public final class Ports {
    public static class IntakePorts {
        public static final int MOTOR = 0;
        public static final int PISTON = 0;
    }

    public static class ConveyorPorts {
        public static final int BOTTOM_MOTOR = 0;
        public static final int UPPER_MOTOR = 0;
    }

    public static class ShooterPorts {
        public static final int LEFT_MOTOR = 0;
        public static final int RIGHT_MOTOR = 0;
    }

    public static class SwervePorts {
        public static final int DRIVE_MOTOR = 0;
        public static final int ANGLE_MOTOR = 0;
        public static final boolean FALCON_INVERTED_DRIVE = false;
        public static final boolean RED_LINE_INVERTED_ANGLE = true;
        public static final int FL_DRIVE_MOTOR = 0;
        public static final int FL_ANGLE_MOTOR = 0;
        public static final int FR_DRIVE_MOTOR = 0;
        public static final int FR_ANGLE_MOTOR = 0;
        public static final int RL_DRIVE_MOTOR = 0;
        public static final int RL_ANGLE_MOTOR = 0;
        public static final int RR_DRIVE_MOTOR = 0;
        public static final int RR_ANGLE_MOTOR = 0;
    }

    public static class HelicopterPorts {
        public static final int MAIN_MOTOR = 0;
        public static final int AUX_MOTOR = 0;
        public static final boolean SENSOR_PHASE = true;
    }
}
