package logic;

import logic.*;
import java.lang.*;

public class ConnectClientRunnable implements Runnable{

	private ClientNode client;
	private int portConnect;
	private String hostConnect;
	private boolean flagConnection; //estadodeconexionhacia el server
	private boolean flag;

	public ConnectClientRunnable(String hostConnect, int portConnect){
		this.hostConnect = hostConnect;
		this.portConnect = portConnect;
		this.flagConnection = false;
		this.flag = true;
	}

	public void setFlag(boolean flag){
		this.flag = flag;
	}

	@Override
	public void run(){
	while(!flagConnection){
		try{
		this.client = new ClientNode(this.hostConnect, this.portConnect);
		this.flagConnection = true;
		} catch (Exception e){
			System.out.println(e.getMessage());
			this.flagConnection = false;
		}
	}
	while(flag){
		Message message = new Message("Hola Álvaro","espero estés bien");
		this.client.sendMessage(message);
	}
	this.client.close();
	}
}
