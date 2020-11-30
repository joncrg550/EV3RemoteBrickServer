package main;


import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import motors.ClawController;
import motors.TreadController;
import server.Server;

public class Main {

static EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.A);
static EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.B);
static EV3MediumRegulatedMotor clawMotor = new EV3MediumRegulatedMotor(MotorPort.C);
static EV3UltrasonicSensor sensor = new EV3UltrasonicSensor(SensorPort.S4);
	
	public static void main(String[] args) {
		ClawController myClaw = new ClawController(clawMotor);
		TreadController myController = new TreadController(leftMotor,rightMotor, sensor);
		Server theRobotsServer = new Server(5000, myController,myClaw);
	}

}
