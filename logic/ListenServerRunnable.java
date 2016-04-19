package logic;

import logic.*;
import java.lang.*;

public class ListenServerRunnable implements Runnable{

	private ServerNode server;
	private boolean flag; //mantendrá al hilo ejecutandose

	public ListenServerRunnable(ServerNode server){
		this.server = server;
		this.flag = true;
	}

	public void setFlag(boolean flag){
		this.flag = flag;
	}

	@Override
	public void run(){
	System.out.println("Escuchando");
	this.server.accept();
	while(flag){
		System.out.println("Se ha establecido una conexión con "+this.server.getIpMySock());
		Message message = this.server.readMessage();
		System.out.println("El mensaje uno es: "+message.getMessage1());
		System.out.println("El mensaje dos es: "+message.getMessage2());
	}
	this.server.close();
	}
}
