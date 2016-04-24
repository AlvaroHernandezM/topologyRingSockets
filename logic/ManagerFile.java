package logic;

import java.io.*;

public class ManagerFile{

	private String urlFile;
	private BufferedWriter fileOut;
	private BufferedReader fileIn;

	public ManagerFile(){
		this.urlFile = "serverData.txt";
		this.fileOut = null;
		this.fileIn = null;
	}

	public void createWrite(){
		try{
		this.fileOut = new BufferedWriter(new FileWriter(new File(this.urlFile)));
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

	public void writeFile(Message message){
		try{
			this.fileOut.write(message.getMyIp()+";"+message.getMessage()+";"+message.getHour());
			this.fileOut.newLine();
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

	public void closeWrite(){
		try{
		this.fileOut.close();
		} catch (IOException e){
			e.getMessage();
		}
	}

	public void createRead(){
		if(! (new File(this.urlFile)).exists() ){
			System.out.println("No se ha encontrado el fichero");
		} else {
			try{
			this.fileIn = new BufferedReader(new FileReader(new File(this.urlFile)));
			} catch (IOException e){
				System.out.println(e.getMessage());
			}
		}
	}

	public void readFile(String host){
		try{
			String line = null;
			while((line = this.fileIn.readLine()) != null){
				String[] temp;
				temp = line.split(";", 3);
				if(host.equals(temp[0])){
					System.out.println("Mensaje: "+temp[1]+" - Hora: "+temp[2]);
				}
			}
			this.fileIn.close();
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

}
