package Homework2;

import java.util.Random;
import java.util.Scanner;

public class SeatReservation {
	static char[][] seat;
	static int availSeat = 0;//available seats
	
	public void menu(){ 

		Scanner input = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("===========================================");
			System.out.println("Enter number to choose the function: ");
			System.out.println("1. Show the map");
			System.out.println("2. Find all available seat ");
			System.out.println("3. Make a reserve");
			System.out.println("4. Exit");
			System.out.println("===========================================");
			System.out.print("Choice: ");			
			
			int choice = input.nextInt();
			
			if (choice == 1) {
				show();
			}
			else if (choice == 2) {
				find();
			}
			else if (choice == 3) {
				reserve();
			}
			else if (choice == 4) {
				System.out.println("Program Exited.");
				break;
			}
		}
		input.close();		
	}

	public void show() {
		
		System.out.println("List of seats:");
		System.out.println("      1   2   3   4   5   6");
		System.out.println("------------------------------");
		
		for(int i=0;i<6;i++) {
			System.out.print("   "+ (i + 1) + "| ");
			for(int j=0;j<6;j++) {
				System.out.print(seat[i][j]+"   ");
			}
			System.out.print("\n");
		}
		System.out.println("Number of available seats : "+ availSeat + "\n");
	}

	public void find() {
		
		System.out.println("Available seats :");
		
		for(int i=0;i<6;i++) {
			for(int j=0;j<6;j++) {
				if(seat[i][j]=='-') {
					System.out.print("("+(i+1)+","+(j+1)+") ");
				}
			}
		}
		System.out.println("\n");
	}
	
	public void reserve() {
		
		int r,c;
		
		System.out.print("Input seat row: ");
		Scanner input2 = new Scanner(System.in);
		r = input2.nextInt();
		
		System.out.print("Input seat column: ");
		c = input2.nextInt();
		
		if(seat[r-1][c-1]=='-') {
			System.out.println("Booked successfully.\n");
			availSeat--;
			seat[r-1][c-1] = '*';
		}
		else {
			System.out.println("The seat is not available.\n");
		}
	}
	
	public static void main(String[] args) {

		SeatReservation seatReservation = new SeatReservation();
		
		seat = new char[6][6];
		Random randomNumber = new Random();

		for(int i=0;i<6;i++) {
			for(int j=0;j<6;j++) {
				int r;
				r = randomNumber.nextInt(2);
				if(r<0.5) {
					seat[i][j] = '-';
					availSeat++;
				}
				else
					seat[i][j] = '+';
			}
		}
		seatReservation.menu();

	}

}
