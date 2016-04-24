package logic;
import java.io.*;
import java.text.SimpleDateFormat;
import java.net.*;
import java.lang.*;
import java.util.*;

public class Message implements Serializable{

	private String message;
	private String hour;
	private String myIp;
	private InetAddress address;
	private URL url;

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
		try {
		    	Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		   	 while (interfaces.hasMoreElements()) {
		        NetworkInterface iface = interfaces.nextElement();
		        if (iface.isLoopback() || !iface.isUp() || iface.isVirtual() || iface.isPointToPoint())
		         continue;
		     	 Enumeration<InetAddress> addresses = iface.getInetAddresses();
		       	 while(addresses.hasMoreElements()) {
		            InetAddress addr = addresses.nextElement();
	        	    String ip = addr.getHostAddress();
	        	    if(Inet4Address.class == addr.getClass()) return ip;
		       	 }
    			}
		} catch (SocketException e) {
	    		throw new RuntimeException(e);
		}
		return null;
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

	public String getMessageAll(){
		return  "Mensaje: "+this.message+". Hora: "+this.hour+". IP: "+this.myIp;
	}
}
