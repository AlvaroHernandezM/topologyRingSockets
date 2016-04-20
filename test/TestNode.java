package test;

import logic.*;
import java.lang.Integer.*;

public class TestNode{

public static void main(String[] args){

	if(Integer.parseInt(args[0]) == 1){
		Node node1 = new Node(4545, 5332, "192.168.0.25");
		node1.listenServer();
		node1.connectClient();
	}
	if(Integer.parseInt(args[0]) == 2){
		Node node2 = new Node(5332, 6776, "192.168.0.27");
		node2.listenServer();
		node2.connectClient();
	}

	if(Integer.parseInt(args[0]) == 3){
		Node node3 = new Node(6776, 4545, "192.168.0.19");
		node3.listenServer();
		node3.connectClient();
	}
}
}
