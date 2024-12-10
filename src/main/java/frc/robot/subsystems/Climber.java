// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants.CAN;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class Climber extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private TalonFX leftClimber;
  private TalonFX rightClimber;

  public Climber() {
    leftClimber = new TalonFX(CAN.kLeftClimbCAN);
    rightClimber = new TalonFX(CAN.kRightClimbCAN);

    var config = new TalonFXConfiguration();
    config.CurrentLimits.StatorCurrentLimit = Constants.ClimberConstants.kClimberCurrentLimit;
    config.CurrentLimits.StatorCurrentLimitEnable = true;
    config.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    leftClimber.getConfigurator().apply(config);
    rightClimber.setControl(new Follower(CAN.kLeftClimbCAN, true));
  }

  public void setVoltage(double voltage) {
    leftClimber.setVoltage(voltage);
  }
}
