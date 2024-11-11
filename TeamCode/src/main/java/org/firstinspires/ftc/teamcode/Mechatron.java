package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.JavaUtil;

@TeleOp(name = "Mechatron (Blocks to Java)")
public class Mechatron extends LinearOpMode {

    private DcMotor FrontLeft;
    private DcMotor FrontRight;
    private DcMotor BackLeft;
    private DcMotor BackRight;

    double Front_Left;
    double Back_Left;
    double Front_Right;
    double Back_Right;

    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        ElapsedTime runtime;
        float axial;
        float lateral;
        float yaw;
        double max;

        FrontLeft = hardwareMap.get(DcMotor.class, "Front Left");
        FrontRight = hardwareMap.get(DcMotor.class, "Front Right");
        BackLeft = hardwareMap.get(DcMotor.class, "Back Left");
        BackRight = hardwareMap.get(DcMotor.class, "Back Right");

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
        runtime = new ElapsedTime();
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
        FrontLeft.setDirection(DcMotor.Direction.FORWARD);
        FrontRight.setDirection(DcMotor.Direction.FORWARD);
        BackLeft.setDirection(DcMotor.Direction.REVERSE);
        BackRight.setDirection(DcMotor.Direction.REVERSE);
        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        runtime.reset();
        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
            // Note: pushing stick forward gives negative value
            axial = -gamepad1.left_stick_y;
            lateral = gamepad1.left_stick_x;
            yaw = gamepad1.right_stick_x;
            if (gamepad1.left_bumper) {
                axial = axial / 2;
                lateral = lateral / 2;
                yaw = yaw / 2;
            }
            // Combine the joystick requests for each axis-motion to determine each wheel's power.
            // Set up a variable for each drive wheel to save the power level for telemetry.
            Front_Left = axial + lateral + yaw;
            Front_Right = (axial - lateral) - yaw;
            Back_Left = (axial - lateral) + yaw;
            Back_Right = (axial + lateral) - yaw;
            // Normalize the values so no wheel power exceeds 100%
            // This ensures that the robot maintains the desired motion.
            max = JavaUtil.maxOfList(JavaUtil.createListWith(Math.abs(Front_Left), Math.abs(Front_Right), Math.abs(Back_Left), Math.abs(Back_Right)));
            if (max > 1) {
                Front_Left = Front_Left / max;
                Front_Right = Front_Right / max;
                Back_Left = Back_Left / max;
                Back_Right = Back_Right / max;
            }
            telemetry.addData("Status", "Run Time: " + runtime);
            telemetry.addData("Front left/Right", JavaUtil.formatNumber(Front_Left, 4, 2) + ", " + JavaUtil.formatNumber(Front_Right, 4, 2));
            telemetry.addData("Back  left/Right", JavaUtil.formatNumber(Back_Left, 4, 2) + ", " + JavaUtil.formatNumber(Back_Right, 4, 2));
            telemetry.update();
        }
    }
}