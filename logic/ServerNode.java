//Clase que controla la conexión del servidor de cada nodo

package logic;

import logic.*;
import java.net.*;
import java.io.*;
//import java.net.InetAddress.*;
//import java.net.ServerSocket.*;
//import java.net.Socket.*;
public class ServerNode {

	private int port;
	private InetAddress ipAddress; //Ip del servidor socket
	private InetAddress ipMySock; //Ip del socket que acepta una petición (deberia ser del cliente)
	private ServerSocket serverSocket;
	private Socket mySock;
	private ObjectInputStream inputObject;
	private Message message;

	public ServerNode(int port){
		this.port = port;
		this.ipAddress = null;
		this.ipMySock = null;
		this.serverSocket = null;
		this.mySock = null;
		this.create();
	}

	private void create(){
		try {
			this.serverSocket = new ServerSocket(this.port);
//			this.outputData = this.mySock.getOutputStream();
			System.out.println("Creado satisfactoriamente el servidor en el puerto: "+this.serverSocket.getLocalPort());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void accept(){
		try{
		this.mySock = this.serverSocket.accept();
		this.inputObject = new ObjectInputStream(this.mySock.getInputStream());
		System.out.println("Conexión exitosa");
		} catch (IOException e){
			System.out.println("aqui es:"+e.getMessage());
		}
	}

	public Message readMessage(){
		try{
		this.message = (Message) this.inputObject.readObject();
		this.inputObject.close(); //Cerrando la lectura
		return message;
		} catch (Exception e) {
		System.out.println(e.getMessage());
		}
		return null;
	}

	public void close(){
		try{
		this.mySock.close();
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

	public int getPort(){
		this.port = this.serverSocket.getLocalPort();
		return this.port;
	}

	public InetAddress getIpAddress(){
		this.ipAddress = this.serverSocket.getInetAddress();
		return this.ipAddress;
	}

	public InetAddress getIpMySock(){
		this.ipMySock = this.mySock.getInetAddress();
		return this.ipMySock;
	}
}
