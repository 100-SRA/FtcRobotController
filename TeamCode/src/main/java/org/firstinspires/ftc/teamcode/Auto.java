package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Auto (Blocks to Java)")
public class Auto extends LinearOpMode {

    private DcMotor Arm;
    private DcMotor BackLeft;
    private DcMotor Arm2;
    private DcMotor BackRight;
    private DcMotor FrontRight;
    private DcMotor FrontLeft;
    private Servo Claw;

    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        Arm = hardwareMap.get(DcMotor.class, "ArmAsDcMotor");
        BackLeft = hardwareMap.get(DcMotor.class, "Back Left");
        Arm2 = hardwareMap.get(DcMotor.class, "Arm2AsDcMotor");
        BackRight = hardwareMap.get(DcMotor.class, "Back Right");
        FrontRight = hardwareMap.get(DcMotor.class, "Front Right");
        FrontLeft = hardwareMap.get(DcMotor.class, "Front Left");
        Claw = hardwareMap.get(Servo.class, "ClawAsServo");

        // This OpMode illustrates driving a 4-motor Omni-Directional (or Holonomic) robot.
        // This code will work with either a Mecanum-Drive or an X-Drive train.
        // Both of these drives are illustrated at https://gm0.org/en/latest/docs/robot-design/drivetrains/holonomic.html
        // Note that a Mecanum drive must display an X roller-pattern when viewed from above.
        // Also note that it is critical to set the correct rotation direction for each motor.  See details below.
        // Holonomic drives provide the ability for the robot to move in three axes (directions) simultaneously.
        // Each motion axis is controlled by one Joystick axis.
        // 1) Axial:    Driving forward and backward                Left-joystick Forward/Backward
        // 2) Lateral:  Strafing right and left                     Left-joystick Right and Left
        // 3) Yaw:      Rotating Clockwise and counter clockwise    Right-joystick Right and Left
        // This code is written assuming that the right-side motors need to be reversed for the robot to drive forward.
        // When you first test your robot, if it moves backward when you push the left stick forward, then you must flip
        // the direction of all 4 motors (see code below).
        // ########################################################################################
        // !!!            IMPORTANT Drive Information. Test your motor directions.            !!!!!
        // ########################################################################################
        // Most robots need the motors on one side to be reversed to drive forward.
        // The motor reversals shown here are for a "direct drive" robot (the wheels turn the same direction as the motor shaft).
        // If your robot has additional gear reductions or uses a right-angled drive, it's important to ensure
        // that your motors are turning in the correct direction.  So, start out with the reversals here, BUT
        // when you first test your robot, push the left joystick forward and observe the direction the wheels turn.
        // Reverse the direction (flip FORWARD <-> REVERSE ) of any wheel that runs backward.
        // Keep testing until ALL the wheels move the robot forward when you push the left joystick forward.
        Arm.setDirection(DcMotor.Direction.REVERSE);
        BackLeft.setDirection(DcMotor.Direction.FORWARD);
        Arm2.setDirection(DcMotor.Direction.FORWARD);
        BackRight.setDirection(DcMotor.Direction.FORWARD);
        // Wait for the game to start (driver presses PLAY)
        // Run until the end of the match (driver presses STOP)
        waitForStart();
        for (int count = 0; count < 1; count++) {
            FrontRight.setPower(0.5);
            FrontLeft.setPower(0.5);
            BackRight.setPower(-0.5);
            BackLeft.setPower(-0.5);
            sleep(4000);
        }
        for (int count2 = 0; count2 < 1; count2++) {
            FrontRight.setPower(-0.5);
            FrontLeft.setPower(0.5);
            BackRight.setPower(-0.5);
            BackLeft.setPower(0.5);
            sleep(3100);
        }
        for (int count3 = 0; count3 < 1; count3++) {
            FrontRight.setPower(0);
            FrontLeft.setPower(0);
            BackRight.setPower(0);
            BackLeft.setPower(0);
            sleep(100);
        }
        for (int count4 = 0; count4 < 1; count4++) {
            Arm2.setPower(0.5);
            Arm.setPower(0.5);
            sleep(2900);
        }
        for (int count5 = 0; count5 < 1; count5++) {
            Arm2.setPower(0);
            Arm.setPower(0);
            sleep(100);
        }
        for (int count6 = 0; count6 < 1; count6++) {
            Claw.setPosition(0);
            sleep(2000);
        }
        for (int count7 = 0; count7 < 1; count7++) {
            Arm2.setPower(-0.5);
            Arm.setPower(-0.5);
            sleep(2400);
        }
    }
}