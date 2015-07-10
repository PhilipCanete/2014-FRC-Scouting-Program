package org.iamacomb;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

public class Server {
	private int port; //manually input by code, customization later feature
	private int team_number;
	private ServerSocket serverSocket;
	
	public Server(int port, int team_number){
		this.port = port;
		this.team_number = team_number;
	}
	
	public Server(int port){
		this.port = port;
		this.team_number = 0; //default team number
	}
	
	public void start() throws IOException{
		System.out.println("Starting up the 2015 Recycle Rush recycling scouting server on port:  " + port + " for team number: " + team_number);
		serverSocket = new ServerSocket(port);
		
		Socket client = null;
		
		while(true){
			System.out.println("Waiting for clients...");
			client = serverSocket.accept();
			System.out.println("The following client has connected: "+client.getInetAddress().getCanonicalHostName());
			
			Thread thread = new Thread(new SocketClientHandler(client));
			thread.start();
		}
	}
	
	public static void main(String[] args){
		int portNumber = 4810; //static, will add feature for custom port numbers as well
		int teamNumber = 4810;
		
		try{
			//initialzing socket server
			Server socketServer = new Server(portNumber, teamNumber);
			socketServer.start();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
