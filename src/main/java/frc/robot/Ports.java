package frc.robot;

public final class Ports {
    public static class IntakePorts{
        public static final int MOTOR = 0;
        public static final int PISTON = 0;
    }

    public static class ConveyorPorts{
        public static final int BOTTOM_MOTOR = 0;
        public static final int UPPER_MOTOR = 0;
    }

    public static class ShooterPorts{
        public static final int LEFT_MOTOR=0;
        public static final int RIGHT_MOTOR=0;
    }

    public static class SwervePorts{
        public static final int DRIVE_MOTOR=0;
        public static final int ANGLE_MOTOR=0;
        public static final boolean FALCON_INVERTED_DRIVE=false;
        public static final boolean RED_LINE_INVERTED_ANGLE=true;
    }
}
