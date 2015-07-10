package org.iamacomb;

import java.util.Scanner; //This will be the temporary input method in the release, AWT and Swing will be used later for a GUI
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private String hostname;
	private int port;
	private int team_number;
	Socket socketClient;
	
	public Client(String hostname, int port, int team_number){
		this.hostname = hostname;
		this.port = port;
		this.team_number = team_number;
	}
	
	public Client(String hostname, int port){
		this.hostname = hostname;
		this.port = port;
		team_number = 0; // default team number
	}
	
	public Client(){}
	
	
	public void connect() throws UnknownHostException, IOException{
		System.out.println("Attempting to connect to " + hostname + ":" + port + " for team number " + team_number);
		socketClient = new Socket(hostname, port);
		System.out.println("Connection established!");
	}
	
	public void readResponse() throws IOException{
		String userInput;
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
		System.out.println("RESPONSE FROM SERVER: ");
		while((userInput = stdIn.readLine()) != null){
			System.out.println(userInput);
		}
	}
	
	public void send_data() throws IOException{
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
		writer.write("SEND_DATA" + '\n');
		//writer.newLine();
		writer.write(receive_input("Enter team number: ", true) + '\n');
		//writer.newLine();
		writer.write(receive_input("Rate their autonomous from 1-10: ", true)+ '\n');
		//writer.newLine();
		writer.write(receive_input("Describe their autonomous period.", true)+ '\n');
		//writer.newLine();
		writer.write(receive_input("Coopertition stack? ", true)+ '\n');
		//writer.newLine();
		writer.write(receive_input("How many one stacks did they stack? ", true)+ '\n');
		//writer.newLine();
		writer.write(receive_input("How many two stacks did they stack? ", true)+ '\n');
		//writer.newLine();
		writer.write(receive_input("How many three stacks did they stack? ", true)+ '\n');
		//writer.newLine();
		writer.write(receive_input("How many four stacks did they stack? ", true)+ '\n');
		//writer.newLine();
		writer.write(receive_input("How many five stacks did they stack? ", true)+ '\n');
		//writer.newLine();
		writer.write(receive_input("How many six stacks did they stack? ", true)+ '\n');
		//writer.newLine();
		writer.write(receive_input("Can they cap? ", true)+ '\n');
		//writer.newLine();
		writer.write(receive_input("How high of a stack can they cap? (1-6) ", true)+ '\n');
		//writer.newLine();
		writer.write(receive_input("How many total points did they contribute to the team? ", true)+ '\n');
		
		writer.flush();
		writer.close();
	}
	
	public static void main(String[] args){
		Client c = new Client("localhost", 4810, 4810);
		
		try{
			c.connect();
			Scanner something = new Scanner(System.in);
			System.out.println("Send data? Or Retreive data from server? (s for send / r for receive)");
			String response = "";
			while(response != "r" || response != "s"){
				response = something.next();
				
				
				System.out.println("You entered " + response);	
		
			
			}
			System.out.println("Out of loop");
		
			if(response == "r"){
				c.readResponse();
			}else if(response == "s"){
				c.send_data();
			}	
			
			something.close();
			
		
		}catch(UnknownHostException e){
			System.err.println("Host unknown. Cannot establish connection");
		}catch(IOException e){
			System.err.println("Cannot establish connection. Server may not be up. " + e.getMessage());
		}
		
		
		/*
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
		*/
		
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
