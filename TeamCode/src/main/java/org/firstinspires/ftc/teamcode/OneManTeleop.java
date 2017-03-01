package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Steven on 12/15/2016.
 */

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="OneManTeleop", group="Teleop")
public class OneManTeleop extends LinearOpMode {

	protected double speed;
	protected DcMotor motorL;
	protected DcMotor motorR;

	@Override
	public void runOpMode() throws InterruptedException {
		motorL = hardwareMap.dcMotor.get("motorL");
		motorR = hardwareMap.dcMotor.get("motorR");
		speed = 0;
		motorL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
		motorR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

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

			if (gamepad1.right_trigger > .05) {
				speed = gamepad1.right_trigger;
				speed = (speed / 2) + .5;
			} else {
				speed = 0;
			}
			telemetry.addData("speed", speed);
			telemetry.update();
		}
	}
}
