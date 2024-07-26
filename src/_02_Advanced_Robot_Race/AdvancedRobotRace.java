package _02_Advanced_Robot_Race;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.
	volatile static int winner = -1;
	static volatile boolean raceOngoing = true;

	public static void main(String[] args) {
		Robot finish = new Robot(1550, 0);
		finish.setSpeed(1000);
		finish.turn(180);
		finish.penDown();
		finish.move(1000);
		finish.hide();
		int y = 50;
		int[] x = { 100, 100, 100, 100, 100 };
		Robot[] robs = new Robot[5];
		Thread[] race = new Thread[5];
		Random rand = new Random();
		for (int i = 0; i < robs.length; i++) {
			robs[i] = new Robot(x[i], y);
			robs[i].turn(90);
			robs[i].setSpeed(1000);
			y += 200;
		}

		for (int i = 0; i < race.length; i++) {
			final int counter = i;
			race[i] = new Thread(() -> {
				while (winner == -1) {
					int distance = 1501 - robs[counter].getX();
					if (distance <= 75) {
						robs[counter].move(rand.nextInt(distance));
						robs[counter].setSpeed(1);
					} else {
						robs[counter].move(rand.nextInt(75));
					}
					if (robs[counter].getX() >= 1500 && winner == -1) {
						// raceOngoing = false;
						winner = counter;
						robs[counter].sparkle();
						robs[counter].turn(360);
						JOptionPane.showMessageDialog(null, "Robot " + (winner + 1) + " has won the race");
					}

				}

			});
		}
		for (Thread thread : race) {
			thread.start();
		}
	}
}
