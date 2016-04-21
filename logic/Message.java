package logic;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.net.*;
import java.lang.*;
import java.util.*;

public class Message implements Serializable{

	private String message;
	private String hour;
	private String myIp;
	private InetAddress address;

	public Message(){
		this.message = this.generateString();
		this.hour = this.getValueHour();
		this.myIp = this.getIp();
		this.address = null;
	}

	private String getValueHour(){
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(cal.getTime()).toString();
	}

	private String generateString(){
		RandomString randomString = new RandomString();
		return randomString.getRandomString();
	}

	private String getIp(){
		try{
                this.address = InetAddress.getLocalHost();
                } catch (UnknownHostException e){
                        System.out.println(e.getMessage());
                }
                return address.getHostAddress();
	}

	public String getMessage(){
		return this.message;
	}
	public String getHour(){
		return this.hour;
	}
	public String getMyIp(){
		return this.myIp;
	}
}
