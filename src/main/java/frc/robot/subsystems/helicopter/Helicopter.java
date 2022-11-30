package frc.robot.subsystems.helicopter;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports;

public class Helicopter extends SubsystemBase {
    private final Helicopter INSTANCE = null;
    private static final WPI_TalonFX mainMotor = new WPI_TalonFX(Ports.HelicopterPorts.MAIN_MOTOR);
    private static final WPI_TalonFX auxMotor = new WPI_TalonFX(Ports.HelicopterPorts.AUX_MOTOR);
    
}
