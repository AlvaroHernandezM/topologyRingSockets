package logic;

import java.util.*;

public class RandomString{

	char[] characters;
	int cantCharacters;
	String message;

	public RandomString(){
		this.characters = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		this.cantCharacters = 12;
		this.message = "";
	}


	public String getRandomString(){
		for(int i=0; i<this.cantCharacters; i++){
			this.message += characters[new Random().nextInt(60)];
		}
		return this.message;
	}
}
