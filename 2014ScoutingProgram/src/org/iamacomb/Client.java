package org.iamacomb;

import java.util.Scanner; //This will be the temporary input method in the release, AWT and Swing will be used later for a GUI

public class Client {
	public static void main(String[] args){
		Client c = new Client();
		String team_number = c.receive_input("Enter team number: ", true); //could be unique-assigned ID like in mysql (int makes it easier)
		String auton_strength = c.receive_input("Rate their autonomous from 1-10: ", true); //could be int and more specific
		String auton_desc = c.receive_input("Describe their autonomous period.", true); //string only, java textbox
		String coopertition = c.receive_input("Coopertition stack? ", true); //could be bool
		String number_one_box_stacked = c.receive_input("How many one stacks did they stack? ", true); //could be an int
		String number_two_box_stacked = c.receive_input("How many two stacks did they stack? ", true); // could be an int
		String number_three_box_stacked = c.receive_input("How many three stacks did they stack? ", true); //could be an int
		String number_four_box_stacked = c.receive_input("How many four stacks did they stack? ", true); // could be an int
		String number_five_box_stacked = c.receive_input("How many five stacks did they stack? ", true); //could be an int
		String number_six_box_stacked = c.receive_input("How many six stacks did they stack? ", true); // could be an int
		String is_cap = c.receive_input("Can they cap? ", true); // could be a bool
		String max_cap = c.receive_input("How high of a stack can they cap? (1-6) ", true); //could be an int
		String total_points = c.receive_input("How many total points did they contribute to the team? ", true); // TODO: Will be automated, just input only for now
		String stopper = c.receive_input("", false);
		
		System.out.println("Here are the stats that you inputted");
		System.out.println("Team Number: " + team_number);
		System.out.println("Autonomus Strength: " + auton_strength);
		System.out.println("Autonomous Description: " + auton_desc);
		System.out.println("Coopertition Stack Made: " + coopertition);
		System.out.println("Number of One Stacks: " + number_one_box_stacked);
		System.out.println("Number of Two Stacks: " + number_two_box_stacked);
		System.out.println("Number of Three Stacks: " + number_three_box_stacked);
		System.out.println("Number of Four Stacks: " + number_four_box_stacked);
		System.out.println("Number of Five Stacks: " + number_five_box_stacked);
		System.out.println("Number of Six Stacks: " + number_six_box_stacked);
		System.out.println("Capping Capabilities: " + is_cap);
		System.out.println("Capping Ability: " + max_cap);
		System.out.println("Total Points Contributed to the Team: " + total_points);
		
		
	}
	
	public String receive_input(String prompt, boolean run){
		String input;
		Scanner input_ = new Scanner(System.in);
		if(run){
			System.out.print(prompt);
			input = input_.next();
		}else{
			input_.close();
			input = null;
		}
		
		return input;
	}
}
