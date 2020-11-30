package motors;




import java.util.ArrayList;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;


public class TreadController {
	private  EV3LargeRegulatedMotor leftMotor,rightMotor = null;
	private  Wheel leftTread =  null;
	Wheel rightTread = null; 
	private  Chassis chassis = null; 
	private  MovePilot pilot = null;
	private EV3UltrasonicSensor sensor;
	private SampleProvider provider;
	private final float MIN_DISTANCE = (float) 0.4;
	
	
	
	
	
	
	public TreadController(EV3LargeRegulatedMotor leftMotor, EV3LargeRegulatedMotor rightMotor , EV3UltrasonicSensor sensor) {
		this.leftMotor = leftMotor;
		this.rightMotor = rightMotor;
		leftTread = WheeledChassis.modelWheel(leftMotor, 3.17).offset(-7.62);
		rightTread = WheeledChassis.modelWheel(rightMotor, 3.17).offset(7.62);
		chassis = new WheeledChassis(new Wheel[] { leftTread, rightTread }, WheeledChassis.TYPE_DIFFERENTIAL);
		pilot = new MovePilot(chassis);
		sensor.enable();
		provider = sensor.getDistanceMode();
		
		
	}
	
	public void turnLeft() {
		
		pilot.rotate(-10);
		
	}
	
	public void turnRight() {
		pilot.rotate(10);
	
	}
	
	public void goForward() {
		if(getDistance() > MIN_DISTANCE)
		pilot.travel(10);
	
	}
	
	public void goBackwards() {
		pilot.travel(-10);
	
	}
	
	public float getDistance() {
		float[] sample = new float [provider.sampleSize()];
		provider.fetchSample(sample, 0);
		return sample[0];
	}

	

}
