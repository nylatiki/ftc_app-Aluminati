package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by BenL on 11/23/15.
 */

public class ServoTest extends OpMode
{

    ServoController servoControl;
    Servo           servo;
    double          servoPos;
    boolean         oldX;
    boolean         oldY;

    // Constants
    final double   INTERVAL = 0.1;

    @Override
    public void init()
    {

        servo        = hardwareMap.servo.get("servo");
        servoControl = hardwareMap.servoController.get("ServoControl");

        servoPos = 0;
    }

    @Override
    public void loop()
    {

        // Increment or decrement the servo position once
        if (gamepad1.x && !oldX)
        {
            servoPos -= INTERVAL;
        }
        else if (gamepad1.y && !oldY)
        {
            servoPos += INTERVAL;
        }

        telemetry.addData("Servo Value:  ", servoPos);
        servo.setPosition(servoPos);

        oldX = gamepad1.x;
        oldY = gamepad1.y;
    }

    @Override
    public void stop()
    {
        // nothing to stop
    }

    // Input scale from NXTTeleOp for more accuracy in lower ranges
    double scaleInput(double dVal)
    {
        double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

        // get the corresponding index for the scaleInput array.
        int index = (int) (dVal * 16.0);

        // index should be positive.
        if (index < 0) {
            index = -index;
        }

        // index cannot exceed size of array minus 1.
        if (index > 16) {
            index = 16;
        }

        // get value from the array.
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        // return scaled value.
        return dScale;
    }
}
