package _01_Olympic_Rings;

import java.awt.Color;
import java.awt.Graphics;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	
	public static void main(String[] args) {
		Robot blue = new Robot(300, 200);
		Robot yellow = new Robot(450, 400);
		Robot black = new Robot(600, 200);
		Robot green = new Robot(750, 400);
		Robot red = new Robot(900, 200);
		
		blue.setSpeed(10);
		yellow.setSpeed(10);
		black.setSpeed(10);
		green.setSpeed(10);
		red.setSpeed(10);
		
		blue.penDown();
		yellow.penDown();
		black.penDown();
		green.penDown();
		red.penDown();
		
		blue.setPenColor(Color.BLUE);
		yellow.setPenColor(Color.YELLOW);
		black.setPenColor(Color.BLACK);
		green.setPenColor(Color.GREEN);
		red.setPenColor(Color.RED);
		
		for (int i = 0; i < 360; i += 5) {
			Thread r1 = new Thread(()->blue.move(10));
			Thread r2 = new Thread(()->blue.turn(5));
			r1.start();
			r2.start();
			Thread r3 = new Thread(()->yellow.move(10));
			Thread r4 = new Thread(()->yellow.turn(5));
			r3.start();
			r4.start();
			Thread r5 = new Thread(()->blue.move(10));
			Thread r6 = new Thread(()->blue.turn(5));
			r5.start();
			r6.start();
			Thread r7 = new Thread(()->black.move(10));
			Thread r8 = new Thread(()->black.turn(5));
			r7.start();
			r8.start();
			Thread r9 = new Thread(()->green.move(10));
			Thread r0 = new Thread(()->green.turn(5));
			r9.start();
			r0.start();
			Thread r11 = new Thread(()->red.move(10));
			Thread r12 = new Thread(()->red.turn(5));
			r11.start();
			r12.start();
			
		}
		
	}
	
}

