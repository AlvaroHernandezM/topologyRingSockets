package logic;

import logic.*;

public class ShowInformationRunnable implements Runnable{

	private boolean flag;
	private String hostRead;
//	private Message message;

	public ShowInformationRunnable(){
		this.flag = false;
	}

	public void setFlag(boolean flag, String hostRead){
		this.hostRead = hostRead;
		this.flag = flag;
	}

	public void setHost(String hostRead){
		this.hostRead = hostRead;
	}

	public void setFlag(boolean flag){
		this.flag = flag;
	}

	public boolean getFlag(){
		return this.flag;
	}

	@Override
	public void run(){
	while(true){
		while(this.flag){
			try{
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
//			this.message = new Message();
			//leer información desde el archivo de texto en un host especifico
		}
	}
	}
}