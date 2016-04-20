package logic;
import java.io.Serializable;

public class Message implements Serializable{

	private String message1;
	private String message2;

	public Message(String message1, String message2){
		this.message1 = message1;
		this.message2 = message2;
	}

	public Message(String message1){
		this.message1 = message1;
		this.message2 = "No tengo nada :( ";
	}

	public String getMessage1(){
		return this.message1;
	}
	public String getMessage2(){
		return this.message2;
	}

	public void setMessage1(String message1){
		this.message1 = message1;
	}
	public void setMessage2(String message2){
		this.message2 = message2;
	}
}
