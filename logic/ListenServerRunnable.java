package logic;

import logic.*;
import java.lang.*;

public class ListenServerRunnable implements Runnable{

	private ServerNode server;
	private boolean flag; //mantendrá al hilo ejecutandose

	public ListenServerRunnable(ServerNode server){
		this.server = server;
		this.flag = true; //abierto a recibir mensajes
	}

	public void setFlag(boolean flag){
		this.flag = flag;
	}

	public boolean getFlag(){
		return this.flag;
	}

	@Override
	public void run(){
	this.server.accept();
	System.out.println("Se ha establecido una conexión con "+this.server.getIpMySock());
	int cont = 0;
	while(flag){
		Message message = this.server.readMessage();
		cont += 1;
		System.out.println("El mensaje "+cont+".1 es: "+message.getMessage1());
		System.out.println("El mensaje "+cont+".2 es: "+message.getMessage2());
		
	}
	this.server.closeInputObject();
	this.server.close();
	}
}
