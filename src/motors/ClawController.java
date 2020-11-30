package motors;
import lejos.hardware.motor.*;

public class ClawController {
 private EV3MediumRegulatedMotor claw;
 
 public ClawController(EV3MediumRegulatedMotor myclaw) {
	 this.claw = myclaw;
 }
 
 public void open() {
	 claw.rotate(90);
 }
 
 public void close() {
	 claw.rotate(-90);
 }
 
}
