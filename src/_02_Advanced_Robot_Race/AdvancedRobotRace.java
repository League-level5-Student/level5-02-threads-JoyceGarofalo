package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	public static void main(String[] args) {
		Robot[] robot = new Robot[5];
		Random rand = new Random();
		boolean isRacing = true;
		for (int i = 0; i < robot.length; i++) {
			robot[i] = new Robot();
			robot[i].setX(200*i + 50);
			robot[i].setY(550);
			robot[i].setSpeed(30);
		}
		
		while (isRacing == true) {
			int r = rand.nextInt(50);
			Thread r1 = new Thread(()->robot[1].move(r));
			Thread r2 = new Thread(()->robot[2].move(r));
			Thread r3 = new Thread(()->robot[3].move(r));
			Thread r4 = new Thread(()->robot[4].move(r));
			Thread r0 = new Thread(()->robot[0].move(r));
			
			r1.start();
			r2.start();
			r3.start();
			r4.start();
			r0.start();

			for (int i = 0; i < robot.length-1; i++) {
				if(robot[i].getY() < 0) {
					isRacing = false;
					System.out.println("winner!");
					break;
				}
			}


			
		}
	}
}
