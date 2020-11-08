package Motors;


import lejos.hardware.motor.*;


public class TreadController {
	private EV3LargeRegulatedMotor leftMotor,rightMotor = null;
	
	public TreadController(EV3LargeRegulatedMotor leftMotor, EV3LargeRegulatedMotor rightMotor) {
		this.leftMotor = leftMotor;
		this.rightMotor = rightMotor;
	}
	
	public void turnLeft() {
		leftMotor.rotate(-90);
		rightMotor.rotate(90);
	}
	
	public void turnRight() {
		leftMotor.rotate(90);
		rightMotor.rotate(-90);
	}
	
	public void goForward() {
		leftMotor.rotate(90);
		rightMotor.rotate(90);
	}
	
	public void goBackwards() {
		leftMotor.rotate(90);
		rightMotor.rotate(90);
	}
	

}w
