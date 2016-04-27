package logic;

import java.io.*;

public class ManagerFile{


	private String urlFile;
	private BufferedWriter fileOut;
	private BufferedReader fileIn;

	public ManagerFile(String urlFile){
		this.urlFile = urlFile;
		this.fileOut = null;
		this.fileIn = null;
	}

	public void writeFile(Message message){
		try{
			this.fileOut = new BufferedWriter(new FileWriter(new File(this.urlFile), true));
			this.fileOut.write(message.getMyIp()+";"+message.getMessage()+";"+message.getHour());
			this.fileOut.newLine();
			this.fileOut.close();
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

	public String[] readFile(String host){
		File file = new File(this.urlFile);
		if(file.exists()){
			try{
				this.fileIn = new BufferedReader(new FileReader(new File(this.urlFile)));
				String line = null;
				String[] messages = new String[200];
				int size = messages.length;
				int count = 0;
//				System.out.println("********* INFORMACIÓN DE IP: "+host+" ***********");
				while( ((line = this.fileIn.readLine()) != null) && (count < size)){
					String[] temp;
					temp = line.split(";", 3);
					if(host.equals(temp[0])){
						messages[count] = "Mensaje: "+temp[1]+" - Hora: "+temp[2];
//						System.out.println("Mensaje: "+temp[1]+" - Hora: "+temp[2]);
					}
					count += 1;
				}
				this.fileIn.close();
				return messages;
			} catch (IOException e){
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("El .txt de "+host+" aún no se ha creado");
			return null;
		}
		return null;
	}
}
