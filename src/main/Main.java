package main;
import java.net.*;

import Motors.TreadController;
import Server.Server;

import java.io.*;
import lejos.hardware.*;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class Main {

static EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.A);
static EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreadController myController = new TreadController(leftMotor,rightMotor);
		Server theRobotsServer = new Server(5000, myController);
	}

}
