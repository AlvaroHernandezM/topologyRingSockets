package logic;

import java.lang.*;

public class ExampleRunnable implements Runnable{

	int num;
	String name;
	int speed;
	boolean flag;

	public ExampleRunnable(int num, String name, int speed){
		this.num = num;
		this.name = name;
		this.flag=true;
		this.speed = speed;
	}

	public void setFlag(boolean flag){
		this.flag = flag;
	}
	@Override
	public void run(){
		while(flag){
		try{
			Thread.sleep(this.speed);
		} catch (InterruptedException e){
			System.out.println(e.getMessage());
			}
		this.num += 1;
		System.out.println("Valor: "+this.num+" del hilo: "+this.name);
		}
	}
}
