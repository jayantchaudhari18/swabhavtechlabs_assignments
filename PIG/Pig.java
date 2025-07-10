package com.aurionpro.basics.controlstructures;

import java.util.Scanner;

public class Pig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		playGame(scanner);
		System.out.println("Game Over");

	}

	public static void playGame(Scanner scanner) {
		int number_of_turns = 5;
		int count = 0;
		int i = 1;
		while (i <= number_of_turns) {
			System.out.println("TURN " + i);
			System.out.println("Roll or Hold?(r/h)");
			String decision = scanner.next();
			if (decision.equalsIgnoreCase("h")) {
				i++;
				continue;
			}

			if (decision.equalsIgnoreCase("r")) {
				int random_number = rollDie();
				if (random_number == 1) {
					System.out.println("TURN OVER .NO SCORE");
					count = 0;
					i++;
					return;
				}

				count = count + random_number;
				if (count > 20) {
					System.out.println("YOU FINISHED IN " + i + " TURNS ");
					return;
				}
//			    calculateScore(random_number,count,i);
			}
		}
	}

	public static int rollDie() {
		int random_number = (int) (Math.random() * 6) + 1;
		System.out.println("DIE: " + random_number);
		return random_number;

	}
	
	public static void calculateScore(int random_number,int count,int i) {
		
		if (random_number == 1) {
			System.out.println("TURN OVER .NO SCORE");
			count = 0;
			i++;
			return;
		}

		count = count + random_number;
		if (count > 20) {
			System.out.println("YOU FINISHED IN " + i + " TURNS ");
			return;
		}
		
	}

}
