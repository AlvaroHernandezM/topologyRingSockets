package test;

import java.io.*;
import java.util.*;
import logic.*;

class TestRunShell {
    public static void main(String[] args) throws Exception {

		RunShell shell;
		shell = new RunShell("sh compile.sh");
		shell.runProcess();
//		thread.start();
		shell = new RunShell("java main.MainApp 192.168.0.17 false &");
		Thread thread = new Thread(shell);

		//thread = new Thread
		//shell.runProcess();
		thread.start();

		System.out.println("ya segui alvarito");		
		/*String[] aux = new String[200];
		int size = aux.length;
		for(int i=0; i<size; i++){
			if(aux[i] != null){
			System.out.println(aux[i]);
			}
		}*/
    }
}
