package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Steven on 12/15/2016.
 */

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="OneManTeleop", group="OneManTeleop")
public class OneManTeleop extends LinearOpMode {

	protected double speed;
	protected DcMotor motorL;
	protected DcMotor motorR;

	@Override
	public void runOpMode() throws InterruptedException {
		motorL = hardwareMap.dcMotor.get("motorL");
		motorR = hardwareMap.dcMotor.get("motorR");
		speed = 1;

		waitForStart();

		while (opModeIsActive()) {
			if (Math.abs(gamepad1.left_stick_y) > .05) {
				motorL.setPower(-gamepad1.left_stick_y * speed);
			} else {
				motorL.setPower(0);
			}
			if (Math.abs(gamepad1.right_stick_y) > .05) {
				motorR.setPower(gamepad1.right_stick_y * speed);
			} else {
				motorR.setPower(0);
			}
			if (gamepad1.left_bumper) {
				if (speed > 0) {
					speed -= .1;
					Thread.sleep(200);
				}
			} else {
				if (gamepad1.right_bumper) {
					if (speed < 1) {
						speed += .1;
						Thread.sleep(200);
					}
				}
			}
			if (speed > 1) {
				speed = 1;
			}
			if (speed < .3) {
				speed = .3;
			}
			telemetry.addData("speed", speed);
			telemetry.update();
		}
	}
}
