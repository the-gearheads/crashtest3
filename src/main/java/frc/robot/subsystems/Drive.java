// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.TankDrive;

public class Drive extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private CANSparkMax flMotor;
  private CANSparkMax frMotor;
  private CANSparkMax blMotor;
  private CANSparkMax brMotor;

  private SpeedControllerGroup rightMotors;
  private SpeedControllerGroup leftMotors;

  private DifferentialDrive differentialDrive;
  public Drive() {
    flMotor = new CANSparkMax(Constants.flMotor, MotorType.kBrushless);
    frMotor = new CANSparkMax(Constants.frMotor, MotorType.kBrushless);
    blMotor = new CANSparkMax(Constants.blMotor, MotorType.kBrushless);
    brMotor = new CANSparkMax(Constants.brMotor, MotorType.kBrushless);
    leftMotors = new SpeedControllerGroup(flMotor, blMotor);
    rightMotors = new SpeedControllerGroup(frMotor, brMotor);
    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);

    setDefaultCommand(new ArcadeDrive(this));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeed(double left, double right){
    leftMotors.set(left);
    rightMotors.set(right);
  }

  public void arcadeDrive(double x, double y){
    differentialDrive.arcadeDrive(y,x);
  }
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}


