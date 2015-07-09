package org.iamacomb;

import java.util.Scanner; //This will be the temporary input method in the release, AWT and Swing will be used later for a GUI

public class Client {
	public static void main(String[] args){
		Client c = new Client();
		String a = c.receive_input("How many boxes did they stack?");
		System.out.println("Team 200 stacked " + a + " boxes");
	}
	
	public String receive_input(String prompt){
		String input;
		Scanner input_ = new Scanner(System.in);
		
		System.out.print(prompt);
		input = input_.next();
		
		
		return input;
	}
}
