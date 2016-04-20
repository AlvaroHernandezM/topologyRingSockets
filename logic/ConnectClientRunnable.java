package logic;

import logic.*;
import java.io.*;
import java.lang.*;

public class ConnectClientRunnable implements Runnable{

	private ClientNode client;
	private int portConnect;
	private String hostConnect;
	private boolean flag;
	private boolean sendMessage;
	private boolean reply;
	private Message message;

	public ConnectClientRunnable(String hostConnect, int portConnect){
		this.hostConnect = hostConnect;
		this.portConnect = portConnect;
		this.flag = false;
		this.sendMessage = false;
		this.reply = false;
	}

	private void sendMessage(Message message){
		this.message = message;
		this.sendMessage = true;
	}

	public void sendReply(Message message){
		this.message = message;
		this.reply = true;
	}

	public void setReply(boolean reply){
		this.reply = reply;
	}

	public void setFlag(boolean flag){
		this.flag = flag;
	}

	public void setSendMessage(boolean sendMessage){
		this.sendMessage = sendMessage;
	}
	public boolean getFlag(){
		return this.flag;
	}

	@Override
	public void run(){
	this.client = new ClientNode(this.hostConnect, this.portConnect);
	this.flag = true;
	while(flag){
		if(this.sendMessage){
			//try{
//				Thread.sleep(7000);
//			} catch (InterruptedException e){
//				System.out.println(e.getMessage());
//			}
			this.client.sendMessage(this.message);
			this.sendMessage=false;
		}
		if(this.reply){
//			try{
//				Thread.sleep(7000);
//			} catch (InterruptedException e){
//				System.out.println(e.getMessage());
//			}
			this.client.sendMessage(this.message);
			this.reply=false;
		}
	}
	this.client.closeOutputObject();
	this.client.close();
	}
}
