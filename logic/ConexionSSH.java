package logic;

import java.io.InputStream;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

    public class ConexionSSH{

	private String host;
	private int port;
	private String user;
	private String password;
	private String command;
	private java.util.Properties config;
	private Session session;
	private JSch jsch;
	private Channel channel;

	public ConexionSSH(String host, String user, String password, String command){
		this.host = host;
		this.port = 22;
		this.user = user;
		this.password = password;
		this.command = command;
		this.executeCommand();
	}

	private void executeCommand(){
		this.connect();
		this.execute();
	}

	private void connect(){
	    try{
	    this.config = new java.util.Properties();
            this.config.put("StrictHostKeyChecking","no");
	    this.jsch = new JSch();
            this.session = this.jsch.getSession(this.user, this.host, this.port);
            this.session.setPassword(this.password);
            this.session.setConfig(this.config);
            this.session.connect();
            System.out.println("Connected");
	    } catch (Exception e){
		System.out.println(e.getMessage());
	    }
	}

	private void execute(){
            try {
            this.channel = this.session.openChannel("exec");
            ((ChannelExec) this.channel).setCommand(this.command);
	    this.channel.setInputStream(null);
            ((ChannelExec) this.channel).setErrStream(System.err);
            InputStream in = this.channel.getInputStream();
            this.channel.connect();
            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0)
                        break;
                        System.out.print(new String(tmp, 0, i));
                }
                if (this.channel.isClosed()) {
                    System.out.println("exit-status: " + this.channel.getExitStatus());
                    break;
                }
                try {
                     Thread.sleep(1000);
                } catch (Exception ee) {}
            }
	    this.disconnectAll();
            } catch (Exception e) {
		System.out.println(e.getMessage());
	    }
	}

	private void disconnectAll(){
		this.disconnectChannel();
		this.disconnectSession();
		System.out.println("Desconectado: bien");
	}

	private void disconnectChannel(){
		try{
		this.channel.disconnect();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	private void disconnectSession(){
		try{
		this.session.disconnect();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}
