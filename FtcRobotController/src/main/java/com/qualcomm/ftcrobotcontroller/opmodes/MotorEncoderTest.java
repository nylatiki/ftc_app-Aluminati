package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by BenL on 10/16/15.
 */
public class MotorEncoderTest extends OpMode
{
    private DcMotorController.DeviceMode    devMode;
    private DcMotorController               motorControl;
    private DcMotor                         testMotor;
    //private int                             targetMotorPos;
    //private MotorState                      motorState;
    private int                             loops;
    private boolean                         haveNotRun;

    @Override
    public void init()
    {
        motorControl    = hardwareMap.dcMotorController.get("motorController");
        testMotor       = hardwareMap.dcMotor.get("testMotor");

        testMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        //motorState = MotorState.STOPPED;
        //targetMotorPos = 200;

        loops = 0;
        haveNotRun = true;
    }

    @Override
    public void start()
    {
        motorControl.setMotorControllerDeviceMode(DcMotorController.DeviceMode.WRITE_ONLY);
        testMotor.setPower(0.1);
        testMotor.setTargetPosition(1440);
        //motorControl.setMotorControllerDeviceMode(DcMotorController.DeviceMode.READ_ONLY);
    }

    @Override
    public void loop()
    {
        if (!testMotor.isBusy())
        {

        }
        /*
         *  OLD ALGORITHM
         */

        /*
        if (devMode == DcMotorController.DeviceMode.WRITE_ONLY) // Allowed to write
        {
            switch (motorState)
            {
                case DECREASING:
                    telemetry.addData("Motor State: ", "DECREASING");
                    testMotor.setPower(-0.1);
                    break;
                case INCREASING:
                    telemetry.addData("Motor State: ", "INCREASING");
                    testMotor.setPower(0.1);
                    break;
                case STOPPED:
                    telemetry.addData("Motor State: ", "STOPPED");
                    testMotor.setPower(0);
                    break;
            }
        }

        if (devMode == DcMotorController.DeviceMode.READ_ONLY) // Allowed to read
        {
            int currentPos = testMotor.getCurrentPosition();
            telemetry.addData("Encoder Position: ", currentPos);

            if (currentPos > (targetMotorPos + 3))
            {
                motorState = MotorState.DECREASING;
            }
            else if (currentPos < (targetMotorPos - 3))
            {
                motorState = MotorState.INCREASING;
            }
            else if (currentPos > (targetMotorPos - 3) && currentPos < (targetMotorPos + 3))
            {
                motorState = MotorState.STOPPED;
            }
            else
            {
                // throw exception
            }

            motorControl.setMotorControllerDeviceMode(DcMotorController.DeviceMode.WRITE_ONLY);
        }

        if (loops % 10 == 0 && devMode == DcMotorController.DeviceMode.WRITE_ONLY)
        {
            motorControl.setMotorControllerDeviceMode(DcMotorController.DeviceMode.READ_ONLY);
        }

        switch (devMode)
        {
            case WRITE_ONLY:
                telemetry.addData("Device Mode", "WRITE_ONLY");
                break;
            case READ_ONLY:
                telemetry.addData("Device Mode", "READ_ONLY");
                break;
            case SWITCHING_TO_READ_MODE:
                telemetry.addData("Device Mode", "SWITCHING_TO_READ_MODE");
                break;
            case SWITCHING_TO_WRITE_MODE:
                telemetry.addData("Device Mode", "SWITCHING_TO_WRITE_MODE");
                break;
        }
        devMode = motorControl.getMotorControllerDeviceMode();
        loops++;
        */
    }
}