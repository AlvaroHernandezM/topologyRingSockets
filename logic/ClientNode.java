//Clase que controla el cliente de cada nodo

package logic;

import java.net.*;
import java.io.*;
//import java.net.InetAddress.*;
//import java.net.ServerSocket.*;
//import java.net.Socket.*;
public class ClientNode {

	private int port;
	private String host;
	private Socket clientSocket;
	private InetAddress ipClientSocket;

	public ClientNode(String host, int port){
		this.host = host;
		this.port = port;
		this.ipClientSocket = null;
		this.connect();
	}

	private void connect(){
		try {
			this.clientSocket = new Socket(this.host, this.port);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void close(){
		try{
		this.clientSocket.close();
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

	public InputStream getInputStream(){
		try {
		return this.clientSocket.getInputStream();
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	public OutputStream getOutputStream(){
		try{
		return this.clientSocket.getOutputStream();
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	public InetAddress getIpMySock(){
		this.ipClientSocket = this.clientSocket.getInetAddress();
		return this.ipClientSocket;
	}
}
