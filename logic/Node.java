//Clase que representa a cada nodo de la red.

package logic;

import logic.*;
import java.net.*;
import java.io.*;
import java.lang.*;

public class Node {

	private ServerNode server;
	private ClientNode client;
	private int portListen;//Puerto por el que el nodo esta destinado a escuchar
	private int portConnect; //Puerto por el que nodo se conectará
	private String hostConnect; //IP a la cual se conectará el nodo
	private Thread listenServerThread;
	private Thread connectClientThread;

	public Node(int portListen, int portConnect, String hostConnect){
		this.portListen = portListen;
		this.portConnect = portConnect;
		this.hostConnect = hostConnect;
	}

	//metodo para hilo de escucha como servidor por parte del nodo
	public void listenServer(){
		this.server = new ServerNode(this.portListen);
		this.listenServerThread = new Thread(new ListenServerRunnable(this.server));
		this.listenServerThread.start();
	}

	public void connectClient(){
		this.connectClientThread = new Thread(new ConnectClientRunnable(this.hostConnect, this.portConnect));
		this.connectClientThread.start();
	}

}
