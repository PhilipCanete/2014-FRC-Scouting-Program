package org.iamacomb;

import java.io.*;
import java.net.Socket;

public class SocketClientHandler implements Runnable{
	private Socket client;
	
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
		
	}
}
