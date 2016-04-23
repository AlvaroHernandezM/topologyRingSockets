package test;

import logic.*;
import java.net.*;
import java.io.*;

public class ServerMain{

	public static void main(String[] args){

		ServerNode server = new ServerNode(12345);
		while(true){
//			System.out.println("Escuchando");
			server.accept();
//			Message message = server.readMessage();
//			System.out.println("El mensaje 1 es: "+message.getMessage1());
//			System.out.println("El mensaje 2 es: "+message.getMessage2());
			server.close();
		}
	}
}
