package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Steven on 12/15/2016.
 */

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="TwoManTeleop", group="Teleop")
public class TwoManTeleop extends LinearOpMode {

	protected double speedL;
	protected double speedR;
	protected DcMotor motorL;
	protected DcMotor motorR;

	@Override
	public void runOpMode() throws InterruptedException {
		motorL = hardwareMap.dcMotor.get("motorL");
		motorR = hardwareMap.dcMotor.get("motorR");
		speedL = 0;
		speedR = 0;
		motorL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
		motorR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

		waitForStart();

		while (opModeIsActive()) {
			if (Math.abs(gamepad1.left_stick_y) > .05) {
				motorL.setPower(-gamepad1.left_stick_y * speedL);
			} else {
				motorL.setPower(0);
			}
			if (Math.abs(gamepad2.right_stick_y) > .05) {
				motorR.setPower(gamepad2.right_stick_y * speedR);
			} else {
				motorR.setPower(0);
			}
			if (gamepad1.right_trigger > .05) {
				speedL = gamepad1.right_trigger;
				speedL = (speedL / 2) + .5;
			} else {
				speedL = 0;
			}

			if (gamepad2.right_trigger > .05) {
				speedR = gamepad2.right_trigger;
				speedR = (speedR / 2) + .5;
			} else {
				speedR = 0;
			}

			telemetry.addData("speedL", speedL);
			telemetry.addData("speedR", speedR);
			telemetry.update();
		}
	}
}
