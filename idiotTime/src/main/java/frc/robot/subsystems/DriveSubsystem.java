/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveManuallyCommand;


/**
 * Add your docs here.
 */
  
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // instantiate new motor controller objects
  public PWMTalonSRX leftMaster = new PWMTalonSRX(RobotMap.leftMasterPort);
  public PWMTalonSRX leftSlave = new PWMTalonSRX(RobotMap.leftSlavePort);
  public PWMTalonSRX rightMaster = new PWMTalonSRX(RobotMap.rightMasterPort);
  public PWMTalonSRX rightSlave = new PWMTalonSRX(RobotMap.rightSlavePort);

  SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(leftMaster, leftSlave);
  SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(rightMaster, rightSlave);

  
  // instantiate a new DifferentialDrive object pass motor controllers as arguments

  public DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);

  // create constructor function
  public DriveSubsystem() {
      // point slaves to masters
      //leftSlave.follow(leftMaster);
      //rightSlave.follow(rightMaster);

  }
  // add manualDrive() method
  public void manualDrive(double move, double turn){ 

    if(Math.abs(move) < .1){
      move = 0;
    }
    if(Math.abs(turn) < .1){
      turn = 0;
    }
    
    drive.arcadeDrive(move, turn);

  }




  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveManuallyCommand());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
