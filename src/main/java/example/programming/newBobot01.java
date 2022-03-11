package example.programming;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.ev3.EV3UltrasonicSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class newBobot01 {
     public static void main(String[] args) {
       EV3LargeRegulatedMotor motorPravy = new EV3LargeRegulatedMotor(MotorPort.B);
       EV3LargeRegulatedMotor motorVlevo = new EV3LargeRegulatedMotor(MotorPort.C);

motorPravy.forward();

        motorVlevo.forward();

         Delay.msDelay(0);
         motorPravy.stop();
         motorVlevo.stop();

double prumer = 5.5;
double delka = 100;
double obvod = prumer * Math.PI;
double vysledek = delka/obvod;
double vysledek1 = vysledek * 360;

         System.out.println("Defining motor speed");
         final int motorSpeed = 200;
         motorVlevo.setSpeed(motorSpeed);
         motorPravy.setSpeed(motorSpeed);

         System.out.println("Go Forward with the motors");
         motorVlevo.forward();
         motorPravy.forward();

         Delay.msDelay(2000);


         metodaotoceni(motorPravy, motorVlevo, 190, true, -190, false);

         System.out.println("Defining motor speed");

         motorVlevo.setSpeed(motorSpeed);
         motorPravy.setSpeed(motorSpeed);

         System.out.println("Go Forward with the motors");
         motorVlevo.forward();
         motorPravy.forward();

         Delay.msDelay(2000);


         metodaotoceni(motorPravy, motorVlevo, 190, true, -190, false);
         System.out.println("Defining motor speed");

         motorVlevo.setSpeed(motorSpeed);
         motorPravy.setSpeed(motorSpeed);

         System.out.println("Go Forward with the motors");
         motorVlevo.forward();
         motorPravy.forward();

         Delay.msDelay(2000);

         metodaotoceni(motorPravy, motorVlevo, 190, true, -190, false);

         System.out.println("Defining motor speed");

         motorVlevo.setSpeed(motorSpeed);
         motorPravy.setSpeed(motorSpeed);

         System.out.println("Go Forward with the motors");
         motorVlevo.forward();
         motorPravy.forward();

         Delay.msDelay(2000);


         metodaotoceni(motorPravy, motorVlevo, 190, true, -190, false);

         EV3UltrasonicSensor sensor = new EV3UltrasonicSensor(SensorPort.S1);
         float[]pole = new float[sensor.sampleSize()];

         for ( int i = 0; i < 2;i++)
         {
             sensor.fetchSample (pole,0);

             System.out.println("vzdálenost" + pole[0]);
             Delay.msDelay (500);


         }


     }



    private static void metodaotoceni(EV3LargeRegulatedMotor motorPravy, EV3LargeRegulatedMotor motorVlevo, int i, boolean b, int i2, boolean b2) {
        motorPravy.rotate(i, b);
        motorVlevo.rotate(i2, b2);
    }
}
