package test;

import logic.*;
import java.lang.*;

public class TestRunnable{


	public static void main(String[] args){
		Thread t1 = new Thread(new ExampleRunnable(5,"Soy el hilo 1", 2000));
		Thread t2 = new Thread(new ExampleRunnable(3,"Soy el hilo 2", 3000));
		t1.start();
		t2.start();
	}
}
