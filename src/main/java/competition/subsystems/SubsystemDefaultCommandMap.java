package competition.subsystems;

import javax.inject.Inject;
import javax.inject.Singleton;

import competition.injection.swerve.FrontLeftDrive;
import competition.injection.swerve.FrontRightDrive;
import competition.injection.swerve.RearLeftDrive;
import competition.injection.swerve.RearRightDrive;
import competition.injection.swerve.SwerveComponent;
import competition.subsystems.arm.UnifiedArmSubsystem;
import competition.subsystems.arm.commands.UnifiedArmMaintainer;
import competition.subsystems.claw.ClawGripperMotorSubsystem;
import competition.subsystems.claw.ClawSubsystem;
import competition.subsystems.claw.CloseClawCommand;
import competition.subsystems.drive.DriveSubsystem;
import competition.subsystems.drive.commands.SwerveDriveWithJoysticksCommand;
import competition.subsystems.simple.SimpleSetPowerCommand;
import competition.subsystems.simple.SimpleSubsystem;

/**
 * For setting the default commands on subsystems
 */
@Singleton
public class SubsystemDefaultCommandMap {

    @Inject
    public SubsystemDefaultCommandMap() {}

    @Inject
    public void setupDriveSubsystem(DriveSubsystem driveSubsystem, SwerveDriveWithJoysticksCommand command) {
        driveSubsystem.setDefaultCommand(command);
    }

    @Inject
    public void setupFrontLeftSubsystems(
            @FrontLeftDrive SwerveComponent swerveComponent) {
        swerveComponent.swerveDriveSubsystem().setDefaultCommand(swerveComponent.swerveDriveMaintainerCommand());
        swerveComponent.swerveSteeringSubsystem().setDefaultCommand(swerveComponent.swerveSteeringMaintainerCommand());
    }

    @Inject
    public void setupFrontRightSubsystems(
            @FrontRightDrive SwerveComponent swerveComponent) {
        swerveComponent.swerveDriveSubsystem().setDefaultCommand(swerveComponent.swerveDriveMaintainerCommand());
        swerveComponent.swerveSteeringSubsystem().setDefaultCommand(swerveComponent.swerveSteeringMaintainerCommand());
    }
    
    @Inject
    public void setupRearLeftSubsystems(
            @RearLeftDrive SwerveComponent swerveComponent) {
        swerveComponent.swerveDriveSubsystem().setDefaultCommand(swerveComponent.swerveDriveMaintainerCommand());
        swerveComponent.swerveSteeringSubsystem().setDefaultCommand(swerveComponent.swerveSteeringMaintainerCommand());
    }

    @Inject
    public void setupRearRightSubsystems(
            @RearRightDrive SwerveComponent swerveComponent) {
        swerveComponent.swerveDriveSubsystem().setDefaultCommand(swerveComponent.swerveDriveMaintainerCommand());
        swerveComponent.swerveSteeringSubsystem().setDefaultCommand(swerveComponent.swerveSteeringMaintainerCommand());
    }

    @Inject
    public void setupSimpleSubsystem(SimpleSubsystem simpleSubsystem, SimpleSetPowerCommand command) {
        simpleSubsystem.setDefaultCommand(command);
    }

    @Inject
    public void setupArmSubsystem(UnifiedArmSubsystem arms, UnifiedArmMaintainer maintainer) {
        arms.setDefaultCommand(maintainer);
    }

    @Inject
    public void setupClawSubsystem(ClawSubsystem claw, CloseClawCommand closeCommand) {
        claw.setDefaultCommand(closeCommand);
    }

    @Inject
    void setupClawMotorSubsystem(ClawGripperMotorSubsystem claw) {
        claw.setDefaultCommand(claw.createStopCommand());
    }
}
