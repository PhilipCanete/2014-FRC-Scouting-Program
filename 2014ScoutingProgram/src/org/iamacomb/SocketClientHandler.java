package org.iamacomb;

import java.io.*;
import java.net.Socket;

public class SocketClientHandler implements Runnable{
	private Socket client;
	
	private String team_number;
	private String auton_strength;
	private String auton_desc;
	private String coopertition;
	private String number_one_box_stacked;
	private String number_two_box_stacked;
	private String number_three_box_stacked;
	private String number_four_box_stacked;
	private String number_five_box_stacked;
	private String number_six_box_stacked;
	private String is_cap;
	private String max_cap;
	private String total_points;
	
	public SocketClientHandler(Socket client){
		this.client = client;
	}
	
	@Override
	public void run(){
		try{
			System.out.println("Thread started with name: " + Thread.currentThread().getName());
			readResponse();
		}catch(IOException e){
			e.printStackTrace();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	private void readResponse() throws IOException, InterruptedException{
		String userInput;
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		userInput = stdIn.readLine();
		System.out.println(userInput);

		while(userInput != null){
			if(userInput.startsWith("RECEIVE DATA")){
				/*When client wants to collect scouting data, send it*/
				System.out.println("REQUEST TO RECEIVE DATA RECEIVED. SENDING CURRENT DATA FROM REPOSITORY");
				receiveData();
				break;
			}else if(userInput.startsWith("SEND_DATA")){
				//acknowledge that the data will be sent on input
				receiveClient(stdIn);
				break;
			}
			//System.out.println(userInput);
		}
	}
	
	private void receiveData() throws IOException, InterruptedException{
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		//get current data and send to client
		writer.write(team_number);
		//writer.newLine();
		writer.write(auton_strength);
		//writer.newLine();
		writer.write(auton_desc);
		//writer.newLine();
		writer.write(coopertition);
		//writer.newLine();
		writer.write(number_one_box_stacked);
		//writer.newLine();
		writer.write(number_two_box_stacked);
		//writer.newLine();
		writer.write(number_three_box_stacked);
		//writer.newLine();
		writer.write(number_four_box_stacked);
		//writer.newLine();
		writer.write(number_five_box_stacked);
		//writer.newLine();
		writer.write(number_six_box_stacked);
		//writer.newLine();
		writer.write(is_cap);
		//writer.newLine();
		writer.write(max_cap);
		//writer.newLine();
		writer.write(total_points);
		//writer.newLine();
		writer.flush();
		writer.close();
	}
	
	private void receiveClient(BufferedReader read) throws IOException, InterruptedException{
		System.out.println("We made it boys");
		
		boolean test = read.ready();
		System.out.println(test);
		
		team_number = read.readLine();
		auton_strength = read.readLine();
		auton_desc = read.readLine();
		coopertition = read.readLine();
		number_one_box_stacked = read.readLine();
		number_two_box_stacked = read.readLine();
		number_three_box_stacked = read.readLine();
		number_four_box_stacked = read.readLine();
		number_five_box_stacked = read.readLine();
		number_six_box_stacked = read.readLine();
		is_cap = read.readLine();
		max_cap = read.readLine();
		total_points = read.readLine();
		
		read.close();
	
		//printDataDirectFromServer();
		
	}
	
	/*
	private void printDataDirectFromServer(){
		System.out.println("We're still here");
		System.out.println(team_number);
		System.out.println(auton_strength);
		System.out.println(auton_desc);
		System.out.println(coopertition);
		System.out.println(number_one_box_stacked);
		System.out.println(number_two_box_stacked);
		System.out.println(number_three_box_stacked);
		System.out.println(number_four_box_stacked);
		System.out.println(number_five_box_stacked);
		System.out.println(number_six_box_stacked);
		System.out.println(is_cap);
		System.out.println(max_cap);
		System.out.println(total_points);
	}
	*/
}
