package test;

import logic.*;

public class TestFile{


	public static void main(String[] args){

		ManagerFile managerFile = new ManagerFile("serverData.txt");
		managerFile.writeFile(new Message());
		managerFile.writeFile(new Message());
		System.out.println("leida1");
		String[] aux = new String[200];
		int read = 20;
		aux = managerFile.readFile("192.168.0.19");
		for (int i=0; i < read; i++){
			if(aux[i] != null){
			System.out.println(aux[i]);
			}
		}
		managerFile.writeFile(new Message());
		System.out.println("leida2");
		aux = managerFile.readFile("192.168.0.19");
		for (int i=0; i < read; i++){
			if(aux[i] != null){
			System.out.println(aux[i]);
			}
		}
		managerFile.writeFile(new Message());
		managerFile.writeFile(new Message());
		managerFile.writeFile(new Message());
		System.out.println("leida3");
		aux = managerFile.readFile("192.168.0.19");
		for (int i=0; i < read; i++){
			if(aux[i] != null){
			System.out.println(aux[i]);
			}
		}
	}

}
