package test;

import java.io.*;
import java.util.*;
import logic.*;

class TestRunShell {
    public static void main(String[] args) throws Exception {

		RunShell shell = new RunShell();
		String[] aux = new String[200];
		aux = shell.getInformation("192.168.0.19");
		int size = aux.length;
		for(int i=0; i<size; i++){
			if(aux[i] != null){
			System.out.println(aux[i]);
			}
		}
    }
}
