package example.programming;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.ev3.EV3UltrasonicSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

public class robot2 {
    public static void main(String[] args) {
        EV3UltrasonicSensor sensor = new EV3UltrasonicSensor(SensorPort.S4);
        EV3LargeRegulatedMotor motorPravy = new EV3LargeRegulatedMotor(MotorPort.C);
        EV3LargeRegulatedMotor motorVlevo = new EV3LargeRegulatedMotor(MotorPort.B);

        motorPravy.forward();
        motorVlevo.forward();

        Delay.msDelay(2000);

        System.out.println("Defining motor speed");
        final int motorSpeed = 200;
        motorVlevo.setSpeed(motorSpeed);
        motorPravy.setSpeed(motorSpeed);


        float[] pole = new float[sensor.sampleSize()];

        for (int i = 0; i < 3; i++) {
            sensor.fetchSample(pole, 0);
            motorPravy.forward();
            motorVlevo.forward();

            Delay.msDelay(2000);

            System.out.println("Defining motor speed");

            motorVlevo.setSpeed(motorSpeed);
            motorPravy.setSpeed(motorSpeed);
            System.out.println("vzdálenost" + pole[0]);
            Delay.msDelay(500);
            motorPravy.stop();
            motorVlevo.stop();

            metodaotoceni(motorPravy, motorVlevo, 365, true, -365, false);
            motorPravy.forward();
            motorVlevo.forward();

            Delay.msDelay(2000);

            System.out.println("Defining motor speed");

            motorVlevo.setSpeed(motorSpeed);
            motorPravy.setSpeed(motorSpeed);
        }
        motorPravy.stop();
        motorVlevo.stop();
    }

    private static void metodaotoceni(EV3LargeRegulatedMotor motorPravy, EV3LargeRegulatedMotor motorVlevo, int i, boolean b, int i2, boolean b2) {
        motorPravy.rotate(i, b);
        motorVlevo.rotate(i2, b2);
    }

}



