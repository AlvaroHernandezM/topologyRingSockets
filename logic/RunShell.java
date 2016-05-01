package logic;

import java.io.*;
import java.util.*;

public class RunShell implements Runnable{

	private Process p;
	private String command;
	private String[] answerCommand;
	private BufferedReader reader;

	public RunShell(String command){
		this.command = command;
		//System.out.println("voy a ejectura: "+command);
		this.answerCommand = new String[200];
	}

	public void runProcess(){
		
		//Ejectura un commando y espera que haya resultado bien
		try{
		System.out.println("Se va a ejectura el proceso"+this.command);
		this.p = Runtime.getRuntime().exec(this.command);
		System.out.println("esperando por el comando");
		this.p.waitFor();
		System.out.println("ya lo pase");
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	public String[] getLines(){
		this.reader = new BufferedReader(new InputStreamReader(this.p.getInputStream()));
		String line = "";
		int count = 0;
		try{
			while((line = this.reader.readLine()) != null){
				this.answerCommand[count] = line;
				count += 1;
			}
			return this.answerCommand;
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	public String[] getInformation(String host){
		this.runProcess();
		String[] auxLines = new String[200];
		String[] messages = new String[200];
		auxLines = this.getLines();
		int size = auxLines.length;
		for(int i=0; i<size; i++){
                        if(auxLines[i] != null){
                         String[] temp;
                        temp = auxLines[i].split(";", 3);
				if(host.equals(temp[0])){
				messages[i] = "Mensaje: "+temp[1]+" - Hora: "+temp[2];
				}
                        }
                }
		return messages;
	}

	/*
	public String[] getInformation(String host, String hostServerData){
		System.out.println("Ya entre");
		this.runProcess("ssh arhm-server-4@192.168.0.21");
		System.out.println("Ya pase el primer proceso");
		this.runProcess("mkdir estuveaqui");
		System.out.println("Ya crre la carppeta");
		this.runProcess("cat testJava/topologyRingWithSockets/serverData.txt");
		this.runProcess("exit");
		String[] auxLines = new String[200];
		String[] messages = new String[200];
		auxLines = this.getLines();
		int size = auxLines.length;
		for(int i=0; i<size; i++){
                        if(auxLines[i] != null){
                         String[] temp;
                        temp = auxLines[i].split(";", 3);
				if(host.equals(temp[0])){
				messages[i] = "Mensaje: "+temp[1]+" - Hora: "+temp[2];
				}
                        }
                }
		return messages;
	}*/

	@Override
	public void run(){
		 this.runProcess();
	}
}
