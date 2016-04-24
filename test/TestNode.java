package test;

import logic.*;
import java.lang.Integer.*;

public class TestNode{

public static void main(String[] args){

	if(Integer.parseInt(args[0]) == 1){
		Node node1 = new Node(6776, 6776, "192.168.0.27", false);
		while(true){
			if(node1.isListenServer() && node1.isConnectClient()){
			node1.setFlag(true);
			node1.runGenerateMessage();
			} else {
				node1.setFlag(false);
				node1.stopGenerateMessage();
			}
		}
//		node1.listenServer();
//		node1.connectClient();
	}
	if(Integer.parseInt(args[0]) == 2){
		Node node2 = new Node(6776, 6776, "192.168.0.29", false);
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
		Node node3 = new Node(6776, 6776, "192.168.0.21", false);
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
		Node node4 = new Node(6776, 6776, "192.168.0.26", true);
		while(true){
			if(node4.isListenServer() && node4.isConnectClient()){
			node4.setFlag(true);
			node4.runShowInformation("192.168.0.26");
			} else {
				node4.setFlag(false);
				node4.stopShowInformation();
			}
		}

//		node3.listenServer();
//		node3.connectClient();
	}

}
}
