package frc.robot.subsystems.vision;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import java.util.OptionalDouble;

public class Vision extends SubsystemBase {
    private static Vision INSTANCE = null;
    private final NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    private final NetworkTableEntry tx = table.getEntry("tx");
    private final NetworkTableEntry ty = table.getEntry("ty");
    private final NetworkTableEntry tv = table.getEntry("tv");

    public static Vision getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Vision();
        }
        return INSTANCE;
    }

    public OptionalDouble getDistance() {
        if (hasTargets()) {
            return OptionalDouble.of((Constants.VisionConstants.TARGET_HEIGHT - Constants.VisionConstants.CAMERA_HEIGHT) / Math.tan(Constants.VisionConstants.CAMERA_PITCH + ty.getDouble(0)));
        }
        return OptionalDouble.empty();
    }

    public OptionalDouble getYaw() {
        if (hasTargets()) return OptionalDouble.of(tx.getDouble(0));
        return OptionalDouble.empty();
    }

    public boolean hasTargets() {
        return tv.getDouble(0) != 0;
    }
}
