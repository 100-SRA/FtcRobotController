package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "mechdrivecaleb (Blocks to Java)")
public class mechdrivecaleb extends LinearOpMode {

    private DcMotor FrontRight;
    private DcMotor BackRight;

    /**
     * This sample contains the bare minimum Blocks for any regular OpMode. The 3 blue
     * Comment Blocks show where to place Initialization code (runs once, after touching the
     * DS INIT button, and before touching the DS Start arrow), Run code (runs once, after
     * touching Start), and Loop code (runs repeatedly while the OpMode is active, namely not
     * Stopped).
     */
    @Override
    public void runOpMode() {
        float y;
        double x;
        float rx;

        FrontRight = hardwareMap.get(DcMotor.class, "Front Right");
        BackRight = hardwareMap.get(DcMotor.class, "Back Right");

        // Put initialization blocks here.
        FrontRight.setDirection(DcMotor.Direction.REVERSE);
        BackRight.setDirection(DcMotor.Direction.REVERSE);
        waitForStart();
        while (opModeIsActive()) {
            // Put loop blocks here.
            telemetry.update();
            y = -gamepad1.left_stick_y;
            x = gamepad1.left_stick_x * 1.1;
            rx = gamepad1.right_stick_x;
        }
    }
}