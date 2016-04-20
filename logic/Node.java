//Clase que representa a cada nodo de la red.

package logic;

import logic.*;
import java.net.*;
import java.io.*;
import java.lang.*;

public class Node {

	private int portListen;//Puerto por el que el nodo esta destinado a escuchar
	private int portConnect; //Puerto por el que nodo se conectará
	private String hostConnect; //IP a la cual se conectará el nodo
	private Thread listenServerThread;
	private ListenServerRunnable listenServerRunnable;
	private Thread connectClientThread;
	private ConnectClientRunnable connectClientRunnable;
	private ServerNode server;

	public Node(int portListen, int portConnect, String hostConnect){
		this.portListen = portListen;
		this.portConnect = portConnect;
		this.hostConnect = hostConnect;
		this.server = new ServerNode(this.portListen);
		this.listenServer();
		this.connectClient();
	}

	//metodo para hilo de escucha como servidor por parte del nodo
	public void listenServer(){
		this.listenServerRunnable = new ListenServerRunnable(this.server);
		this.listenServerThread = new Thread(this.listenServerRunnable);
		this.listenServerThread.start();
	}

	public void connectClient(){
		this.connectClientRunnable = new ConnectClientRunnable(this.hostConnect, this.portConnect);
		this.connectClientThread = new Thread(this.connectClientRunnable);
		this.connectClientThread.start();
	}

	public boolean isListenServer(){
		return this.listenServerRunnable.getFlag();
	}

	public boolean isConectClient(){
		return this.connectClientRunnable.getFlag();
	}

}
