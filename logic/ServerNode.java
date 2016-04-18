//Clase que controla la conexión del servidor de cada nodo

package logic;

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

	public ServerNode(int port){
		this.port = port;
		this.ipAddress = null;
		this.ipMySock = null;
		this.create();
	}

	private void create(){
		try {
			this.serverSocket = new ServerSocket(this.port);
			System.out.println("Creado satisfactoriamente el servidor en el puerto: "+this.serverSocket.getLocalPort());
			System.out.println(this.serverSocket.getInetAddress());
			System.out.println(this.serverSocket.isClosed());
//			this.serverSocket.close();
//			System.out.println(this.serverSocket.isClosed());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void accept(){
		try{
		System.out.println(this.serverSocket.isClosed());
		if(! this.serverSocket.isClosed()){
		this.mySock = this.serverSocket.accept();
		}
		System.out.println("Conexión exitosa");
		} catch (IOException e){
			System.out.println("aqui es:"+e.getMessage());
		}
	}

	public void close(){
		try{
		this.serverSocket.close();
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

	public InputStream getInputStream(){
		try{
		return this.mySock.getInputStream();
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	public OutputStream getOutputStream(){
		try {
		return this.mySock.getOutputStream();
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
		return null;
	}
}
