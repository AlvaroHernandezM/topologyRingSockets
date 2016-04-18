package test;

import logic.*;
import java.net.*;
import java.io.*;

public class ServerMain{

	public static void main(String[] args){

		ServerNode server = new ServerNode(9999);
		while(true){
			System.out.println("Escuchando");
			server.accept();
			//DataInputStream inputData = new DataInputStream(server.getInputStream());
//			try{
//			String message = inputData.readUTF();
//			System.out.println("El mmensaje desde "+server.getIpMySock()+" fue enviado a: "+server.getIpAddress()+" es: "+message);
//			} catch (IOException e){
//				System.out.println(e.getMessage());
//			}
			server.close();
		}
	}
}
