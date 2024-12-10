// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.ClimberConstants;
import frc.robot.subsystems.Climber;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  
  private final Climber climber = new Climber();
  
  private final CommandXboxController driverOI =
  new CommandXboxController(OperatorConstants.kDriverControllerPort);
  
  public RobotContainer() {
    configureBindings();
  }
  
  private void configureBindings() {
    System.out.println("Bindings Configured!");
    // driverOI.leftStick().whileTrue(new InstantCommand(
    // () -> climber.setVoltage(driverOI.getLeftY() * ClimberConstants.kVoltageMultiplier), climber
    // ));
    driverOI.a().whileTrue(new InstantCommand(
      () -> climber.setVoltage(8.0), climber
    ));

    driverOI.a().onFalse(new InstantCommand(
      () -> climber.setVoltage(0.0), climber
    ));
    driverOI.x().whileTrue(new InstantCommand(
      () -> climber.setVoltage(-2.0), climber
    ));
    driverOI.x().onFalse(new InstantCommand(
      () -> climber.setVoltage(0.0), climber
    ));
  }
}
