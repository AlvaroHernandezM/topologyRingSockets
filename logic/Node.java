//Clase que representa a cada nodo de la red.

package logic;

import logic.*;
import java.net.*;
import java.io.*;

public class Node {

	private ServerNode server;
	private ClientNode client;
	private int portListen;//Puerto por el que el nodo esta destinado a escuchar
	private int portConnect; //Puerto por el que nodo se conectará
	private String hostConnect; //IP a la cual se conectará el nodo

	public Node(int portListen, int portConnect, String hostConnect){
		this.portListen = portListen;
		this.portConnect = portConnect;
		this.hostConnect = hostConnect;
	}

	//metodo para hilo de escucha como servidor por parte del nodo
	public boolean listenServer(){
		return false;
	}

}
