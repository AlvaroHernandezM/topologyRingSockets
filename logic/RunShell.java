package logic;

import java.io.*;
import java.util.*;

public class RunShell {

	private Process p;
	private String command;
	private String[] answerCommand;
	private BufferedReader reader;

	public RunShell(){
		this.command = "";
		this.answerCommand = new String[200];
		this.p = null;
	}

	public void runProcess(String command){
		this.command = command;
		//Ejectura un commando y espera que haya resultado bien
		try{
		this.p = Runtime.getRuntime().exec(this.command);
		this.p.waitFor();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	public String[] getLines(){
		this.reader = new BufferedReader(new InputStreamReader(this.p.getInputStream()));
		String line = "";
		int count = 0;
		try{
			while((line = reader.readLine()) != null){
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
		this.runProcess("cat serverData.txt");
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
}