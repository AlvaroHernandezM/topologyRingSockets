package test;

import logic.*;
import java.net.*;
import java.io.*;

public class ClientMain{

	public static void main(String[] args){

	ClientNode client = new ClientNode("localhost",12345);
	Message message = new Message("Hola Álvaro...","2ndo: espero estés bien." );
	client.sendMessage(message);
	client.close();
	}
}
