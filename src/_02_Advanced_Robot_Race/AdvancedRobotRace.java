package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	public static void main(String[] args) {
		int x = 100;
		int[] y = {800, 800, 800, 800, 800};
		Robot[] robs = new Robot[5];
		Thread[] race = new Thread[5];
		for (int i = 0; i < robs.length; i++) {
			robs[i] = new Robot(x,y[i]);
			x+=200;
		}
		boolean raceFinished = false;
		Random rand = new Random();
		while(raceFinished = false) {
			for (int i = 0; i < race.length; i++) {
				int d = rand.nextInt(50);
				y[i] += d;
				robs[i].move(d);
				if (y[i] >= 100) {
					raceFinished = true;
				}
			}
		}
		for (Thread thread : race) {
			thread.start();
		}
	}
}
