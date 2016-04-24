package test;

import logic.*;

public class TestFile{


	public static void main(String[] args){

		ManagerFile managerFile = new ManagerFile();
		managerFile.writeFile(new Message());
		managerFile.writeFile(new Message());
		System.out.println("leida1");
		managerFile.readFile("127.0.1.1");
		managerFile.writeFile(new Message());
		System.out.println("leida2");
		managerFile.readFile("127.0.1.1");
		managerFile.writeFile(new Message());
		managerFile.writeFile(new Message());
		managerFile.writeFile(new Message());
		System.out.println("leida3");
		managerFile.readFile("127.0.1.1");
	}

}
