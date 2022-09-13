package frc.robot;


import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import frc.robot.valuetuner.WebConstant;

public final class Constants {
    public static final int CONFIG_VOLT_COMP = 10;
    public static final boolean ENABLE_VOLT_COMP = true;
    public static final TalonFXInvertType CLOCKWISE = TalonFXInvertType.Clockwise;
    public static final boolean PISTON_CLOSE = false;
    public static final boolean PISTON_OPEN = true;
    public static final double INTAKE_POWER = 0.5;
    public static final double CONVEYOR_POWER = 0.5;

}
