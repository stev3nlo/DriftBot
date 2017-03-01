package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by stev3 on 3/1/2017.
 */

@TeleOp(name="CarTeleop", group="Teleop")
public class CarTeleop extends LinearOpMode {

	protected double forwardSpeed;
	protected double reverseSpeed;
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

			if (gamepad1.right_trigger > .05) {
				speed = gamepad1.right_trigger * .5 + .5;
			} else {
				speed = 0;
			}

			if (gamepad1.left_trigger > .05) {
				motorL.setPower(0);
				motorR.setPower(0);
			}

			if (gamepad1.x) {
				speed = Math.abs(speed) * -1;
			} else {
				speed = Math.abs(speed);
			}

			if (gamepad1.left_stick_x > .05) {
				motorL.setPower(speed - Math.abs(gamepad1.left_stick_x) * speed * .5);
				motorR.setPower(speed);
			} else {
				if (gamepad1.left_stick_x < -.05) {
					motorL.setPower(speed);
					motorR.setPower(speed - Math.abs(gamepad1.left_stick_x) * speed * .5);
				} else {
					motorL.setPower(0);
					motorR.setPower(0);
				}
			}
		}
	}
}
