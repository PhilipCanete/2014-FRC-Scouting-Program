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
		while((userInput = stdIn.readLine()) != null){
			if(userInput.equals("RECEIVE DATA")){
				/*When client wants to collect scouting data, send it*/
				System.out.println("REQUEST TO RECEIVE DATA RECEIVED. SENDING CURRENT DATA FROM REPOSITORY");
				receiveData();
				break;
			}else if(userInput.equals("SEND_DATA")){
				//acknowledge that the data will be sent on input
				receiveClient();
				break;
			}
			System.out.println(userInput);
		}
	}
	
	private void receiveData() throws IOException, InterruptedException{
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		//get current data and send to client
		writer.write(team_number);
		writer.newLine();
		writer.write(auton_strength);
		writer.newLine();
		writer.write(auton_desc);
		writer.newLine();
		writer.write(coopertition);
		writer.newLine();
		writer.write(number_one_box_stacked);
		writer.newLine();
		writer.write(number_two_box_stacked);
		writer.newLine();
		writer.write(number_three_box_stacked);
		writer.newLine();
		writer.write(number_four_box_stacked);
		writer.newLine();
		writer.write(number_five_box_stacked);
		writer.newLine();
		writer.write(number_six_box_stacked);
		writer.newLine();
		writer.write(is_cap);
		writer.newLine();
		writer.write(max_cap);
		writer.newLine();
		writer.write(total_points);
		writer.newLine();
		writer.flush();
		writer.close();
	}
	
	private void receiveClient() throws IOException, InterruptedException{
		BufferedReader read = new BufferedReader(new InputStreamReader(client.getInputStream()));
		String request = read.readLine();
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

	}
}
