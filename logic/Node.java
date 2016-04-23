//Clase que representa a cada nodo de la red.

package logic;

import logic.*;
import java.net.*;
import java.io.*;
import java.lang.*;

public class Node implements Runnable{

	private int portListen;//Puerto por el que el nodo esta destinado a escuchar
	private int portConnect; //Puerto por el que nodo se conectará
	private String hostConnect; //IP a la cual se conectará el nodo
	private Thread listenServerThread;
	private ListenServerRunnable listenServerRunnable;
	private Thread connectClientThread;
	private ConnectClientRunnable connectClientRunnable;
	private Thread generateMessageThread;
	private GenerateMessageRunnable generateMessageRunnable;
	private Thread showInformationThread;
	private ShowInformationRunnable showInformationRunnable;
	private ServerNode server;
	private Thread myThread;
	private boolean flag;
	private boolean isServerData; //true es un servidor de datos false, es un nodo de recibir y replicar

	public Node(int portListen, int portConnect, String hostConnect, boolean isServerData){
		this.portListen = portListen;
		this.portConnect = portConnect;
		this.hostConnect = hostConnect;
		this.isServerData = isServerData;
		this.server = new ServerNode(this.portListen);
		this.listenServer();
		this.connectClient();
		if(this.isServerData){
			this.showInformation();
		}else{
			this.generateMessage();
		}
		this.createMyThread();
	}

	//metodo para hilo de escucha como servidor por parte del nodo
	private void listenServer(){
		this.listenServerRunnable = new ListenServerRunnable(this.server);
		this.listenServerThread = new Thread(this.listenServerRunnable);
		this.listenServerThread.start();
	}

	private void connectClient(){
		this.connectClientRunnable = new ConnectClientRunnable(this.hostConnect, this.portConnect);
		this.connectClientThread = new Thread(this.connectClientRunnable);
		this.connectClientThread.start();
	}

	private void showInformation(){
		this.showInformationRunnable = new ShowInformationRunnable();
		this.showInformationThread = new Thread(this.showInformationRunnable);
		this.showInformationThread.start();
	}

	private void generateMessage(){
		this.generateMessageRunnable = new GenerateMessageRunnable(this.server);
		this.generateMessageThread = new Thread(this.generateMessageRunnable);
		this.generateMessageThread.start();
	}

	public void createMyThread(){
		this.flag = false;
		this.myThread = new Thread(this);
		this.myThread.start();
	}

	public void setFlag(boolean flag){
		this.flag = flag;
	}

	public void runShowInformation(String host){
		this.showInformationRunnable.setFlag(true, host);
	}

	public void runGenerateMessage(){
		this.generateMessageRunnable.setFlag(true);
	}

	public void stopShowInformation(){
		this.showInformationRunnable.setFlag(false);
	}

	public void changeNodeShowInformation(String host){
		this.showInformationRunnable.setHost(host);
	}

	public void stopGenerateMessage(){
		this.generateMessageRunnable.setFlag(false);
	}

	private void sendMessage(Message message){
		this.connectClientRunnable.sendMessage(message);
	}

	public boolean isServerData(){
		return this.isServerData;
	}

	public boolean isListenServer(){
		return this.listenServerRunnable.getFlag();
	}

	public boolean isConnectClient(){
		return this.connectClientRunnable.getFlag();
	}

	@Override
	public void run(){
		while(true){
			while(this.flag){
				if(! this.server.isEmptyArrayDeque()){
					for(int i=0; i<this.server.getSizeArrayDeque(); i++){
						if(this.isServerData){
							//esribir en el archivo de texto
						} else {
							System.out.println("Estoy enviando un mensaje desde el hilo del nodo");
							this.sendMessage(this.server.getMessageArrayDeque());
						}
					}
				}
			}
		}
	}
}
