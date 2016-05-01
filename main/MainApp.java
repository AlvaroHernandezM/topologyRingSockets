package main;

import logic.*;

public class MainApp{

	public static void main(String[] args){

		//args[0] -> nodo al que se conecta
		//args[1] -> true o false (isServerData)
		String host = args[0];
		boolean isServerData = args[1].equals("true") ? true : false;
		Node node = new Node(6776,6776,host,isServerData);
		while(true){
				if(node.isListenServer() && node.isConnectClient()){
					node.setFlag(true);
					if(! isServerData){
						node.runGenerateMessage();
						try{
							Thread.sleep(10000);
						} catch (InterruptedException e){
							System.out.println(e.getMessage());
						}
					}
				} else {
					node.setFlag(false);
					if(! isServerData){
						node.stopGenerateMessage();	
					}
				}
		}
	}

}
