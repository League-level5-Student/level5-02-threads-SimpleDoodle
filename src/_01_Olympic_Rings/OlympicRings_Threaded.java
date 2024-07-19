package _01_Olympic_Rings;

import java.awt.Color;
import java.util.Iterator;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.

	public static void main(String[] args) {
		Thread[] ring = new Thread[5];
		Thread[] overlap = new Thread[5];
		Color[] penColor = { Color.blue, Color.yellow, Color.black, Color.green, Color.red };
		Robot[] robs = new Robot[5];
		Robot[] overlapRobs = new Robot[5];
		for (int i = 0; i < robs.length; i++) {
			robs[i] = new Robot();
	
		}

		for (int i = 0; i < ring.length; i++) {
			final int counter = i;
			ring[i] = new Thread(() -> {
				int x = 300 + (200 * counter);
				int y = counter % 2 == 0 ? 400 : 500;
				Robot rob = robs[counter];
				rob.setX(x);
				rob.setY(y);
				rob.penDown();
				rob.setPenColor(penColor[counter]);
				rob.setSpeed(100000);
				rob.setAngle(270);
				rob.setPenWidth(10);
				for (int j = 0; j < 360; j++) {
					rob.move(3);
					rob.turn(1);
				}
				rob.hide();
			});

		}
		for (Thread olympics : ring) {
			olympics.start();
		}
		for (Thread olympics : ring) {
			try {
				olympics.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < overlapRobs.length; i++) {
			overlapRobs[i] = new Robot();
		}

		for (int i = 0; i < overlap.length; i++) {
			final int counter = i;
			overlap[i] = new Thread(() -> {
				int x = 300 + (200 * counter);
				int y = counter % 2 == 0 ? 400 : 500;
				Robot bor = overlapRobs[counter];
				bor.setX(x);
				bor.setY(y);
				bor.penDown();
				bor.setPenColor(penColor[counter]);
				bor.setSpeed(100000);
				bor.setAngle(90);
				bor.setPenWidth(8);
				for (int j = 0; j < 90; j++) {
					bor.move(3);
					bor.turn(-1);
				}
				bor.hide();
			});

		}

		for (Thread second : overlap) {
			second.start();
		}
	}
}
