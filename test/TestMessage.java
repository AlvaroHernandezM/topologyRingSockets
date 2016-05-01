package test;

import logic.*;

public class TestMessage{

	public static void main(String[] args){
		Message message1 = new Message();
		Message message2 = new Message();
		System.out.println("1.1: "+message1.getMessage());
		System.out.println("2.1: "+message2.getMessage());
		System.out.println("1.2: "+message1.getHour());
		System.out.println("2.2: "+message2.getHour());
		System.out.println("1.3: "+message1.getMyIp());
		System.out.println("2.3: "+message2.getMyIp());
	}
}
