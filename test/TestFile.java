package test;

import logic.*;

public class TestFile{


	public static void main(String[] args){

		ManagerFile managerFile = new ManagerFile();
		managerFile.createWrite();
		managerFile.writeFile(new Message());
		managerFile.writeFile(new Message());
		managerFile.writeFile(new Message());
		managerFile.writeFile(new Message());
		managerFile.writeFile(new Message());
		managerFile.writeFile(new Message());
		managerFile.closeWrite();
		managerFile.createRead();
		managerFile.readFile("127.0.1.1");

	}

}
