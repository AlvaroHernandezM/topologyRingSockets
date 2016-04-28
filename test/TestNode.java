package test;

import logic.*;
import java.lang.*;

public class TestNode{

public static void main(String[] args){

	if(Integer.parseInt(args[0]) == 1){
		Node node1 = new Node(6776, 6776, "192.168.0.27", false);
//		RunShell runShell = new RunShell();
		while(true){
			if(node1.isListenServer() && node1.isConnectClient()){
				node1.setFlag(true);
				node1.runGenerateMessage();
				try{
					Thread.sleep(10000);
				} catch (InterruptedException e){
					System.out.println(e.getMessage());
				}
			String host = "192.168.0.21";
            		String user = "arhm-server-4";
	        	 String password = "cc1052407351";
		         String command = "cd testJava/topologyRingWithSockets/; cat serverData.txt";
			ConexionSSH conexion = new ConexionSSH(host,user,password, command);
			String[] aux = new String[200];
		        aux = conexion.getMessages();
		        int size = aux.length;
	                for (int i=0; i < size; i++){
						if(aux[i] != null){
           					 System.out.println(aux[i]);                
           				 }	
                     }

//			String[] aux = new String[200];
//			aux = runShell.getInformation("192.168.0.27","192.168.0.21");
//			int size = aux.length;
//			for(int i=0; i<size; i++){
//	       			 if(aux[i] != null){
//                	       	 System.out.println(aux[i]);
//       	               		 }
//	                }
			} else {
				node1.setFlag(false);
				node1.stopGenerateMessage();
			}
		}
//		node1.listenServer();
//		node1.connectClient();
	}
	if(Integer.parseInt(args[0]) == 2){
		Node node2 = new Node(6776, 6776, "192.168.0.16", false);
		while(true){
			if(node2.isListenServer() && node2.isConnectClient()){
			node2.setFlag(true);
			node2.runGenerateMessage();
			} else {
				node2.setFlag(false);
				node2.stopGenerateMessage();
			}
		}

//		node2.listenServer();
//		node2.connectClient();
	}

	if(Integer.parseInt(args[0]) == 3){
		Node node3 = new Node(6776, 6776, "192.168.0.21",false);
		while(true){
			if(node3.isListenServer() && node3.isConnectClient()){
			node3.setFlag(true);
			node3.runGenerateMessage();
			} else {
				node3.setFlag(false);
				node3.stopGenerateMessage();
			}
		}

//		node3.listenServer();
//		node3.connectClient();
	}

	if(Integer.parseInt(args[0]) == 4){
		Node node4 = new Node(6776, 6776, "192.168.0.25", true);
//		RunShell runShell = new RunShell();
		while(true){
			if(node4.isListenServer() && node4.isConnectClient()){
			node4.setFlag(true);
//			try{
//				Thread.sleep(10000);
//			} catch (InterruptedException e){
//				System.out.println(e.getMessage());
//			}
//			String[] aux = new String[200];
//			aux = runShell.getInformation("192.168.0.27");
//			int size = aux.length;
//			for(int i=0; i<size; i++){
//                       		 if(aux[i] != null){
//                	        System.out.println(aux[i]);
//        	                }
//	                }
//			node4.runShowInformation("192.168.0.27");
			} else {
				node4.setFlag(false);
//				node4.stopShowInformation();
			}
		}

//		node3.listenServer();
//		node3.connectClient();
	}

}
}
