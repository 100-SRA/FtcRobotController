package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "test (Blocks to Java)")
public class test extends LinearOpMode {

    private DcMotor BackRight;
    private DcMotor BackLeft;
    private DcMotor FrontRight;
    private DcMotor FrontLeft;

    /**
     * This OpMode offers Tank Drive style TeleOp control for a direct drive robot.
     *
     * In this Tank Drive mode, the left and right joysticks (up
     * and down) drive the left and right motors, respectively.
     */
    @Override
    public void runOpMode() {
        BackRight = hardwareMap.get(DcMotor.class, "Back Right");
        BackLeft = hardwareMap.get(DcMotor.class, "Back Left");
        FrontRight = hardwareMap.get(DcMotor.class, "Front Right");
        FrontLeft = hardwareMap.get(DcMotor.class, "Front Left");

        // Reverse one of the drive motors.
        // You will have to determine which motor to reverse for your robot.
        // In this example, the right motor was reversed so that positive
        // applied power makes it move the robot in the forward direction.
        BackRight.setDirection(DcMotor.Direction.REVERSE);
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // Put loop blocks here.
                // The Y axis of a joystick ranges from -1 in its topmost position to +1 in its bottommost position.
                // We negate this value so that the topmost position corresponds to maximum forward power.
                BackLeft.setPower(-gamepad1.left_stick_y);
                BackRight.setPower(-gamepad1.right_stick_y);
                // The Y axis of a joystick ranges from -1 in its topmost position to +1 in its bottommost position.
                // We negate this value so that the topmost position corresponds to maximum forward power.
                FrontRight.setPower(-gamepad1.left_stick_y);
                FrontLeft.setPower(-gamepad1.right_stick_y);
                telemetry.addData("Left Pow", BackLeft.getPower());
                telemetry.addData("Right Pow", BackRight.getPower());
                telemetry.update();
            }
        }
    }
}