package logic;

import logic.*;
import java.lang.*;

public class GenerateMessageRunnable implements Runnable{

	private ServerNode server;
	private boolean flag; //nos suministrá información sobre si esta generando mensajes
	private Message message;

	public GenerateMessageRunnable(ServerNode server){
		this.server = server;
		this.flag = false;
	}

	public void setFlag(boolean flag){
		this.flag = flag;
	}

	public boolean getFlag(){
		return this.flag;
	}

	@Override
	public void run(){
	while(true){
		while(this.flag){
			try{
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			this.message = new Message();
			if(this.server.addMessage(this.message)){
				System.out.println("Mensaje agregado a la cola desde el generador");
			} else {
				System.out.println("Error al agregar a la cola desde el generador");
			}
		}
	}
	}
}
