package test;

import logic.*;
import java.net.*;
import java.io.*;

public class ClientMain{

	public static void main(String[] args){

	ClientNode client = new ClientNode("192.168.0.18",9999);
//	DataOutputStream outputData = new DataOutputStream(client.getOutputStream());
//	try{
//	outputData.writeUTF("Hola álvaro");
//	outputData.close();
//	} catch (IOException e){
//		e.printStackTrace();
//	}
//	client.close();
	}
}
